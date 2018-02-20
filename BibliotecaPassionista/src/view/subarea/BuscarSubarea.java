/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.subarea;

import controller.AutorController;
import controller.SubareaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Subarea;

/**
 *
 * @author Bruno
 */
public class BuscarSubarea extends javax.swing.JDialog{
    SubareaController subareaController = new SubareaController();
    Subarea subarea = null;
    boolean statusAtivo = true;
    DefaultTableModel dtm;
    /**
     * Creates new form BuscarAutor
     */
    public BuscarSubarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(btn_pesquisar);
    }

    public BuscarSubarea() {
        initComponents();
        setLocationRelativeTo(null);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_confirmar = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        panel_pesquisa = new javax.swing.JPanel();
        label_pesquisar = new javax.swing.JLabel();
        input_pesquisar = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        panel_selecao_pesquisa = new javax.swing.JPanel();
        radio_nome = new javax.swing.JRadioButton();
        radio_codigo = new javax.swing.JRadioButton();
        panel_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_subareas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar autor");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_confirmar);

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_voltar);

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

        panel_selecao_pesquisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        buttonGroup1.add(radio_nome);
        radio_nome.setSelected(true);
        radio_nome.setText("Nome da subárea");
        panel_selecao_pesquisa.add(radio_nome);

        buttonGroup1.add(radio_codigo);
        radio_codigo.setText("Código da subárea");
        panel_selecao_pesquisa.add(radio_codigo);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addComponent(panel_selecao_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel_selecao_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.statusAtivo = false;
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.statusAtivo = false;
    }//GEN-LAST:event_formWindowClosing

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        try{
            this.subarea = (Subarea)table_subareas.getValueAt(table_subareas.getSelectedRow(), 2);
            if (this.subarea == null){
                throw new Exception();
            }
            this.dispose();
            this.statusAtivo = false;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhuma subárea selecionada!", "Erro.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        List<Subarea> subareasEncontradas = null;
        try {
            if (radio_nome.isSelected()){
                subareasEncontradas = subareaController.recuperarSubareasNome(input_pesquisar.getText(), false);
            }
            else if (radio_codigo.isSelected()){
                subareasEncontradas = subareaController.recuperarSubareasCodigo(input_pesquisar.getText(), false);
            }
            this.montarTabela(subareasEncontradas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma subárea encontrada.", "Subárea não encontrada.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    
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
            java.util.logging.Logger.getLogger(BuscarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarSubarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarSubarea dialog = new BuscarSubarea(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField input_pesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_pesquisar;
    private javax.swing.JPanel panel_pesquisa;
    private javax.swing.JPanel panel_selecao_pesquisa;
    private javax.swing.JPanel panel_tabela;
    private javax.swing.JRadioButton radio_codigo;
    private javax.swing.JRadioButton radio_nome;
    private javax.swing.JTable table_subareas;
    // End of variables declaration//GEN-END:variables
    
    public Subarea getSubarea(){
        return this.subarea;
    }
    
    public boolean getStatusAtivo(){
        return this.statusAtivo;
    }

    private void montarTabela(List<Subarea> subareasEncontradas) {
        this.dtm = (DefaultTableModel) table_subareas.getModel();
        this.limparTabela(dtm);
        for (Subarea s : subareasEncontradas){
            this.dtm.addRow(new Object[]{s.getCodigo_subarea(), s.getNome_subarea(), s});
        }
    }
    
    private void limparTabela(DefaultTableModel dtm) {
        while (dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
    }
}