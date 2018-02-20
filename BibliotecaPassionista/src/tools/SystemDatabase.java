/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class SystemDatabase extends DAOBaseJDBC{
    private int qtdTabelas = 3;
    
    public void createTables(){
        if(this.verificarTabelas() == false){
            String[] sql = {"CREATE TABLE AUTOR(" +
"    IDAUTOR INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"    NOME_AUTOR VARCHAR(100) NOT NULL," +
"    EMAIL_AUTOR VARCHAR(45) NOT NULL," +
"    SITE_AUTOR VARCHAR(45) NOT NULL" +
")", 
            
            "CREATE TABLE SUBAREA(" +
"    IDSUBAREA INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"    NOME_SUBAREA VARCHAR(45) NOT NULL," +
"    CODIGO_SUBAREA VARCHAR(25) NOT NULL" +
")",
            
            "CREATE TABLE LIVRO(" +
"    IDLIVRO INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"    TITULO_LIVRO VARCHAR(100) NOT NULL," +
"    LOCACAO_LIVRO VARCHAR(45) NOT NULL," +
"    NUMERO_LOCACAO VARCHAR(45) NOT NULL," +
"    IDAUTOR INT NOT NULL," +
"    IDSUBAREA INT NOT NULL," +
"    CONSTRAINT FK_AUTOR FOREIGN KEY (IDAUTOR) REFERENCES AUTOR(IDAUTOR)," +
"    CONSTRAINT FK_SUBAREA FOREIGN KEY (IDSUBAREA) REFERENCES SUBAREA(IDSUBAREA)" +
")"};
            
            for (String s : sql){
                PreparedStatement stmt;
                try {
                    stmt = conn.prepareStatement(s);
                    stmt.executeUpdate();
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    private boolean verificarTabelas(){
        PreparedStatement stmt;
        String sql = "SELECT COUNT(1) as qtd FROM sys.systables Where TABLETYPE = 'T'";
        boolean sucesso = false;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                if (this.qtdTabelas == rset.getInt("qtd"))
                    sucesso = true;
            }
            stmt.close();
            rset.close();
            return sucesso;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
