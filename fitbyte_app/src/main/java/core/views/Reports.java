/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import core.DAO.ConsumptionDAO;
import core.models.Consumption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user.models.User;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * 
 */
public class Reports extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    public static User current_user;
    /**
     * Creates new form Reports
     */
    
    
            
    public Reports(User user) {
        initComponents();
        current_user = user;
        ArrayList <Object> columns = new ArrayList<Object>();
        //columns.add("id_consumo");
        columns.add("FECHA");
        //columns.add("rec_entenador");
        //columns.add("usuario_id");
        //columns.add("ingrediente_id");
        columns.add("PLATO");
        columns.add("EJERCICIO");
        columns.add("CALORIAS");
        columns.add("HORAS DE EJERCICIO");
        columns.add("DIA");
        for(Object column :columns){
            model.addColumn(column);
        }
        consumeTBL.setModel(model);
        
    }

    Reports() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chargeBTN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        consumeTBL = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nregTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        caltotTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        horasTF = new javax.swing.JTextField();
        exitBTN = new javax.swing.JButton();
        exportBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chargeBTN.setText("Cargar ultimos Consumos");
        chargeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeBTNActionPerformed(evt);
            }
        });

        consumeTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(consumeTBL);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ultimos Registros de Consumos");

        jLabel2.setText("Numero de Registros:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Datos Generales:");

        jLabel4.setText("Suma de Calorias:");

        caltotTF.setEditable(false);

        jLabel5.setText("Horas Totales De Ejercicio:");

        horasTF.setEditable(false);

        exitBTN.setText("Volver");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        exportBTN.setText("Exportar");
        exportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(chargeBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nregTF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel4)
                    .addComponent(caltotTF)
                    .addComponent(jLabel5)
                    .addComponent(horasTF, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exportBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBTN)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(chargeBTN)
                                .addComponent(nregTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(caltotTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(horasTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(exitBTN)
                                .addComponent(exportBTN)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private void chargeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeBTNActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelA = new DefaultTableModel();
        ArrayList <Object> columns = new ArrayList<Object>();
        //columns.add("id_consumo");
        columns.add("FECHA");
        //columns.add("rec_entenador");
        //columns.add("usuario_id");
        //columns.add("ingrediente_id");
        columns.add("PLATO");
        columns.add("EJERCICIO");
        columns.add("CALORIAS");
        columns.add("HORAS DE EJERCICIO");
        columns.add("DIA");
        for(Object column :columns){
            modelA.addColumn(column);
        }
        
        int id = current_user.getId_user();
        int nreg = Integer.valueOf(nregTF.getText());
        ArrayList<Consumption> Con = ConsumptionDAO.findAllU(id,nreg);
        
        int cal = 0;
        int hours = 0;
        for(Consumption i : Con){
            Object[] data = new Object[]{i.getDate(),i.getPlate_id(),i.getExercise_id(),i.getCalories(),i.getNum_hours_excers(),i.getRec_day_weak()};
            cal += i.getCalories();
            hours += i.getNum_hours_excers();
            modelA.addRow(data);
        }
        consumeTBL.setModel(modelA);
        
        caltotTF.setText(String.valueOf(cal));
        horasTF.setText(String.valueOf(hours));
        caltotTF.updateUI();
        horasTF.updateUI();
    }//GEN-LAST:event_chargeBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeView n = new HomeView(current_user);
        n.setVisible(true);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void exportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBTNActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String Directory;
        Directory = fc.getCurrentDirectory().getAbsolutePath()+"/results.txt ";
            File result = new File(Directory);
            if(!result.exists()){
                try {
                    result.createNewFile();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        
            FileWriter fw;
        try {
            fw = new FileWriter(result);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < consumeTBL.getColumnCount(); i++){
                String s = consumeTBL.getColumnName(i)+"\t";
                bw.write(s);
            }
            bw.write("\n");
            
            for (int i = 0; i < consumeTBL.getRowCount(); i++){
                for (int j = 0; j < consumeTBL.getColumnCount(); j++) {
                    String s;
                    s = consumeTBL.getValueAt(i, j).toString() + "\t";
                    bw.write(s);
                }
                bw.write("\n");
            }
            bw.close();
            JOptionPane.showMessageDialog(this, "Results Created in "+Directory);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_exportBTNActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports(current_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caltotTF;
    private javax.swing.JButton chargeBTN;
    private javax.swing.JTable consumeTBL;
    private javax.swing.JButton exitBTN;
    private javax.swing.JButton exportBTN;
    private javax.swing.JTextField horasTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField nregTF;
    // End of variables declaration//GEN-END:variables
}
