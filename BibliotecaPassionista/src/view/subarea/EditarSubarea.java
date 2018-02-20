/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.subarea;

import view.autor.*;
import controller.AutorController;
import controller.LivroController;
import controller.SubareaController;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Livro;
import model.Subarea;

/**
 *
 * @author Bruno
 */
public class EditarSubarea extends javax.swing.JDialog {

    private Subarea subarea;
    DefaultTableModel dtm;
    private SubareaController subareaController = new SubareaController();

    /**
     * Creates new form EditarAutor
     */
    public EditarSubarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EditarSubarea(Subarea subarea) {
        this.subarea = subarea;
        initComponents();
        setLocationRelativeTo(null);
        this.setCamposSubarea(subarea);
        List<Livro> livros = this.recuperarLivrosDaSubarea();
        if (livros.size() > 0)
            this.montarTabela(livros);
        getRootPane().setDefaultButton(btn_salvar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_dados = new javax.swing.JPanel();
        label_id = new javax.swing.JLabel();
        input_id = new javax.swing.JTextField();
        label_nome = new javax.swing.JLabel();
        input_nome = new javax.swing.JTextField();
        label_codigo = new javax.swing.JLabel();
        input_codigo = new javax.swing.JTextField();
        panel_icone = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_botoes = new javax.swing.JPanel();
        btn_salvar = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        panel_livros = new javax.swing.JPanel();
        panel_ferramentas = new javax.swing.JPanel();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_livros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar autor");
        setModal(true);

        panel_dados.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar subárea"));
        panel_dados.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        label_id.setText("ID subárea:");
        panel_dados.add(label_id);

        input_id.setEnabled(false);
        input_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_idActionPerformed(evt);
            }
        });
        panel_dados.add(input_id);

        label_nome.setText("Nome subárea:");
        panel_dados.add(label_nome);
        panel_dados.add(input_nome);

        label_codigo.setText("Código subárea:");
        panel_dados.add(label_codigo);
        panel_dados.add(input_codigo);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/diagram.png"))); // NOI18N
        panel_icone.add(jLabel1);

        panel_botoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        panel_botoes.add(btn_salvar);

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        panel_botoes.add(btn_voltar);

        panel_livros.setBorder(javax.swing.BorderFactory.createTitledBorder("Livros desta subárea"));

        panel_ferramentas.setLayout(new java.awt.GridBagLayout());

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/edit.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        panel_ferramentas.add(btn_editar, new java.awt.GridBagConstraints());

        btn_excluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bruno\\Pictures\\delete.png")); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel_ferramentas.add(btn_excluir, gridBagConstraints);

        table_livros.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table_livros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "Classificação", "Autor", "Subárea", "Objeto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_livros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_livros);
        if (table_livros.getColumnModel().getColumnCount() > 0) {
            table_livros.getColumnModel().getColumn(5).setMinWidth(0);
            table_livros.getColumnModel().getColumn(5).setPreferredWidth(0);
            table_livros.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout panel_livrosLayout = new javax.swing.GroupLayout(panel_livros);
        panel_livros.setLayout(panel_livrosLayout);
        panel_livrosLayout.setHorizontalGroup(
            panel_livrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_livrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_livrosLayout.setVerticalGroup(
            panel_livrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_livrosLayout.createSequentialGroup()
                .addGroup(panel_livrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_icone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_livros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_icone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_livros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_idActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
         try {
            if(this.validarCampos()){
                this.validarCodigo();
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja atualizar subárea?", "Confirmação.", JOptionPane.INFORMATION_MESSAGE);
                if (opcao == JOptionPane.YES_OPTION){                    
                    if(this.atualizarSubarea() == true){
                        JOptionPane.showMessageDialog(null, "Subarea salvo com sucesso!", "Sucesso.", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                }
            }
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de validação.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        LivroController livroController = new LivroController();
        Livro livro = this.livroSelecionadoParaEditar();
        if (livro != null){
            livroController.editarLivro(livro);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        LivroController livroController = new LivroController();
        List<Livro> livrosDeteletar = this.livrosSelecionadosParaExcluir();
        if (livrosDeteletar != null){
            int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja exluir " + livrosDeteletar.size() + " livros?");
            if (opcao == JOptionPane.YES_OPTION){            
                if (livrosDeteletar.size() > 0){
                    try {
                        for (int i = 0; i < livrosDeteletar.size(); i++){
                            if(livroController.excluirLivro(livrosDeteletar.get(i))){
                                this.dtm.removeRow(table_livros.getSelectedRow());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Livros deletados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro.", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarSubarea dialog = new EditarSubarea(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void setSubarea(Subarea subarea){
        this.subarea = subarea;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JTextField input_codigo;
    private javax.swing.JTextField input_id;
    private javax.swing.JTextField input_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_nome;
    private javax.swing.JPanel panel_botoes;
    private javax.swing.JPanel panel_dados;
    private javax.swing.JPanel panel_ferramentas;
    private javax.swing.JPanel panel_icone;
    private javax.swing.JPanel panel_livros;
    private javax.swing.JTable table_livros;
    // End of variables declaration//GEN-END:variables

    private void setCamposSubarea(Subarea subarea) {
        this.input_id.setText(Integer.toString(subarea.getId_subrea()));
        this.input_nome.setText(subarea.getNome_subarea());
        this.input_codigo.setText(subarea.getCodigo_subarea());
    }

    private boolean validarCampos() throws Exception {
            this.validarID();
            this.validarNome();
            //this.validarCodigo();
            return true;
    }
    
    private boolean validarID() throws Exception {
        if (this.input_id.getText().isEmpty() == true){
            throw new Exception("ID não pode ser vazio!");
        }
        return true;
    }

    private boolean validarNome() throws Exception {
        if (this.input_nome.getText().isEmpty() == true){
            this.input_nome.setBorder(new LineBorder(Color.RED));
            throw new Exception("Nome da subárea não pode ser vazia.");
        }
        return true;
    }

    private void validarCodigo() throws Exception {
        String codigo = this.input_codigo.getText();
        if (codigo.isEmpty() == true){
            this.input_codigo.setBorder(new LineBorder(Color.RED));
            throw new Exception("Código da subárea não pode ser vazia.");
        }
        if (subareaController.verificarCodigoExistente(codigo) == true){
            throw new Exception("Código já cadastrado na base de dados.");
        }
    }

    private boolean atualizarSubarea() {
        try{
            this.subarea.setCodigo_subarea(input_codigo.getText());
            this.subarea.setNome_subarea(input_nome.getText());
            subareaController.atualizarSubareaNoBanco(this.subarea);
            return true;
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema ao atualizar subárea!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private List<Livro> recuperarLivrosDaSubarea() {
        LivroController livroController = new LivroController();
        return livroController.recuperarLivrosDaSubarea(this.subarea.getId_subrea());
    }
    
    private void montarTabela(List<Livro> livrosEncontrados) {
        this.dtm = (DefaultTableModel) table_livros.getModel();
        this.limparTabela(dtm);
        for (Livro l : livrosEncontrados){
            this.dtm.addRow(new Object[]{l.getId_livro(), l.getTitulo_livro(), l.getLocacao_livro(),
                l.getAutor().getNome_autor(), l.getSubarea().getNome_subarea(), l});
        }
    }

    private void limparTabela(DefaultTableModel dtm) {
        while (dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
    }
    
    private Livro livroSelecionadoParaEditar(){
        try{
            Livro livroSelecionado = (Livro)table_livros.getValueAt(table_livros.getSelectedRow(), 5);
            if (livroSelecionado == null){
                throw new Exception();
            }
            return livroSelecionado;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!", "Erro.", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private List<Livro> livrosSelecionadosParaExcluir(){
        try{            
            int qtdLivrosSelecionados[] = table_livros.getSelectedRows();
            if (qtdLivrosSelecionados.length > 0){
                List<Livro> livrosSelecionados = new ArrayList<Livro>();
                for (int i = 0; i < qtdLivrosSelecionados.length; i++){
                    Livro livroSelecionado = (Livro)table_livros.getValueAt(qtdLivrosSelecionados[i], 5);
                    livrosSelecionados.add(livroSelecionado);
                }
                return livrosSelecionados;
            } else{
                throw new Exception();
            }     
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!", "Erro.", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
}
