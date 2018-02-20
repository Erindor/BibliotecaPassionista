/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunodev10
 */
public class DAOBaseJDBC {
    protected static Connection conn;
    static{
        try {
            Class.forName(Config.NOME_DRIVER);
            conn = DriverManager.getConnection(Config.BD_URL, Config.BD_LOGIN, Config.BD_SENHA);
        } catch (ClassNotFoundException ex) {
            System.out.println("FATAL: driver não encontrado. ");
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Erro SQL: "+ex.getMessage());
            System.exit(1);
        }
    }
    public static void closeConn() {
       
            try {
                if(conn != null){
                conn.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(DAOBaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    }
    protected java.sql.Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn == null || conn.isClosed()){
            Class.forName(Config.NOME_DRIVER);
            return DriverManager.getConnection(Config.BD_URL, Config.BD_LOGIN, Config.BD_SENHA);
        }
        return conn;
    }
}
