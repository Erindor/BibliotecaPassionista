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
import model.Subarea;
import tools.DAOBaseJDBC;

/**
 *
 * @author Bruno
 */
public class SubareaDAOJDBC extends DAOBaseJDBC implements SubareaDAO{
    
    public SubareaDAOJDBC(){
        
    }

    @Override
    public boolean verificarCodigoExistente(String codigo) {
        System.out.println("Verificando se existe o código (" + codigo + ") da subarea na base de dados");
        PreparedStatement stmt;
        boolean sucesso = false;
        String sql = "SELECT 1 FROM Subarea WHERE UCASE(codigo_subarea) like UPPER(?)";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigo);
            
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                sucesso = true;
            }
            stmt.close();
            rset.close();
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao verificar codigo da subarea na base de dados:");
            System.out.println("Classe: SubareaDAODBC");
            System.out.println("Metodo: verificarCodigoExistente()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean salvarSubarea(Subarea subarea) {
        System.out.println("Salvando subarea(" + subarea.getNome_subarea()+ ") no banco de dados:");
        PreparedStatement stmt;
        String sql = "INSERT INTO Subarea (codigo_subarea, nome_subarea) VALUES (?,?)";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subarea.getCodigo_subarea());
            stmt.setString(2, subarea.getNome_subarea());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("\nErro ao salvar subarea na base de dados:");
            System.out.println("Classe: SubareaDAODBC");
            System.out.println("Metodo: salvarSubarea()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
        
    }

    @Override
    public List<Subarea> recuperarSubareasNome(String nome, int nPagina, int qtdRegistros, boolean isPaginacao) {
        System.out.println("Iniciando recuperação dos subáreas, pesquisa por: [" + nome + "]");
        PreparedStatement stmt;
        List<Subarea> subareasRecuperadas = null;      
        
        
        try {
            if (isPaginacao){
                int paginacao = ((nPagina - 1) * qtdRegistros);
                String sql = "SELECT * FROM Subarea WHERE UCASE(nome_subarea) like UPPER(?) ORDER BY idSubarea OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + nome + "%");
                stmt.setInt(2, paginacao);
                stmt.setInt(3, qtdRegistros);
            } else{
                String sql = "SELECT * FROM Subarea WHERE UCASE(nome_subarea) like UPPER(?) ORDER BY idSubarea";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + nome + "%");
            }
            
            ResultSet rset = stmt.executeQuery();
            subareasRecuperadas = new ArrayList<Subarea>();
            
            while (rset.next()){
                Subarea subarea = new Subarea(rset.getInt("idSubarea"), rset.getString("codigo_subarea"),
                        rset.getString("nome_subarea"));
                subareasRecuperadas.add(subarea);
            }
            
            stmt.close();
            rset.close();
            System.out.println("Subáreas recuperadas com sucesso da base de dados");
            
            return subareasRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar subareas pelo nome:");
            System.out.println("Classe: SubareaDAODBC");
            System.out.println("Metodo: recuperarSubareasNome()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }

    public List<Subarea> recuperarSubareasCodigo(String codigo, int nPagina, int qtdRegistros, boolean isPaginacao) {
        System.out.println("Iniciando recuperação dos subáreas, pesquisa por: [" + codigo + "]");
        PreparedStatement stmt;
        List<Subarea> subareasRecuperadas = null;
        String sql = "";  
        
        try {
            if (isPaginacao){
                int paginacao = ((nPagina - 1) * qtdRegistros);
                sql = "SELECT * FROM Subarea WHERE UCASE(codigo_subarea) like UPPER(?) ORDER BY idSubarea OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + codigo + "%");
                stmt.setInt(2, paginacao);
                stmt.setInt(3, qtdRegistros);
            } else{
                sql = "SELECT * FROM Subarea WHERE UCASE(codigo_subarea) like UPPER(?) ORDER BY idSubarea";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + codigo + "%");
            }
            
            ResultSet rset = stmt.executeQuery();
            subareasRecuperadas = new ArrayList<Subarea>();
            
            while (rset.next()){
                Subarea subarea = new Subarea(rset.getInt("idSubarea"), rset.getString("codigo_subarea"),
                        rset.getString("nome_subarea"));
                subareasRecuperadas.add(subarea);
            }
            
            stmt.close();
            rset.close();
            System.out.println("Subáreas recuperadas com sucesso da base de dados");
            
            return subareasRecuperadas;
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar subareas pelo nome:");
            System.out.println("Classe: SubareaDAODBC");
            System.out.println("Metodo: recuperarSubareasNome()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean subareaHasLivro(Subarea subarea) {
        PreparedStatement stmt;
        boolean sucesso = false;
        String sql = "SELECT 1 as qtd FROM Livro WHERE idSubarea = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, subarea.getId_subrea());
            
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                sucesso = true;
            
            return sucesso;
        } catch (SQLException ex) {
            System.out.println("\nErro ao verificar se subárea (" + subarea.getId_subrea() + ") possui livros:");
            System.out.println("Classe: SubareaDAOJDBC");
            System.out.println("Metodo: subareaHasLivro()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean excluirSubarea(Subarea subarea) {
        System.out.println("Iniciando exclusão da subárea: [" + subarea.getId_subrea() + "]");
        PreparedStatement stmt;
        String sql = "DELETE FROM Subarea WHERE idSubarea = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, subarea.getId_subrea());
            
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("\nErro ao deletar autor (" + subarea.getId_subrea() + "):");
            System.out.println("Classe: SubareaDAOJDBC");
            System.out.println("Metodo: excluirSubarea()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean atualizarSubarea(Subarea subarea) {
        System.out.println("Iniciando atualização da subárea: [" + subarea.getId_subrea() + "]");
        PreparedStatement stmt;
        String sql = "UPDATE Subarea SET nome_subarea = ?, codigo_subarea = ? WHERE idSubarea = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subarea.getNome_subarea());
            stmt.setString(2, subarea.getCodigo_subarea());
            stmt.setInt(3, subarea.getId_subrea());
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Subárea atualizado com sucesso!");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar subárea (" + subarea.getId_subrea() + "):");
            System.out.println("Classe: SubareaDAOJDBC");
            System.out.println("Metodo: atualizarSubarea()");
            System.out.println("MSG: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Subarea recuperarSubareaPorID(int ID) {
        PreparedStatement stmt;
        String sql = "SELECT * FROM Subarea WHERE idSubarea = ?";
        Subarea subareaEncontrada = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                subareaEncontrada = new Subarea(rset.getInt("idSubarea"), rset.getString("codigo_subarea"),
                        rset.getString("nome_subarea"));                
            }
            stmt.close();
            rset.close();
            return subareaEncontrada;
            
        } catch (SQLException ex) {
            System.out.println("\nErro ao recuperar subárea por id (" + ID + "):");
            System.out.println("Classe: SubareaDAOJDBC");
            System.out.println("Metodo: recuperarSubareaPorID()");
            System.out.println("MSG: " + ex.getMessage());
            return null;
        }
    }
    
    public Subarea recuperarSubareaPorCodigoIdentico (String codigo){
        PreparedStatement stmt;
        Subarea subareaEncontrada = null;
        String sql = "SELECT * FROM Subarea WHERE Codigo_Subarea = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                subareaEncontrada = new Subarea(rset.getInt("idSubarea"), rset.getString("codigo_subarea"),
                        rset.getString("nome_subarea"));
            }
            stmt.close();
            rset.close();
            return subareaEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(SubareaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int totalListadoNomeSubarea(String texto) {
        PreparedStatement stmt;
        String sql = "SELECT COUNT(1) as qtd FROM Subarea WHERE UCASE(nome_subarea) like UPPER(?)";
        int qtd = 0;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + texto + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                qtd = rset.getInt("qtd");
            stmt.close();
            rset.close();
            return qtd;
        } catch (SQLException ex) {
            Logger.getLogger(SubareaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public int totalListadoCodigoSubarea(String texto) {
        PreparedStatement stmt;
        String sql = "SELECT COUNT(1) as qtd FROM Subarea WHERE UCASE(codigo_subarea) like UPPER(?)";
        int qtd = 0;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + texto + "%");
            ResultSet rset = stmt.executeQuery();
            if (rset.next())
                qtd = rset.getInt("qtd");
            stmt.close();
            rset.close();
            return qtd;
        } catch (SQLException ex) {
            Logger.getLogger(SubareaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    
}
