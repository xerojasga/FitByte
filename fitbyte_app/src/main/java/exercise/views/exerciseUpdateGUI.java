/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.views;

import core.DAO.ExerciseDAO;
import core.models.Exercise;

/**
 *
 * @author Kevin
 */
public class exerciseUpdateGUI extends javax.swing.JPanel {

    /**
     * Creates new form exerciseUpdateGUI
     */
    public exerciseUpdateGUI() {
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

        exerciseUpdatePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        exerciseIDUpTF = new javax.swing.JTextField();
        exerciseDescriptionUPTF = new javax.swing.JTextField();
        exerciseBurntUPTF = new javax.swing.JTextField();
        UpdateButton = new javax.swing.JButton();

        jLabel1.setText("Edita tu Ejercicio");

        jLabel2.setText("ID de tu Ejercicio:");

        jLabel3.setText("Nueva Descripcion:");

        jLabel4.setText("Nueva Cantidad de Calorias Quemadas:");

        UpdateButton.setText("Actualizar Datos");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exerciseUpdatePanelLayout = new javax.swing.GroupLayout(exerciseUpdatePanel);
        exerciseUpdatePanel.setLayout(exerciseUpdatePanelLayout);
        exerciseUpdatePanelLayout.setHorizontalGroup(
            exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exerciseUpdatePanelLayout.createSequentialGroup()
                        .addGroup(exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(exerciseBurntUPTF))
                            .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(82, 82, 82)
                                .addComponent(exerciseDescriptionUPTF))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, exerciseUpdatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(exerciseIDUpTF, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87))))
        );
        exerciseUpdatePanelLayout.setVerticalGroup(
            exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exerciseUpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(exerciseIDUpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(exerciseDescriptionUPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(exerciseUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(exerciseBurntUPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(UpdateButton)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exerciseUpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exerciseUpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
 int exerciseID = Integer.parseInt(exerciseIDUpTF.getText());        
  Exercise exercise = ExerciseDAO.find(exerciseID);
  String exerciseDescription=exerciseDescriptionUPTF.getText();
  int exerciseBurnt=Integer.parseInt(exerciseBurntUPTF.getText());
  exercise.setExerciseID(exerciseID);
 exercise.setExerciseDescription(exerciseDescription);
 exercise.setBurntHourCalorieExercise(exerciseBurnt);
   if(ExerciseDAO.update(exercise)>0){
                exerciseUpdatePanel.removeAll();
                exerciseUpdatePanel.setVisible(false);}
                
    }//GEN-LAST:event_UpdateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField exerciseBurntUPTF;
    private javax.swing.JTextField exerciseDescriptionUPTF;
    private javax.swing.JTextField exerciseIDUpTF;
    private javax.swing.JPanel exerciseUpdatePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
