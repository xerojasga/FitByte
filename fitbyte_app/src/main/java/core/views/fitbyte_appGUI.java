/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import com.mycompany.fitbyte_app.ConnectionProvider;
import exercise.views.exerciseAddGUI;
import exercise.views.exerciseDeleteGUI;
import exercise.views.exerciseFindAllGUI;
import exercise.views.exerciseFindGUI;
import exercise.views.exerciseUpdateGUI;
import plate.views.plateFindGUI;
import plate.views.plateFindAllGUI;
import plate.views.plateEditGUI;
import plate.views.plateDeleteGUI;
import plate.views.plateAddGUI;
import java.sql.Connection;
import java.util.Scanner;
/**
 *
 * @author Kevin
 */
public class fitbyte_appGUI extends javax.swing.JFrame {
ConnectionProvider conexion = new ConnectionProvider();
    plateAddGUI plateaddGUI= new plateAddGUI();
    plateFindGUI platefindGUI= new plateFindGUI();
    plateFindAllGUI platefindallGUI= new plateFindAllGUI();
    plateEditGUI plateupdateGUI= new plateEditGUI();
    plateDeleteGUI platedeleteGUI= new plateDeleteGUI();
    exerciseAddGUI exerciseaddGUI= new exerciseAddGUI();
    exerciseFindGUI exercisefindGUI= new exerciseFindGUI();
    exerciseFindAllGUI exercisefindallGUI = new exerciseFindAllGUI();
    exerciseUpdateGUI exerciseupdateGUI = new exerciseUpdateGUI();
    exerciseDeleteGUI exercisedeleteGUI = new exerciseDeleteGUI();
    public fitbyte_appGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plateDeleteButton = new javax.swing.JButton();
        plateUpdateButton = new javax.swing.JButton();
        plateFindAllButton = new javax.swing.JButton();
        plateFindButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        plateCreateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        exerciseAddButton = new javax.swing.JButton();
        exerciseFindButton = new javax.swing.JButton();
        exerciseDeleteButton = new javax.swing.JButton();
        exerciseFindAllButton = new javax.swing.JButton();
        exerciseUpdateButton = new javax.swing.JButton();
        PLIngredientAddButton = new javax.swing.JButton();
        PLIngredientFindButton = new javax.swing.JButton();
        PLIngredientFindAllButton = new javax.swing.JButton();
        PLIngredientDeleteButton = new javax.swing.JButton();
        PLIngredientUpdateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        plateDeleteButton.setText("Borrar Plato");
        plateDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateDeleteButtonActionPerformed(evt);
            }
        });

        plateUpdateButton.setText("Modificar Plato");
        plateUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateUpdateButtonActionPerformed(evt);
            }
        });

        plateFindAllButton.setText("Mostrar todos los platos");
        plateFindAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateFindAllButtonActionPerformed(evt);
            }
        });

        plateFindButton.setText("Buscar Plato");
        plateFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateFindButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("FitByte");

        plateCreateButton.setText("Crear Plato");
        plateCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateCreateButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona tu opcion:");

        mainPanel.setLayout(new java.awt.BorderLayout());

        exerciseAddButton.setText("Crear Ejercicio");
        exerciseAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseAddButtonActionPerformed(evt);
            }
        });

        exerciseFindButton.setText("Buscar Ejercicio");
        exerciseFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseFindButtonActionPerformed(evt);
            }
        });

        exerciseDeleteButton.setText("Borrar Ejercicio");
        exerciseDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseDeleteButtonActionPerformed(evt);
            }
        });

        exerciseFindAllButton.setText("Mostrar Todos los Ejercicios");
        exerciseFindAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseFindAllButtonActionPerformed(evt);
            }
        });

        exerciseUpdateButton.setText("Modificar Ejercicio");
        exerciseUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciseUpdateButtonActionPerformed(evt);
            }
        });

        PLIngredientAddButton.setText("Crear Plato-Ingrediente");

        PLIngredientFindButton.setText("Buscar Plato-Ingrediente");

        PLIngredientFindAllButton.setText("Mostrar Todos los platos-Ingredientes");

        PLIngredientDeleteButton.setText("Borrar Plato-Ingrediente");

        PLIngredientUpdateButton.setText("Modificar Plato-Ingrediente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exerciseAddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exerciseFindAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exerciseDeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(exerciseFindButton)
                        .addGap(18, 18, 18)
                        .addComponent(exerciseUpdateButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plateCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plateFindAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plateDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plateFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plateUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(495, 495, 495))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PLIngredientAddButton)
                        .addGap(18, 18, 18)
                        .addComponent(PLIngredientFindButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PLIngredientFindAllButton)
                        .addGap(18, 18, 18)
                        .addComponent(PLIngredientDeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PLIngredientUpdateButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(plateCreateButton)
                    .addComponent(plateFindAllButton)
                    .addComponent(plateDeleteButton)
                    .addComponent(plateFindButton)
                    .addComponent(plateUpdateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(exerciseAddButton)
                    .addComponent(exerciseDeleteButton)
                    .addComponent(exerciseFindAllButton)
                    .addComponent(exerciseUpdateButton)
                    .addComponent(exerciseFindButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLIngredientAddButton)
                    .addComponent(PLIngredientFindButton)
                    .addComponent(PLIngredientFindAllButton)
                    .addComponent(PLIngredientDeleteButton)
                    .addComponent(PLIngredientUpdateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plateCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateCreateButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(plateaddGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_plateCreateButtonActionPerformed

    private void plateFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateFindButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(platefindGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_plateFindButtonActionPerformed

    private void plateFindAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateFindAllButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(platefindallGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_plateFindAllButtonActionPerformed

    private void plateUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateUpdateButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(plateupdateGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_plateUpdateButtonActionPerformed

    private void plateDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateDeleteButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(platedeleteGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_plateDeleteButtonActionPerformed

    private void exerciseAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseAddButtonActionPerformed
         mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(exerciseaddGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_exerciseAddButtonActionPerformed

    private void exerciseFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseFindButtonActionPerformed
          mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(exercisefindGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_exerciseFindButtonActionPerformed

    private void exerciseFindAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseFindAllButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        
        mainPanel.add(exercisefindallGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_exerciseFindAllButtonActionPerformed

    private void exerciseUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseUpdateButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(exerciseupdateGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_exerciseUpdateButtonActionPerformed

    private void exerciseDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciseDeleteButtonActionPerformed
        mainPanel.setVisible(false);
        mainPanel.removeAll();
        mainPanel.add(exercisedeleteGUI);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_exerciseDeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(fitbyte_appGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fitbyte_appGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fitbyte_appGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fitbyte_appGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fitbyte_appGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PLIngredientAddButton;
    private javax.swing.JButton PLIngredientDeleteButton;
    private javax.swing.JButton PLIngredientFindAllButton;
    private javax.swing.JButton PLIngredientFindButton;
    private javax.swing.JButton PLIngredientUpdateButton;
    private javax.swing.JButton exerciseAddButton;
    private javax.swing.JButton exerciseDeleteButton;
    private javax.swing.JButton exerciseFindAllButton;
    private javax.swing.JButton exerciseFindButton;
    private javax.swing.JButton exerciseUpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton plateCreateButton;
    private javax.swing.JButton plateDeleteButton;
    private javax.swing.JButton plateFindAllButton;
    private javax.swing.JButton plateFindButton;
    private javax.swing.JButton plateUpdateButton;
    // End of variables declaration//GEN-END:variables
}
