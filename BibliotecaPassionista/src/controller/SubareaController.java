/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubareaDAOJDBC;
import java.util.List;
import model.Subarea;
import view.autor.EditarAutor;
import view.subarea.EditarSubarea;

/**
 *
 * @author Bruno
 */
public class SubareaController {
    SubareaDAOJDBC subareaDAO = new SubareaDAOJDBC();
    
    public SubareaController() {
    }

    public boolean verificarCodigoExistente(String codigo){
        return subareaDAO.verificarCodigoExistente(codigo);
    }

    public boolean salvarSubarea(Subarea subarea) throws Exception {
        if (subareaDAO.salvarSubarea(subarea) == false){
            throw new Exception("Houve algum erro ao salvar subárea.");
        }
        return true;
    }
    
    public List<Subarea> recuperarSubareasNome(String nome, int nPagina, int qtdRegistros) throws Exception {
        List<Subarea> resposta = subareaDAO.recuperarSubareasNome(nome, nPagina, qtdRegistros, true);
        if (resposta.size() <= 0){
            throw new Exception("Nenhuma subárea encontrada!");
        }
        else{
            return resposta;
        }
    }

    public List<Subarea> recuperarSubareasCodigo(String codigo, int nPagina, int qtdRegistros) throws Exception {
        List<Subarea> resposta = subareaDAO.recuperarSubareasCodigo(codigo, nPagina, qtdRegistros, true);
        if (resposta.size() <= 0){
            throw new Exception("Nenhuma subárea encontrada!");
        }
        else{
            return resposta;
        }
    }

    public void editarSubarea(Subarea subarea) {
        EditarSubarea editarSubarea = new EditarSubarea(subarea);
        editarSubarea.setVisible(true);
    }

    public boolean excluirSubarea(Subarea subarea) throws Exception {
        if(subareaDAO.subareaHasLivro(subarea) == true){
            throw new Exception("Essa subárea possui livros vinculados. Delete os livros antes de deletar a subárea.");
        }
        else{            
            if (subareaDAO.excluirSubarea(subarea) == false){
                throw new Exception("Houve algum erro ao deletar a subárea!");
            }
        }        
        return true;
    }

    public void atualizarSubareaNoBanco(Subarea subarea) throws Exception {
         if(!subareaDAO.atualizarSubarea(subarea)){
            throw new Exception("Erro ao atualizar subarea!");
        }
    }
    
    public List<Subarea> recuperarSubareasNome(String nome, boolean paginacao) throws Exception {
        List<Subarea> resposta = subareaDAO.recuperarSubareasNome(nome, 0, 0, paginacao);
        if (resposta.size() <= 0){
            throw new Exception("Nenhuma subárea encontrada!");
        }
        else{
            return resposta;
        }
    }

    public List<Subarea> recuperarSubareasCodigo(String codigo, boolean paginacao) throws Exception {
        List<Subarea> resposta = subareaDAO.recuperarSubareasCodigo(codigo, 0, 0, paginacao);
        if (resposta.size() <= 0){
            throw new Exception("Nenhuma subárea encontrada!");
        }
        else{
            return resposta;
        }
    }

    public int recuperarTotalListadoNomeSubarea(String texto) {
        int qtd = subareaDAO.totalListadoNomeSubarea(texto);
        if (qtd >= 0)
            return qtd;
        else
            return -1;
    }
    
    public int recuperarTotalListadoCodigoSubarea(String texto) {
        int qtd = subareaDAO.totalListadoCodigoSubarea(texto);
        if (qtd >= 0)
            return qtd;
        else
            return -1;
    }
    
    
    
}
