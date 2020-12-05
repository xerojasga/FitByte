/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import auth.views.UserRegisterView;
import static core.views.HomeView.current_user;
import entrenador.DAO.CoachDAO;
import entrenador.models.Coach;
import user.models.User;

/**
 *
 * @author developer
 */
public class UserProfileView extends javax.swing.JFrame {

    /**
     * Creates new form UserProfileView
     */
    public UserProfileView(User guest,User selected_user) {
        initComponents();
        current_user = guest;
        user_profile = selected_user; 
        this.setLocationRelativeTo(null);
        System.out.println(UserRegisterView.current_user.getUsername());
        usernameLabel.setText(user_profile.getUsername());
        nameLabel.setText(user_profile.getName());
        lastNameLabel.setText(user_profile.getLast_name());
        descriptionLabel.setText(user_profile.getDescription());
        if("Usuario".equals(user_profile.getType())){
            // si el usuario no es entrenador puede buscar entrenadores pero no ver las solicitudes recibidas
           calificationLabel.setText("");
           rankLabel.setText("");
        }else{
            Coach coach = CoachDAO.find(user_profile.getId_user());        
            rankLabel.setText(String.valueOf(coach.getScore()));
        }
        
    }
    public static User current_user;
    public static User user_profile;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calificationLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        calories_to_consumeLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        consumed_caloriesLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calificationLabel.setText("Calificación:");

        jLabel5.setText("Calorias a consumir:");

        calories_to_consumeLabel.setText("0");

        jLabel7.setText("Calorias consumidas:");

        consumed_caloriesLabel.setText("0");

        usernameLabel.setText("Nombre de Usuario");

        nameLabel.setText("Nombre");

        lastNameLabel.setText("Apellido");

        descriptionLabel.setText("Descripción");

        rankLabel.setText("Calificacion");

        jLabel1.setText("User name:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Descripción");

        backBtn2.setText("Home");
        backBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(calificationLabel)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn2)
                    .addComponent(consumed_caloriesLabel)
                    .addComponent(calories_to_consumeLabel))
                .addGap(81, 81, 81))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(165, 165, 165)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(descriptionLabel)
                                        .addComponent(rankLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameLabel)
                                            .addComponent(lastNameLabel))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(usernameLabel)
                                    .addGap(4, 4, 4)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(calificationLabel)
                .addGap(18, 18, 18)
                .addComponent(calories_to_consumeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consumed_caloriesLabel)
                .addGap(58, 58, 58)
                .addComponent(backBtn2)
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(nameLabel)
                            .addGap(34, 34, 34)
                            .addComponent(lastNameLabel)
                            .addGap(39, 39, 39)
                            .addComponent(descriptionLabel)
                            .addGap(31, 31, 31)
                            .addComponent(rankLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(usernameLabel))
                            .addGap(20, 20, 20)
                            .addComponent(jLabel2)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel3)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel4)))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addGap(5, 5, 5)
                    .addComponent(jLabel7)
                    .addContainerGap(132, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        this.dispose();
        HomeView home = new HomeView(current_user);
        home.setVisible(true);
    }//GEN-LAST:event_backBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserProfileView(current_user,user_profile).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton backBtn2;
    private javax.swing.JLabel calificationLabel;
    private javax.swing.JLabel calories_to_consumeLabel;
    private javax.swing.JLabel consumed_caloriesLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
