/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno
 */
public class Subarea {
    private int id_subrea;
    private String codigo_subarea;
    private String nome_subarea;

    public Subarea(int id_subrea) {
        this.id_subrea = id_subrea;
    }

    public Subarea(int id_subrea, String codigo_subarea, String nome_subarea) {
        this.id_subrea = id_subrea;
        this.codigo_subarea = codigo_subarea;
        this.nome_subarea = nome_subarea;
    }

    public Subarea(String codigo, String nome) {
        this.codigo_subarea = codigo;
        this.nome_subarea = nome;
    }

    public int getId_subrea() {
        return id_subrea;
    }

    public void setId_subrea(int id_subrea) {
        this.id_subrea = id_subrea;
    }

    public String getCodigo_subarea() {
        return codigo_subarea;
    }

    public void setCodigo_subarea(String codigo_subarea) {
        this.codigo_subarea = codigo_subarea;
    }

    public String getNome_subarea() {
        return nome_subarea;
    }

    public void setNome_subarea(String nome_subarea) {
        this.nome_subarea = nome_subarea;
    }
    
}
