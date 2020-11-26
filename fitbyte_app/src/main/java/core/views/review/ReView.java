/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views.review;

import core.models.Review;
import core.DAO.ReviewDAO;
import user.models.User;
import user.DAO.UserDAO;
import entrenador.models.Coach;
import entrenador.DAO.CoachDAO;
import core.views.HomeView;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego
 */
public class ReView extends javax.swing.JFrame {
    private User current_user = new User();
    private Coach cReviewed = new Coach();
    private boolean rows = false;
    /**
     * Creates new form ReView
     */
    public ReView(User user, Coach coach) {
        current_user = user;
        cReviewed = coach;
        initComponents();
        ArrayList<Review> rev = ReviewDAO.findAll();
        Review review = new Review();
        for (Review r: rev){
            if (r.getUser_id() == current_user.getId_user() && r.getCoach_id() == cReviewed.getId_couch()){
                review = r;
                rows = true;
                break;
            }
        }
        if (rows){
            reviewTA.setText(review.getContent());
        }
        reviewTA.setEditable(false);
        
    }
    private boolean editable(){
        return reviewTA.isEditable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        readyBTM = new javax.swing.JButton();
        deleteBTM = new javax.swing.JButton();
        closeBTM = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        reviewPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTA = new javax.swing.JTextArea();
        editTBTM = new javax.swing.JToggleButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        readyBTM.setText("Listo");
        readyBTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyBTMActionPerformed(evt);
            }
        });

        deleteBTM.setText("Borrar");
        deleteBTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTMActionPerformed(evt);
            }
        });

        closeBTM.setText("Volver");

        jLabel1.setText("Reseña");

        reviewTA.setColumns(20);
        reviewTA.setRows(5);
        jScrollPane1.setViewportView(reviewTA);

        javax.swing.GroupLayout reviewPaneLayout = new javax.swing.GroupLayout(reviewPane);
        reviewPane.setLayout(reviewPaneLayout);
        reviewPaneLayout.setHorizontalGroup(
            reviewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        reviewPaneLayout.setVerticalGroup(
            reviewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        editTBTM.setText("Editar");
        editTBTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTBTMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeBTM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(editTBTM)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBTM)
                        .addGap(55, 55, 55)
                        .addComponent(readyBTM))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reviewPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readyBTM)
                    .addComponent(deleteBTM)
                    .addComponent(closeBTM)
                    .addComponent(editTBTM))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editTBTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTBTMActionPerformed
        if (!editable()){
            reviewTA.setEditable(true);
        } else {
            reviewTA.setEditable(false);
        }
    }//GEN-LAST:event_editTBTMActionPerformed

    private void readyBTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyBTMActionPerformed
        boolean v = !reviewTA.getText().equals("");
        int act = 0;
        if (rows){
            ArrayList<Review> rev = ReviewDAO.findAll();
            Review review = new Review();
            for (Review r: rev){
                if (r.getUser_id() == current_user.getId_user() && r.getCoach_id() == cReviewed.getId_couch()){
                    review = r;
                    break;
                }
            }
            review.setContent(reviewTA.getText());
            if (ReviewDAO.update(review) > 0){
                JOptionPane.showMessageDialog(this, "Review actualizada");
                act++;
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
        } else if (v){
            Review rev = new Review();
            rev.setUser_id(current_user.getId_user());
            rev.setCoach_id(cReviewed.getId_couch());;
            rev.setContent(reviewTA.getText());
            if (ReviewDAO.create(rev) > 0){
                JOptionPane.showMessageDialog(this, "Review creada");
                act++;
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear review");
            }
        }
        if (act > 0){
            ReView refresh = new ReView(current_user, cReviewed);
            this.dispose();
            refresh.setVisible(true);
        }
    }//GEN-LAST:event_readyBTMActionPerformed

    private void deleteBTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTMActionPerformed
        if (rows){
            ArrayList<Review> rev = ReviewDAO.findAll();
            Review review = new Review();
            for (Review r: rev){
                if (r.getUser_id() == current_user.getId_user() && r.getCoach_id() == cReviewed.getId_couch()){
                    review = r;
                    break;
                }
            }
            if (ReviewDAO.delete(review.getId_review()) > 0){
                rows = false;
                JOptionPane.showMessageDialog(this, "Borrada con exito");
            } else {
                JOptionPane.showMessageDialog(this, "Borra");
            }
        }
    }//GEN-LAST:event_deleteBTMActionPerformed

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
            java.util.logging.Logger.getLogger(ReView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBTM;
    private javax.swing.JButton deleteBTM;
    private javax.swing.JToggleButton editTBTM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton readyBTM;
    private javax.swing.JPanel reviewPane;
    private javax.swing.JTextArea reviewTA;
    // End of variables declaration//GEN-END:variables
}
