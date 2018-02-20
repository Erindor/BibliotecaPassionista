/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author alunodev10
 */
public interface Config {
    public static final String NOME_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String BD_URL = "jdbc:derby:bibliotecaPassioDB;create=true";
    //public static final String BD_URL = "jdbc:derby://localhost:1527/bibliotecaPassio;create=true";
    public static final String BD_LOGIN = "root";
    public static final String BD_SENHA = "123456";
}
