/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Subarea;

/**
 *
 * @author Bruno
 */
public interface SubareaDAO {
    public boolean verificarCodigoExistente(String codigo);
    public boolean salvarSubarea(Subarea subarea);
    public List<Subarea> recuperarSubareasNome(String nome, int nPagina, int qtdRegistros, boolean isPaginacao);
    public List<Subarea> recuperarSubareasCodigo(String codigo, int nPagina, int qtdRegistros, boolean isPaginacao);
    public boolean subareaHasLivro(Subarea subarea);
    public boolean excluirSubarea(Subarea subarea);
    public boolean atualizarSubarea(Subarea subarea);
    public Subarea recuperarSubareaPorID(int ID);
}
