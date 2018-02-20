/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bruno
 */
public class Autor {
    
    private int id_autor;
    private String nome_autor;
    private String email_autor;
    private String site_autor;

    public Autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public Autor(int id_autor, String nome_autor) {
        this.id_autor = id_autor;
        this.nome_autor = nome_autor;
    }
    
    public Autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }
    
    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getEmail_autor() {
        return email_autor;
    }

    public void setEmail_autor(String email_autor) {
        this.email_autor = email_autor;
    }

    public String getSite_autor() {
        return site_autor;
    }

    public void setSite_autor(String site_autor) {
        this.site_autor = site_autor;
    }
}
