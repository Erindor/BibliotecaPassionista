/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.subarea;

import controller.SubareaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Subarea;

/**
 *
 * @author Bruno
 */
public class ListarSubareas extends javax.swing.JInternalFrame {

    private SubareaController subareaController = new SubareaController();
    DefaultTableModel dtm;
    private int qtdRegistros = 50;
    private int nPagina = 1;
    
    public ListarSubareas() {
        initComponents();
        getRootPane().setDefaultButton(btn_pesquisar);
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panel_pesquisa = new javax.swing.JPanel();
        label_pesquisar = new javax.swing.JLabel();
        input_pesquisar = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        panel_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_subareas = new javax.swing.JTable();
        panel_paginacao = new javax.swing.JPanel();
        label_voltarPagina = new javax.swing.JLabel();
        label_nPagina = new javax.swing.JLabel();
        label_proximaPagina = new javax.swing.JLabel();
        panel_ferramentas = new javax.swing.JPanel();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        panel_selecao_pesquisa = new javax.swing.JPanel();
        radio_nome = new javax.swing.JRadioButton();
        radio_codigo = new javax.swing.JRadioButton();
        label_total = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Listar subáreas");

        panel_pesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_pesquisa.setLayout(new javax.swing.BoxLayout(panel_pesquisa, javax.swing.BoxLayout.LINE_AXIS));

        label_pesquisar.setText("Pesquisar:");
        panel_pesquisa.add(label_pesquisar);

        input_pesquisar.setPreferredSize(new java.awt.Dimension(400, 20));
        panel_pesquisa.add(input_pesquisar);

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.setToolTipText("");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });
        panel_pesquisa.add(btn_pesquisar);

        panel_tabela.setBorder(javax.swing.BorderFactory.createTitledBorder("Subáreas encontradas"));

        table_subareas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table_subareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Objeto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_subareas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_subareas);
        if (table_subareas.getColumnModel().getColumnCount() > 0) {
            table_subareas.getColumnModel().getColumn(0).setPreferredWidth(120);
            table_subareas.getColumnModel().getColumn(0).setMaxWidth(200);
            table_subareas.getColumnModel().getColumn(2).setMinWidth(0);
            table_subareas.getColumnModel().getColumn(2).setPreferredWidth(0);
            table_subareas.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        javax.swing.GroupLayout panel_tabelaLayout = new javax.swing.GroupLayout(panel_tabela);
        panel_tabela.setLayout(panel_tabelaLayout);
        panel_tabelaLayout.setHorizontalGroup(
            panel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1))
        );
        panel_tabelaLayout.setVerticalGroup(
            panel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panel_paginacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_paginacao.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        label_voltarPagina.setForeground(new java.awt.Color(0, 0, 204));
        label_voltarPagina.setText("<< Voltar");
        label_voltarPagina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_voltarPaginaMouseClicked(evt);
            }
        });
        panel_paginacao.add(label_voltarPagina);

        label_nPagina.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_nPagina.setText("1");
        panel_paginacao.add(label_nPagina);

        label_proximaPagina.setForeground(new java.awt.Color(0, 0, 204));
        label_proximaPagina.setText("Próxima>>");
        label_proximaPagina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_proximaPaginaMouseClicked(evt);
            }
        });
        panel_paginacao.add(label_proximaPagina);

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

        panel_selecao_pesquisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        buttonGroup.add(radio_nome);
        radio_nome.setSelected(true);
        radio_nome.setText("Nome da subárea");
        panel_selecao_pesquisa.add(radio_nome);

        buttonGroup.add(radio_codigo);
        radio_codigo.setText("Código da subárea");
        panel_selecao_pesquisa.add(radio_codigo);

        label_total.setText("Total listado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_paginacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_total))))
                .addContainerGap())
            .addComponent(panel_selecao_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_selecao_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_total)
                        .addGap(0, 187, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_paginacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        List<Subarea> subareasEncontradas = null;
        try {
            this.nPagina = 1;
            if (radio_nome.isSelected()){
                subareasEncontradas = this.buscarSubareaNome(input_pesquisar.getText(), this.nPagina, this.qtdRegistros);
            }
            else if (radio_codigo.isSelected()){
                subareasEncontradas = this.buscarSubareaCodigo(input_pesquisar.getText(), this.nPagina, this.qtdRegistros);
            }
            this.label_nPagina.setText(Integer.toString(this.nPagina));
            this.montarTabela(subareasEncontradas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma subárea encontrada.", "Subárea não encontrada.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void label_voltarPaginaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_voltarPaginaMouseClicked
        List<Subarea> subareasEncontradas = null;
        try {
            if (radio_nome.isSelected()){
                subareasEncontradas = this.buscarSubareaNome(input_pesquisar.getText(), this.nPagina - 1, this.qtdRegistros);
            }
            else if (radio_codigo.isSelected()){
                subareasEncontradas = this.buscarSubareaCodigo(input_pesquisar.getText(), this.nPagina - 1, this.qtdRegistros);
            }            
            this.nPagina = Integer.parseInt(label_nPagina.getText()) - 1;
            this.label_nPagina.setText(Integer.toString(this.nPagina));
            this.montarTabela(subareasEncontradas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma subárea encontrada.", "Subárea não encontrada.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_label_voltarPaginaMouseClicked

    private void label_proximaPaginaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_proximaPaginaMouseClicked
       List<Subarea> subareasEncontradas = null;
        try {
            if (radio_nome.isSelected()){
                subareasEncontradas = this.buscarSubareaNome(input_pesquisar.getText(), this.nPagina + 1, this.qtdRegistros);
            }
            else if (radio_codigo.isSelected()){
                subareasEncontradas = this.buscarSubareaCodigo(input_pesquisar.getText(), this.nPagina + 1, this.qtdRegistros);
            }            
            this.nPagina = Integer.parseInt(label_nPagina.getText()) + 1;
            this.label_nPagina.setText(Integer.toString(this.nPagina));
            this.montarTabela(subareasEncontradas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma subárea encontrada.", "Subárea não encontrada.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_label_proximaPaginaMouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        Subarea subarea = this.subareaSelecionadaParaEditar();
        if (subarea != null){
            subareaController.editarSubarea(subarea);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        List<Subarea> subareasDeletar = this.subareasSelecionadasParaExcluir();
        if (subareasDeletar != null){
            int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja exluir " + subareasDeletar.size() + " subáreas?");
            if (opcao == JOptionPane.YES_OPTION){
                if (subareasDeletar.size() > 0){
                    try {
                        for (int i = 0; i < subareasDeletar.size(); i++){
                            if(subareaController.excluirSubarea(subareasDeletar.get(i))){
                                this.dtm.removeRow(table_subareas.getSelectedRow());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Subáreas deletadas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro.", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField input_pesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nPagina;
    private javax.swing.JLabel label_pesquisar;
    private javax.swing.JLabel label_proximaPagina;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_voltarPagina;
    private javax.swing.JPanel panel_ferramentas;
    private javax.swing.JPanel panel_paginacao;
    private javax.swing.JPanel panel_pesquisa;
    private javax.swing.JPanel panel_selecao_pesquisa;
    private javax.swing.JPanel panel_tabela;
    private javax.swing.JRadioButton radio_codigo;
    private javax.swing.JRadioButton radio_nome;
    private javax.swing.JTable table_subareas;
    // End of variables declaration//GEN-END:variables
    
    
    private void montarTabela(List<Subarea> subareasEncontradas) {
        if (subareasEncontradas != null){
            this.dtm = (DefaultTableModel) table_subareas.getModel();
            this.limparTabela(dtm);
            for (Subarea sub : subareasEncontradas){
                this.dtm.addRow(new Object[]{sub.getCodigo_subarea(), sub.getNome_subarea(), sub});
            }
        }
    }

    private void limparTabela(DefaultTableModel dtm) {
        while (dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
    }
    
    private Subarea subareaSelecionadaParaEditar(){
        try{
            Subarea subareaSelecionada = (Subarea)table_subareas.getValueAt(table_subareas.getSelectedRow(), 2);
            if (subareaSelecionada == null){
                throw new Exception();
            }
            return subareaSelecionada;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhuma subárea selecionada!", "Erro.", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private List<Subarea> subareasSelecionadasParaExcluir(){
        try{            
            int qtdSubareasSelecionados[] = table_subareas.getSelectedRows();
            if (qtdSubareasSelecionados.length > 0){
                List<Subarea> subareasSelecionadas = new ArrayList<Subarea>();
                for (int i = 0; i < qtdSubareasSelecionados.length; i++){
                    Subarea subarea = (Subarea)table_subareas.getValueAt(qtdSubareasSelecionados[i], 2);
                    subareasSelecionadas.add(subarea);
                }
                return subareasSelecionadas;
            } else{
                throw new Exception();
            }     
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro.", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private List<Subarea> buscarSubareaNome(String nome, int nPagina, int qtdRegistros) throws Exception{  
        this.totalListadosNome(nome);
        return subareaController.recuperarSubareasNome(nome, nPagina, qtdRegistros);        
    }
    
    private List<Subarea> buscarSubareaCodigo(String codigo, int nPagina, int qtdRegistros) throws Exception{     
        this.totalListadosCodigoSubarea(codigo);
        return subareaController.recuperarSubareasCodigo(codigo, nPagina, qtdRegistros);
    }
    
    private void totalListadosNome(String texto){
        this.label_total.setText("Total listado: " + Integer.toString(subareaController.recuperarTotalListadoNomeSubarea(texto)));
    }
    
    private void totalListadosCodigoSubarea(String texto){
        this.label_total.setText("Total listado: " + Integer.toString(subareaController.recuperarTotalListadoCodigoSubarea(texto)));
    }

}
