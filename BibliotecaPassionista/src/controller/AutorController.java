/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AutorDAOJDBC;
import java.util.List;
import javax.swing.JOptionPane;
import model.Autor;
import view.autor.EditarAutor;

/**
 *
 * @author Bruno
 */
public class AutorController {
    AutorDAOJDBC autorDAO = new AutorDAOJDBC();
    
    public int recuperarIDAutorValido(){
        return autorDAO.getIDValido();
    }

    public boolean salvarAutor(Autor a) throws Exception {
        boolean retorno = autorDAO.salvalAutor(a);
        if (retorno == false){
            throw new Exception("Erro ao salvar na base de dados!");
        }
        return retorno;
    }

    public boolean possuiAutorNome(String nome_autor) {
        return autorDAO.hasAutorbyNome(nome_autor);        
    }
    
    public List<Autor> recuperarAutores(String nome_autor, int nPagina, int qtdRegistros) throws Exception{
        List<Autor> resposta = autorDAO.recuperarAutores(nome_autor, nPagina, qtdRegistros);
        if (resposta.size() <= 0){
            throw new Exception("Nenhum autor encontrado!");
        }
        else{
            return resposta;
        }
    }
    
    public List<Autor> recuperarAutoresSemPaginacao(String nome_autor) throws Exception{
        List<Autor> resposta = autorDAO.recuperarAutoresSemPaginacao(nome_autor);
        if (resposta.size() <= 0){
            throw new Exception("Nenhum autor encontrado!");
        }
        else{
            return resposta;
        }
    }

    public boolean excluirAutor(Autor autor_selecionado) throws Exception {
        if(autorDAO.autorHasLivro(autor_selecionado) == true){
            throw new Exception("Esse autor possui livros vinculados. Delete os livros antes de deletar o autor.");
        }
        else{            
            if (autorDAO.excluirAutor(autor_selecionado) == false){
                throw new Exception("Houve algum erro ao deletar o autor!");
            }
        }        
        return true;
    }

    public void editarAutor(Autor autor) {
        EditarAutor editarAutor = new EditarAutor(autor);
        editarAutor.setVisible(true);
    }

    public void atualizarAutorNoBanco(Autor autor) throws Exception {
        if(!autorDAO.atualizarAutor(autor)){
            throw new Exception("Erro ao atualizar autor!");
        }
    }
    
    public int totalListadoNome(String texto){
        int qtd = autorDAO.totalListadoNome(texto);
        if (qtd >= 0)
            return qtd;
        else
            return -1;
    }
}
