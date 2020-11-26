/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import auth.views.LoginView;
import auth.views.UserRegisterView;
import entrenador.views.SearchCoachView;
import entrenador.DAO.CoachDAO;
import entrenador.models.Coach;
import entrenador.views.MyUsersView;
import entrenador.views.ReceivedRequestsView;
import user.models.User;
import user.views.UserConfigView;
import core.views.consumption.*;
import java.sql.Date;
import core.DAO.ConsumptionDAO;
import core.models.Consumption;
import java.util.ArrayList;
import java.time.*;
import core.views.FavoriteView;
/**
 *
 * @author developer
 */
public class HomeView extends javax.swing.JFrame {
    /**
     * Creates new form HomeView
     */
    public static User current_user ;
    
    public HomeView(User user) {
        initComponents();
        this.setLocationRelativeTo(null);
        System.out.println(UserRegisterView.current_user.getUsername());
        current_user = user;
        usernameLabel.setText(user.getUsername());
        nameLabel.setText(user.getName());
        lastNameLabel.setText(user.getLast_name());
        descriptionLabel.setText(user.getDescription());
        if("Usuario".equals(current_user.getType())){
            // si el usuario no es entrenador puede buscar entrenadores pero no ver las solicitudes recibidas
           calificationLabel.setText("");
           rankLabel.setText("");
           
           searchCouchBtn.setVisible(true);
           searchUserBtn.setVisible(true);
           ConsumptionBtn.setVisible(true);
           friendsBtn.setVisible(true);
           searchRecipesBtn.setVisible(true);
           
           receivedRequestsBtn.setVisible(false);
           user_coachBtn.setVisible(false);
        }else{
            Coach coach = CoachDAO.find(user.getId_user());        
            rankLabel.setText(String.valueOf(coach.getCalification()));
            
            receivedRequestsBtn.setVisible(true);
            user_coachBtn.setVisible(true);
            
            searchCouchBtn.setVisible(false);
            searchUserBtn.setVisible(false);
            ConsumptionBtn.setVisible(false);
            friendsBtn.setVisible(false);
            searchRecipesBtn.setVisible(false);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        calificationLabel = new javax.swing.JLabel();
        btnConfigUsuario = new javax.swing.JButton();
        searchCouchBtn = new javax.swing.JButton();
        receivedRequestsBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        user_coachBtn = new javax.swing.JButton();
        searchUserBtn = new javax.swing.JButton();
        friendsBtn = new javax.swing.JButton();
        ConsumptionBtn = new javax.swing.JButton();
        searchRecipesBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        calories_to_consumeLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        consumed_caloriesLabel = new javax.swing.JLabel();
        myFavBTM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameLabel.setText("Nombre de Usuario");

        nameLabel.setText("Nombre");

        lastNameLabel.setText("Apellido");

        descriptionLabel.setText("Descripción");

        rankLabel.setText("Calificacion");

        jLabel1.setText("User name:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Descripción");

        calificationLabel.setText("Calificación:");

        btnConfigUsuario.setText("Configuración Cuenta");
        btnConfigUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigUsuarioActionPerformed(evt);
            }
        });

        searchCouchBtn.setText("Buscador entrenador");
        searchCouchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCouchBtnActionPerformed(evt);
            }
        });

        receivedRequestsBtn.setText("Solicitudes recibidas");
        receivedRequestsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedRequestsBtnActionPerformed(evt);
            }
        });

        logOutBtn.setText("Cerrar Sesión");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        user_coachBtn.setText("Mis entrenados");
        user_coachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_coachBtnActionPerformed(evt);
            }
        });

        searchUserBtn.setText("Buscador usuarios");

        friendsBtn.setText("Mis amigos");

        ConsumptionBtn.setText("Consumos");
        ConsumptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsumptionBtnActionPerformed(evt);
            }
        });

        searchRecipesBtn.setText("Buscador Recetas");

        jLabel5.setText("Calorias a consumir:");

        calories_to_consumeLabel.setText("0");

        jLabel7.setText("Calorias consumidas:");

        consumed_caloriesLabel.setText("0");

        myFavBTM.setText("Mis Favoritos");
        myFavBTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myFavBTMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfigUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOutBtn)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_coachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(receivedRequestsBtn)
                            .addComponent(myFavBTM, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(calificationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rankLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(nameLabel)
                                            .addComponent(usernameLabel))
                                        .addGap(2, 2, 2))
                                    .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calories_to_consumeLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consumed_caloriesLabel)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchUserBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConsumptionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchCouchBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchRecipesBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfigUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(usernameLabel))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(nameLabel)))
                                    .addComponent(user_coachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(receivedRequestsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(descriptionLabel)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(myFavBTM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calificationLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(rankLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(calories_to_consumeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(consumed_caloriesLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchCouchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConsumptionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(friendsBtn)
                        .addGap(18, 18, 18)
                        .addComponent(searchRecipesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchCouchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCouchBtnActionPerformed
        this.dispose();
        SearchCoachView buscador = new SearchCoachView(current_user);
        buscador.setVisible(true);
    }//GEN-LAST:event_searchCouchBtnActionPerformed

    private void btnConfigUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigUsuarioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        UserConfigView conf = new UserConfigView(current_user);
        conf.setVisible(true);
    }//GEN-LAST:event_btnConfigUsuarioActionPerformed

    private void receivedRequestsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedRequestsBtnActionPerformed
        this.dispose();
        ReceivedRequestsView received = new ReceivedRequestsView(current_user);
        received.setVisible(true);
    }//GEN-LAST:event_receivedRequestsBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        this.dispose();
        LoginView login = new LoginView();
        login.setVisible(true);
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void user_coachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_coachBtnActionPerformed
        this.dispose();
        MyUsersView my_users = new MyUsersView(current_user);
        my_users.setVisible(true);    }//GEN-LAST:event_user_coachBtnActionPerformed

    private void ConsumptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsumptionBtnActionPerformed
       this.dispose();
       ConsumptionView cc = new ConsumptionView(current_user);
       cc.setVisible(true);
    }//GEN-LAST:event_ConsumptionBtnActionPerformed

    private void myFavBTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myFavBTMActionPerformed
        FavoriteView fv = new FavoriteView(current_user);
        this.dispose();
        fv.setVisible(true);
    }//GEN-LAST:event_myFavBTMActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView(current_user).setVisible(true);
            }
        });
    }
    private int[] calCalc(){
        int cons = 0;
        int toCons = 0;
        Date td = new Date(System.currentTimeMillis());
        ArrayList<Consumption> selfCons = ConsumptionDAO.findAll();
        LocalDate ld = td.toLocalDate();
        DayOfWeek day = ld.getDayOfWeek();
        int d = day.getValue();
        String dia = "";
        switch(d){
            case(1): dia = "Lunes";
            case(2): dia = "Martes";
            case(3): dia = "Miercoles";
            case(4): dia = "Jueves";
            case(5): dia = "Viernes";
            case(6): dia = "Sabado";
            case(7): dia = "Domingo";
            default: dia = null;
        }
                
        for (Consumption c: selfCons){
            if (td.equals(c.getDate()) && current_user.getId_user() == c.getUser_id() && !c.isRec_coach()){
                cons = cons + c.getCalories();
            }
            if (dia.equals(c.getRec_day_weak()) && current_user.getId_user() == c.getUser_id() && c.isRec_coach()){
                toCons = toCons + c.getCalories();
            }
        }
        
        
        int[] ret = {cons, toCons - cons};
        return ret;
    }
    public void setCaloriesToConsume(){
        calories_to_consumeLabel.setText(calCalc()[1] + "");
    }
    public void setConsumedCalories(){
        consumed_caloriesLabel.setText(calCalc()[0] + "");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsumptionBtn;
    private javax.swing.JButton btnConfigUsuario;
    private javax.swing.JLabel calificationLabel;
    private javax.swing.JLabel calories_to_consumeLabel;
    private javax.swing.JLabel consumed_caloriesLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton friendsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton myFavBTM;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JButton receivedRequestsBtn;
    private javax.swing.JButton searchCouchBtn;
    private javax.swing.JButton searchRecipesBtn;
    private javax.swing.JButton searchUserBtn;
    private javax.swing.JButton user_coachBtn;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
