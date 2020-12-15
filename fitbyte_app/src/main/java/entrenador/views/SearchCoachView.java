/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrenador.views;

import core.DAO.User_CoachDAO;
import core.models.User_Coach;
import core.views.HomeView;
import entrenador.DAO.CoachDAO;
import core.DAO.RequestDAO;
import entrenador.models.Coach;
import core.models.Request;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user.DAO.UserDAO;
import user.models.User;

/**
 *
 * @author developer
 */
public class SearchCoachView extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    
    public static User current_user = new User();
    Coach selected_coach = new Coach();
    
    /**
     * Creates new form BusquedaUsuario
     */
    public SearchCoachView(User user) {
        initComponents();
        
        current_user = user;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        coachIDTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entrenadorSeleccionadoLabel = new javax.swing.JLabel();
        send_requestBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        contactNumberLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        VerifiedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscador de Entrenador");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        coachIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachIDTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Entrenador:");

        send_requestBtn.setText("Enviar Solicitud");
        send_requestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_requestBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingresa la ID a buscar");

        nameLabel.setText("No Encontrado");

        LastNameLabel.setText("No Encontrado");

        jLabel4.setText("Email Entrenador:");

        EmailLabel.setText("No Encontrado");

        jLabel5.setText("Telefono De Contacto:");

        contactNumberLabel.setText("No Encontrado");

        jLabel7.setText("¿Verificado? :");

        VerifiedLabel.setText("No Encontrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(179, 179, 179))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(143, 143, 143)
                            .addComponent(send_requestBtn)
                            .addGap(3, 3, 3))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(entrenadorSeleccionadoLabel)
                            .addGap(131, 131, 131))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(26, 26, 26)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EmailLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(coachIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contactNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VerifiedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(coachIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameLabel)
                    .addComponent(LastNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(EmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(contactNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(VerifiedLabel))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(send_requestBtn))
                .addGap(35, 35, 35)
                .addComponent(entrenadorSeleccionadoLabel)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int coachID =  Integer.parseInt(coachIDTF.getText());
        Coach coach = CoachDAO.find(coachID);
        User user = UserDAO.find(coach.getId_user());
        int id_coachUser = coach.getId_user();
        System.out.println(id_coachUser);
      /*   
     EmailLabel;
     LastNameLabel;
     VerifiedLabel;
     contactNumberLabel;
     nameLabel;
    */
      EmailLabel.setText(user.getEmail());
     LastNameLabel.setText(user.getLast_name());
     String verBool;
      if (coach.isVerified()){verBool="Si";}
      else {verBool="No";}
     VerifiedLabel.setText(verBool);
     contactNumberLabel.setText(Long.toString(coach.getContact_Number()));
     nameLabel.setText(user.getName());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void send_requestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_requestBtnActionPerformed
        int coachID =  Integer.parseInt(coachIDTF.getText());
       
        
        selected_coach = CoachDAO.find(coachID);
        int id_coachUser = selected_coach.getId_user();
        System.out.println(id_coachUser);
        Request existing_request = RequestDAO.find(current_user.getId_user(), id_coachUser ,"Entrenamiento");
        User_Coach user_coach = User_CoachDAO.find(current_user.getId_user(),coachID);
       
        if(user_coach == null){
           
            if(existing_request == null){
                
                Request request = new Request(current_user.getId_user(),id_coachUser,"Entrenamiento"); 
                if(RequestDAO.create(request) > 0){ 
                    JOptionPane.showMessageDialog(this, "Se ha enviado la solicitud exitosamente");
                }else{
                    JOptionPane.showMessageDialog(this, "No se ha podido crear la solicitud");
                }
            }else{
                JOptionPane.showMessageDialog(this, "No se ha podido crear la solicitud, pueda que haya una existente");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Al parecer ya tienes asignado este entrenador");
        }
    }//GEN-LAST:event_send_requestBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        HomeView home = new HomeView(current_user);
        home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void coachIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachIDTFActionPerformed

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
            java.util.logging.Logger.getLogger(SearchCoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SearchCoachView(current_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel VerifiedLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField coachIDTF;
    private javax.swing.JLabel contactNumberLabel;
    private javax.swing.JLabel entrenadorSeleccionadoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton send_requestBtn;
    // End of variables declaration//GEN-END:variables
}
