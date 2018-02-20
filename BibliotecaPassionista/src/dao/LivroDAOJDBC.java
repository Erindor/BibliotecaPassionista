/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Livro;
import model.Subarea;
import tools.DAOBaseJDBC;

/**
 *
 * @author Bruno
 */
public class LivroDAOJDBC extends DAOBaseJDBC implements LivroDAO{
    
    public LivroDAOJDBC(){
        
    }

    @Override
    public boolean verificarLocacaoExistente(String locacao) {
        PreparedStatement stmt;
        String sql = "SELECT 1 FROM Livro WHERE UCASE(LOCACAO_LIVRO) LIKE UPPER(?)";
        boolean sucesso = false;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + locacao + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                sucesso = true;
            }
            stmt.close();
            rset.close();
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao verificar locação existente:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: verificarLocacaoExistente()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
        
    }

    @Override
    public int getUltimoNumeroLocacao(int idSubarea) {
        PreparedStatement stmt;
        String sql = "SELECT * FROM LIVRO WHERE IDSUBAREA = ? ORDER BY NUMERO_LOCACAO DESC FETCH FIRST 1 ROWS ONLY";
        int ultimaLocacao = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idSubarea);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                ultimaLocacao = rset.getInt("numero_locacao");
            } else{
                return 0;
            }
            stmt.close();
            rset.close();
            return ultimaLocacao;
            
        } catch (SQLException ex) {
            System.out.println("\nErro recuperar ultimo ID locação:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: getUltimoNumeroLocacao()");
            System.out.println("MSG: " + ex.getMessage());
            return -1;
        }
        
    }

    @Override
    public boolean salvarLivro(Livro livro) {
        PreparedStatement inserirLivroSTMT;
        
        String inserirLivroSQL = "INSERT INTO Livro (titulo_livro, locacao_livro, numero_locacao, idsubarea, idAutor)"
                + "VALUES (?,?,?,?,?)";
        
        try {
            //insere o livro
            inserirLivroSTMT = conn.prepareStatement(inserirLivroSQL);
            inserirLivroSTMT.setString(1, livro.getTitulo_livro());
            inserirLivroSTMT.setString(2, livro.getLocacao_livro());
            inserirLivroSTMT.setInt(3, livro.getNumero_locacao());
            inserirLivroSTMT.setInt(4, livro.getSubarea().getId_subrea());
            inserirLivroSTMT.setInt(5, livro.getAutor().getId_autor());
            inserirLivroSTMT.executeUpdate();
            
            inserirLivroSTMT.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("\nErro ao salvar liro (rollback):");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: salvarLivro()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Livro> recuperarLivrosTitulo(String titulo, int nPagina, int qtdRegistros) {
        System.out.println("Iniciando recuperação dos livros, pesquisa por: [" + titulo + "]");
        PreparedStatement stmt;
        List<Livro> livrosRecuperadas = null;      
        
        
        try {
            int paginacao = ((nPagina - 1) * qtdRegistros);
            String sql = "SELECT * FROM Livro WHERE UCASE(titulo_livro) like UPPER(?) ORDER BY idLivro OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + titulo + "%");
            stmt.setInt(2, paginacao);
            stmt.setInt(3, qtdRegistros);
            
            ResultSet rset = stmt.executeQuery();
            livrosRecuperadas = new ArrayList<Livro>();
            
            AutorDAO autorDAO = new AutorDAOJDBC();
            SubareaDAO subareaDAO = new SubareaDAOJDBC();
            livrosRecuperadas = new ArrayList<Livro>();
            while (rset.next()){
                //pegar o autor do livro
                Autor autor = autorDAO.recuperarAutorPorID(rset.getInt("idAutor"));
                Subarea subarea = subareaDAO.recuperarSubareaPorID(rset.getInt("idSubarea"));
                Livro livro = new Livro(rset.getString("titulo_livro"), rset.getString("locacao_livro"),
                        rset.getInt("numero_locacao"), subarea, autor);
                livro.setId_livro(rset.getInt("idLivro"));
                livrosRecuperadas.add(livro);
            }
            stmt.close();
            rset.close();
            System.out.println("Livros recuperads com sucesso da base de dados");
            
            return livrosRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar livros pelo nome:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: recuperarLivrosTitulo()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Livro> recuperarLivrosLocacao(String locacao, int nPagina, int qtdRegistros) {
        System.out.println("Iniciando recuperação dos livros, pesquisa por: [" + locacao + "]");
        PreparedStatement stmt;
        List<Livro> livrosRecuperadas = null;      
        
        
        try {
            int paginacao = ((nPagina - 1) * qtdRegistros);
            String sql = "SELECT * FROM Livro WHERE UCASE(locacao_livro) like UPPER(?) ORDER BY idLivro OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + locacao + "%");
            stmt.setInt(2, paginacao);
            stmt.setInt(3, qtdRegistros);
            
            ResultSet rset = stmt.executeQuery();
            livrosRecuperadas = new ArrayList<Livro>();
            
            AutorDAO autorDAO = new AutorDAOJDBC();
            SubareaDAO subareaDAO = new SubareaDAOJDBC();
            livrosRecuperadas = new ArrayList<Livro>();
            while (rset.next()){
                //pegar o autor do livro
                Autor autor = autorDAO.recuperarAutorPorID(rset.getInt("idAutor"));
                Subarea subarea = subareaDAO.recuperarSubareaPorID(rset.getInt("idSubarea"));
                Livro livro = new Livro(rset.getString("titulo_livro"), rset.getString("locacao_livro"),
                        rset.getInt("numero_locacao"), subarea, autor);
                livro.setId_livro(rset.getInt("idLivro"));
                livrosRecuperadas.add(livro);
            }
            stmt.close();
            rset.close();
            System.out.println("Livros recuperads com sucesso da base de dados");
            
            return livrosRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar livros pela locação:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: recuperarLivrosLocacao()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean excluirLivro(Livro livro) {
        PreparedStatement stmt;
        String sql = "DELETE FROM Livro WHERE idLivro = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, livro.getId_livro());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("\nErro ao deletar livro (" + livro.getId_livro() + ":");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: excluirLivro()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    public boolean atualizarLivro(Livro livro) {
        System.out.println("Iniciando atualização do livro: [" + livro.getId_livro() + "]");
        PreparedStatement stmt;
        String sql = "UPDATE Livro SET titulo_livro = ?, locacao_livro = ?, numero_locacao = ?,"
                + "idSubarea = ?, idAutor = ? WHERE idLivro = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo_livro());
            stmt.setString(2, livro.getLocacao_livro());
            stmt.setInt(3, livro.getNumero_locacao());
            stmt.setInt(4, livro.getSubarea().getId_subrea());
            stmt.setInt(5, livro.getAutor().getId_autor());
            stmt.setInt(6, livro.getId_livro());
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Livro atualizado com sucesso!");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar Livro:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: atualizarLivro()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Livro> recuperarLivrosDoAutor(int id_autor) {
        PreparedStatement stmt;
        List<Livro> livrosRecuperadas = null;      
        
        
        try {
            String sql = "SELECT * FROM Livro WHERE idAutor = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_autor);
            
            ResultSet rset = stmt.executeQuery();
            livrosRecuperadas = new ArrayList<Livro>();
            
            AutorDAO autorDAO = new AutorDAOJDBC();
            SubareaDAO subareaDAO = new SubareaDAOJDBC();
            livrosRecuperadas = new ArrayList<Livro>();
            while (rset.next()){
                //pegar o autor do livro
                Autor autor = autorDAO.recuperarAutorPorID(rset.getInt("idAutor"));
                Subarea subarea = subareaDAO.recuperarSubareaPorID(rset.getInt("idSubarea"));
                Livro livro = new Livro(rset.getString("titulo_livro"), rset.getString("locacao_livro"),
                        rset.getInt("numero_locacao"), subarea, autor);
                livro.setId_livro(rset.getInt("idLivro"));
                livrosRecuperadas.add(livro);
            }
            stmt.close();
            rset.close();
            System.out.println("Livros recuperads com sucesso da base de dados");
            
            return livrosRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar livros do autor:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: recuperarLivrosDoAutor()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Livro> recuperarLivrosDaSubarea(int idSubarea) {
        PreparedStatement stmt;
        List<Livro> livrosRecuperadas = null;      
        
        
        try {
            String sql = "SELECT * FROM Livro WHERE idSubarea = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idSubarea);
            
            ResultSet rset = stmt.executeQuery();
            livrosRecuperadas = new ArrayList<Livro>();
            
            AutorDAO autorDAO = new AutorDAOJDBC();
            SubareaDAO subareaDAO = new SubareaDAOJDBC();
            livrosRecuperadas = new ArrayList<Livro>();
            while (rset.next()){
                //pegar o autor do livro
                Autor autor = autorDAO.recuperarAutorPorID(rset.getInt("idAutor"));
                Subarea subarea = subareaDAO.recuperarSubareaPorID(rset.getInt("idSubarea"));
                Livro livro = new Livro(rset.getString("titulo_livro"), rset.getString("locacao_livro"),
                        rset.getInt("numero_locacao"), subarea, autor);
                livro.setId_livro(rset.getInt("idLivro"));
                livrosRecuperadas.add(livro);
            }
            stmt.close();
            rset.close();
            System.out.println("Livros recuperads com sucesso da base de dados");
            
            return livrosRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar livros do autor:");
            System.out.println("Classe: LivroDAOJDBC");
            System.out.println("Metodo: recuperarLivrosDoAutor()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }
    
    public int totalTitulo(String titulo){
        PreparedStatement stmt;
        int qtd = 0;
        String sql = "SELECT COUNT(1) as qtd FROM Livro WHERE UCASE(titulo_livro) like UPPER(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                qtd = rset.getInt("qtd");
            stmt.close();
            rset.close();
            return qtd;
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    public int totalLocacao(String titulo){
        PreparedStatement stmt;
        int qtd = 0;
        String sql = "SELECT COUNT(1) as qtd FROM Livro WHERE UCASE(locacao_livro) like UPPER(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                qtd = rset.getInt("qtd");
            stmt.close();
            rset.close();
            return qtd;
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
}
