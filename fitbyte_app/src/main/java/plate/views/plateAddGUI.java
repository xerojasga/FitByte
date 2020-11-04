/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plate.views;

import core.DAO.PlateDAO;
import core.models.Plate;


/**
 *
 * @author Kevin
 */
public class plateAddGUI extends javax.swing.JPanel {

   

    /**
     * Creates new form plateAddGUI
     */
    public plateAddGUI() {
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

        plateAddPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idPlateTF = new javax.swing.JTextField();
        namePlateTF = new javax.swing.JTextField();
        plateDescriptionTF = new javax.swing.JTextField();
        plateRecipeeTF = new javax.swing.JTextField();
        yesOption = new javax.swing.JRadioButton();
        noOption = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        plateSaver = new javax.swing.JButton();

        jLabel2.setText("ID para tu plato");

        jLabel3.setText("Nombre de tu plato");

        jLabel4.setText("Descripcion de tu plato");

        jLabel5.setText("Receta de tu plato");

        jLabel6.setText("¿Deseas que tu plato sea visible para todos?");

        idPlateTF.setText("ID_Plato");

        namePlateTF.setText("jTextField2");

        plateDescriptionTF.setText("jTextField3");

        plateRecipeeTF.setText("jTextField4");

        yesOption.setText("Si");
        yesOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesOptionActionPerformed(evt);
            }
        });

        noOption.setText("No");

        jLabel1.setText("Añade Tu Plato");

        plateSaver.setText("Guardar Plato");
        plateSaver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateSaverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plateAddPanelLayout = new javax.swing.GroupLayout(plateAddPanel);
        plateAddPanel.setLayout(plateAddPanelLayout);
        plateAddPanelLayout.setHorizontalGroup(
            plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plateAddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plateAddPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plateAddPanelLayout.createSequentialGroup()
                        .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, plateAddPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, plateAddPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(yesOption)
                                .addGap(18, 18, 18)
                                .addComponent(noOption))
                            .addGroup(plateAddPanelLayout.createSequentialGroup()
                                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idPlateTF)
                                    .addComponent(namePlateTF, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(plateDescriptionTF)
                                    .addComponent(plateRecipeeTF)))
                            .addGroup(plateAddPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(plateSaver, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71))))
        );
        plateAddPanelLayout.setVerticalGroup(
            plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plateAddPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(plateAddPanelLayout.createSequentialGroup()
                        .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(idPlateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namePlateTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(plateDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(plateRecipeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plateAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yesOption)
                    .addComponent(noOption))
                .addGap(18, 18, 18)
                .addComponent(plateSaver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(plateAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plateAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yesOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yesOptionActionPerformed

    private void plateSaverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateSaverActionPerformed
             Plate plate= new Plate();
             int plateID=Integer.parseInt(idPlateTF.getText());
             String plateName=namePlateTF.getText();
             String plateDescription=plateDescriptionTF.getText();
             String plateRecipee=plateRecipeeTF.getText();
             boolean publicPlate=false;
             if (yesOption.isSelected()){publicPlate=true;}
             plate.setPlateID(plateID);
             plate.setPlateName(plateName);
             plate.setPlateDescription(plateDescription);
             plate.setPlateRecipee(plateRecipee);
             plate.setPlatePublic(publicPlate);
              
             if (PlateDAO.create(plate)>0){
               
               plateAddPanel.removeAll();
                plateAddPanel.setVisible(false);
                plateAddPanel.setVisible(true);
             }
    }//GEN-LAST:event_plateSaverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idPlateTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField namePlateTF;
    private javax.swing.JRadioButton noOption;
    private javax.swing.JPanel plateAddPanel;
    private javax.swing.JTextField plateDescriptionTF;
    private javax.swing.JTextField plateRecipeeTF;
    private javax.swing.JButton plateSaver;
    private javax.swing.JRadioButton yesOption;
    // End of variables declaration//GEN-END:variables
}
