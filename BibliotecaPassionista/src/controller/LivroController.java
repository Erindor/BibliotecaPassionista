/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LivroDAOJDBC;
import java.util.List;
import model.Livro;
import view.livro.EditarLivro;

/**
 *
 * @author Bruno
 */
public class LivroController {
    LivroDAOJDBC livroDAO = new LivroDAOJDBC();
    
    public boolean verificarLocacaoExistente(String locacao){
        return livroDAO.verificarLocacaoExistente(locacao);
    }

    public int gerarLocacao(int idSubarea) throws Exception {
        int ultimaLocacao = livroDAO.getUltimoNumeroLocacao(idSubarea);
        if(ultimaLocacao == -1){
            throw new Exception("Houve algum problema a recuperar o último ID da base de dados");
        }
        return ultimaLocacao + 1;
    }

    public boolean salvarLivro(Livro livro) {
        return livroDAO.salvarLivro(livro);
    }

    public List<Livro> recuperarLivrosTitulo(String titulo, int nPagina, int qtdRegistros) throws Exception {
        List<Livro> resposta = livroDAO.recuperarLivrosTitulo(titulo, nPagina, qtdRegistros);
        if (resposta.size() <= 0){
            throw new Exception("Nenhum livro encontrado!");
        }
        else{
            return resposta;
        }
    }

    public List<Livro> recuperarLivrosLocacao(String locacao, int nPagina, int qtdRegistros) throws Exception {
        List<Livro> resposta = livroDAO.recuperarLivrosLocacao(locacao, nPagina, qtdRegistros);
        if (resposta.size() <= 0){
            throw new Exception("Nenhum livro encontrado!");
        }
        else{
            return resposta;
        }
    }

    public boolean excluirLivro(Livro livro) throws Exception {
        if (livroDAO.excluirLivro(livro) == false){
            throw new Exception("Houve algum erro ao deletar o livro!");
        }
        return true;
    }

    public void editarLivro(Livro livro) {
        EditarLivro editarLivro = new EditarLivro(livro);
        editarLivro.setVisible(true);
    }

    public void atualizarLivroNoBanco(Livro livro) throws Exception {
        if(!livroDAO.atualizarLivro(livro)){
            throw new Exception("Erro ao atualizar livro!");
        }
    }

    public List<Livro> recuperarLivrosDoAutor(int id_autor) {
        return livroDAO.recuperarLivrosDoAutor(id_autor);
    }
    
    public List<Livro> recuperarLivrosDaSubarea(int idSubarea) {
        return livroDAO.recuperarLivrosDaSubarea(idSubarea); 
    }
    
    public int totalTitulo(String texto){
        return livroDAO.totalTitulo(texto);
    }
    
    public int totalLocacao(String texto){
        return livroDAO.totalLocacao(texto);
    }
    
}
