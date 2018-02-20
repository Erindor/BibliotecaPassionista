/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecapassionista;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dao.AutorDAO;
import dao.AutorDAOJDBC;
import dao.LivroDAOJDBC;
import dao.SubareaDAOJDBC;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Livro;
import model.Subarea;

/**
 *
 * @author Bruno
 */
public class MutiplasInsercoes {
    List<Autor> autores = new ArrayList<Autor>();
    List<Subarea> subareas = new ArrayList<Subarea>();
    List<Livro> livros = new ArrayList<Livro>();

    public MutiplasInsercoes() {
    }
    
    
    
    public void lerArquivoTXTAutores(String caminhoArquivo){
        try {
            FileReader arq = new FileReader(caminhoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null){
                Autor a = new Autor(linha);
                System.out.println(linha);
                autores.add(a);
                linha = lerArq.readLine();
            }
            arq.close();
            this.inserirAutoresBanco();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lerArquivoTXTSubareas(String caminhoArquivo){
        try {
            FileReader arq = new FileReader(caminhoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String array[] = new String[2];
            while (linha != null){
                array = linha.split(";");
                Subarea s = new Subarea(array[0], array[1]);
                System.out.println(linha);
                subareas.add(s);
                linha = lerArq.readLine();
            }
            arq.close();
            this.inserirSubareasBanco();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void inserirAutoresBanco(){
        AutorDAOJDBC autorDao= new AutorDAOJDBC();
        
        for (Autor a : autores){
            autorDao.salvalAutor(a);
            
        }
    }
    
    public void inserirSubareasBanco(){
        SubareaDAOJDBC subareaDAO = new SubareaDAOJDBC();
        int x = 1;
        for (Subarea s : subareas){
            subareaDAO.salvarSubarea(s);
            System.out.println(x + " OK - " + s.getNome_subarea());
            x++;
        }
    }
    
    public void lerArquivoTXTLivros(String caminhoArquivo){
        try {
            FileReader arq = new FileReader(caminhoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String array[] = new String[4];
            AutorDAOJDBC autorDAO = new AutorDAOJDBC();
            SubareaDAOJDBC subareaDAO = new SubareaDAOJDBC();
            while (linha != null){
                array = linha.split("#;#");
                if (array[0].indexOf("\t\t\t") < 0){
                    if (array[1].indexOf("PE. Luiz Cechinato")>= 0)
                        array[1] = "Pe. Luiz Cechinato";
                    if (array[1].indexOf("PAULO Suess") >= 0)
                        array[1] = "Paulo Suess";
                    if (array[1].indexOf(" A. G. Hamman") >=0)
                        array[1] = "A. G. Hamman";
                    Autor autor = autorDAO.recuperarAutorPorNomeIdentico(array[1]);
                    if (autor == null){
                        System.out.println("#AUTOR NAO ENCONTRADO -;- " + array[1]);
                    }
                    else{
                        Subarea subarea = subareaDAO.recuperarSubareaPorCodigoIdentico(array[2]);
                        if (subarea == null){
                            System.out.println("#SUBAREA NAO ENCONTRADA -;- " + array[2]);
                        }
                        else{
                           Livro l = new Livro(array[0], array[2]+array[3], Integer.parseInt(array[3]), subarea, autor);
                           this.livros.add(l); 
                        }
                    }                    
                }
                    linha = lerArq.readLine();
            }
            arq.close();
            this.inserirLivrosBanco();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MutiplasInsercoes.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void inserirLivrosBanco(){
        LivroDAOJDBC livroDAO = new LivroDAOJDBC();
        int x = 1;
        for (Livro l : this.livros){
            livroDAO.salvarLivro(l);
            x++;
            System.out.println(x + " # " + l.getTitulo_livro() + " # " + l.getLocacao_livro());
        }
    }
}
