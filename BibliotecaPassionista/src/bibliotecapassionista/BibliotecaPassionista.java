/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecapassionista;

/**
 *
 * @author Bruno
 */
public class BibliotecaPassionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MutiplasInsercoes m = new MutiplasInsercoes();
        //m.lerArquivoTXTAutores("C:\\Users\\Bruno\\Documents\\NetBeansProjects\\BibliotecaPassionista\\AUTORES.txt");
        //m.lerArquivoTXTSubareas("C:\\Users\\Bruno\\Documents\\NetBeansProjects\\BibliotecaPassionista\\SUBAREAS.txt");
        m.lerArquivoTXTLivros("C:\\Users\\Bruno\\Documents\\NetBeansProjects\\BibliotecaPassionista\\LIVROS.txt");
    }
    
}
