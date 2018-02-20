/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Livro;

/**
 *
 * @author Bruno
 */
public interface LivroDAO {
    public boolean verificarLocacaoExistente(String locacao);
    public boolean salvarLivro(Livro livro);
    public int getUltimoNumeroLocacao(int idSubarea);
    public List<Livro> recuperarLivrosTitulo(String titulo, int nPagina, int qtdRegistros);
    public List<Livro> recuperarLivrosLocacao(String locacao, int nPagina, int qtdRegistros);
    public boolean excluirLivro(Livro livro);
    public boolean atualizarLivro(Livro livro);
    public List<Livro> recuperarLivrosDoAutor(int id_autor);
    public List<Livro> recuperarLivrosDaSubarea(int idSubarea);
}
