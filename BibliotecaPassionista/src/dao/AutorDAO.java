/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Autor;

/**
 *
 * @author Bruno
 */
public interface AutorDAO {
    public int getIDValido();
    public boolean salvalAutor(Autor autor);
    public boolean hasAutorbyNome(String nome_autor);
    public List<Autor> recuperarAutores(String nome_autor, int nPagina, int qtdRegistros);
    public boolean excluirAutor(Autor autor_selecionado);
    public boolean autorHasLivro(Autor autor);
    public boolean atualizarAutor(Autor autor);
     public List<Autor> recuperarAutoresSemPaginacao(String nome_autor);
     public Autor recuperarAutorPorID(int ID);
}
