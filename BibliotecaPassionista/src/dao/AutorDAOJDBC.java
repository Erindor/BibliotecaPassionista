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
import tools.DAOBaseJDBC;

/**
 *
 * @author Bruno
 */
public class AutorDAOJDBC extends DAOBaseJDBC implements AutorDAO{

    public AutorDAOJDBC() {
    }   
    
    @Override
    public int getIDValido() {
        PreparedStatement stmt;
        int idValido = -1;
        
        String sql = "SELECT COUNT(idAutor) as id from autor";
        
        try {
            stmt = conn.prepareCall(sql);
            ResultSet rset = stmt.executeQuery();
            
            if (rset.next()){
                idValido = rset.getInt("id") + 1;
            }
            
            stmt.close();
            rset.close();
            return idValido;
            
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar id valido:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: getIDValido()");
            System.out.println("MSG: " + ex.getMessage());
            return -1;
        }
    }

    @Override
    public boolean salvalAutor(Autor autor) {
        PreparedStatement stmt;
        boolean sucesso = false;
        String sql = "INSERT INTO Autor (nome_autor, email_autor, site_autor) VALUES"
                + " (?,?,?)";
        
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, autor.getNome_autor());
            stmt.setString(2, autor.getEmail_autor());
            stmt.setString(3, autor.getSite_autor());
            
            stmt.executeUpdate();
            stmt.close();
            sucesso = true;
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao salvar autor na base de dados:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: salvarAutor()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean hasAutorbyNome(String nome_autor) {
        PreparedStatement stmt;
        boolean sucesso = false;
        String sql = "SELECT * from Autor WHERE UCASE(nome_autor) like UPPER(?)";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome_autor + "%");
            ResultSet rset = stmt.executeQuery();
            
            if(rset.next()){
                sucesso = true;
            }
            
            stmt.close();
            rset.close();
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao verificar se existe nome do autor na base de dados:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: hasAutorbyNome()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
        
    }

    @Override
    public List<Autor> recuperarAutores(String nome_autor, int nPagina, int qtdRegistros) {
        System.out.println("Iniciando recuperação dos autores, pesquisa por: [" + nome_autor + "]");
        PreparedStatement stmt;
        List<Autor> autores_recuperados = null;
        
        //String sql = "SELECT * FROM Autor WHERE UCASE(nome_autor) like UPPER(?)";
        String sql = "SELECT * FROM Autor WHERE UCASE(nome_autor) like UPPER(?) ORDER BY idAutor OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        int paginacao = ((nPagina - 1) * qtdRegistros);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome_autor + "%");
            stmt.setInt(2, paginacao);
            stmt.setInt(3, qtdRegistros);
            
            ResultSet rset = stmt.executeQuery();
            autores_recuperados = new ArrayList<Autor>();
            
            while (rset.next()){
                Autor autor = new Autor(rset.getInt("idAutor"), rset.getString("nome_autor"));
                autor.setEmail_autor(rset.getString("email_autor"));
                autor.setSite_autor(rset.getString("site_autor"));  
                autores_recuperados.add(autor);
            }
            
            stmt.close();
            rset.close();
            System.out.println("Autores recuperados com sucesso da base de dados");
            
            return autores_recuperados;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar autores pelo nome:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: recuperarAutores()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Autor> recuperarAutoresSemPaginacao(String nome_autor) {
        System.out.println("Iniciando recuperação dos autores, pesquisa por: [" + nome_autor + "]");
        PreparedStatement stmt;
        List<Autor> autores_recuperados = null;
        
        //String sql = "SELECT * FROM Autor WHERE UCASE(nome_autor) like UPPER(?)";
        String sql = "SELECT * FROM Autor WHERE UCASE(nome_autor) like UPPER(?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome_autor + "%");
            
            ResultSet rset = stmt.executeQuery();
            autores_recuperados = new ArrayList<Autor>();
            
            while (rset.next()){
                Autor autor = new Autor(rset.getInt("idAutor"), rset.getString("nome_autor"));
                autor.setEmail_autor(rset.getString("email_autor"));
                autor.setSite_autor(rset.getString("site_autor"));  
                autores_recuperados.add(autor);
            }
            
            stmt.close();
            rset.close();
            System.out.println("Autores recuperados com sucesso da base de dados");
            
            return autores_recuperados;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar autores pelo nome:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: recuperarAutores()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean excluirAutor(Autor autor_selecionado) {
        System.out.println("Iniciando exclusão do autor: [" + autor_selecionado.getId_autor() + "]");
        PreparedStatement stmt;
        String sql = "DELETE FROM Autor WHERE idAutor = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autor_selecionado.getId_autor());
            
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("\nErro ao deletar autor (" + autor_selecionado.getId_autor() + "):");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: excluirAutor()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean autorHasLivro(Autor autor) {
        PreparedStatement stmt;
        boolean sucesso = false;
        String sql = "SELECT 1 as qtd FROM autor_livro WHERE idAutor = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autor.getId_autor());
            
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                sucesso = true;
            
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao verificar se autor (" + autor.getId_autor() + ") possui livros:");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: autorHasLivro()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizarAutor(Autor autor) {
        System.out.println("Iniciando atualização do autor: [" + autor.getId_autor() + "]");
        PreparedStatement stmt;
        String sql = "UPDATE Autor SET nome_autor = ?, email_autor = ?, site_autor = ? WHERE idAutor = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNome_autor());
            stmt.setString(2, autor.getEmail_autor());
            stmt.setString(3, autor.getSite_autor());
            stmt.setInt(4, autor.getId_autor());
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Autor atualizado com sucesso!");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar autor(" + autor.getId_autor() + "):");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: atualizarAutor()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public Autor recuperarAutorPorID(int ID){
        PreparedStatement stmt;
        String sql = "SELECT * FROM Autor WHERE idAutor = ?";
        Autor autorEncontrado = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                autorEncontrado = new Autor(rset.getInt("idAutor"), rset.getString("nome_autor"));
                autorEncontrado.setEmail_autor(rset.getString("email_autor"));
                autorEncontrado.setSite_autor(rset.getString("site_autor")); 
            }
            stmt.close();
            rset.close();
            return autorEncontrado;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar autor por id(" + ID + "):");
            System.out.println("Classe: AutorDAOJDBC");
            System.out.println("Metodo: recuperarAutorPorID()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }
    
    public Autor recuperarAutorPorNomeIdentico (String nome){
        PreparedStatement stmt;
        Autor autorEncontrado = null;
        
        String sql = "SELECT * FROM Autor WHERE nome_autor = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                autorEncontrado = new Autor(rset.getInt("idAutor"), rset.getString("nome_autor"));
            }
            stmt.close();
            rset.close();
            return autorEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public int totalListadoNome(String nome){
        PreparedStatement stmt;
        int qtd = 0;
        String sql = "SELECT COUNT(1)as qtd FROM Autor WHERE UCASE(nome_autor) like UPPER(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                qtd = rset.getInt("qtd");
            stmt.close();
            rset.close();
            return qtd;
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
}
