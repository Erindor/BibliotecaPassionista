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
public class Livro {
    
    private int id_livro;
    private String titulo_livro;
    private String locacao_livro;
    private int numero_locacao;
    private Autor autor;
    private Subarea subarea;

    public Livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public Livro(int id_livro, String titulo_livro, String locacao_livro) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.locacao_livro = locacao_livro;
    }
    
    public Livro(String tituloLivro, String locacaoLivro, int numeroLocacao, Subarea subarea, Autor autor){
        this.titulo_livro = tituloLivro;
        this.locacao_livro = locacaoLivro;
        this.numero_locacao = numeroLocacao;
        this.subarea = subarea;
        this.autor = autor;
    }

    public int getNumero_locacao() {
        return numero_locacao;
    }

    public void setNumero_locacao(int numero_locacao) {
        this.numero_locacao = numero_locacao;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public String getLocacao_livro() {
        return locacao_livro;
    }

    public void setLocacao_livro(String locacao_livro) {
        this.locacao_livro = locacao_livro;
    }


    public Subarea getSubarea() {
        return subarea;
    }

    public void setSubarea(Subarea subarea) {
        this.subarea = subarea;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
