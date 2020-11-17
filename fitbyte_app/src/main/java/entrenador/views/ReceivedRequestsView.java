/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrenador.views;

import core.DAO.RequestDAO;
import core.DAO.User_CoachDAO;
import core.models.Request;
import core.models.User_Coach;
import entrenador.DAO.CoachDAO;
import entrenador.models.Coach;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user.DAO.UserDAO;
import user.models.User;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReceivedRequestsView extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    
    public static User current_user = new User();
    User selected_user = new User();
    int id_selected_request ;
    /**
     * Creates new form ReceivedRequestsView
     */
    public ReceivedRequestsView(User user) {
        initComponents();
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Solicitud ID");
        columnas.add("ID");
        columnas.add("USERNAME");
        columnas.add("EMAIL");
        for(Object columna : columnas){
            model.addColumn(columna);
        }
        current_user = user;
        ArrayList<Request> requests = RequestDAO.find_all_received(current_user.getId_user(),"Entrenamiento");
        System.out.println(requests);
        for(Request request : requests){
            User temp_user ; 
            temp_user = UserDAO.find(request.getUser_sender_id());
            System.out.println("username:" + temp_user.getUsername());
            Object[] data = new Object[]{request.getId_request(),temp_user.getId_user(),temp_user.getUsername(),temp_user.getEmail()};
            model.addRow(data);
        }
        requestsTable.setModel(model);
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        requestsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        selected_userLabel = new javax.swing.JLabel();
        denyBtn = new javax.swing.JButton();
        acceptBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        selectedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Solicitudes de entrenamiento Recibidas");

        requestsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        requestsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClicked(evt);
            }
        });
        jScrollPane1.setViewportView(requestsTable);

        jLabel2.setText("Usuario Seleccionado");

        denyBtn.setText("Denegar");
        denyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyBtnActionPerformed(evt);
            }
        });

        acceptBtn.setText("Aceptar");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Volver");

        selectedLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selected_userLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(acceptBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(denyBtn)))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selected_userLabel)
                    .addComponent(selectedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denyBtn)
                    .addComponent(acceptBtn))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(backBtn)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClicked
        // TODO add your handling code here:
        int row = requestsTable.getSelectedRow();
        id_selected_request = (int) requestsTable.getValueAt(row, 0);
        int user_id = (int) requestsTable.getValueAt(row, 1);
        selected_user = UserDAO.find(user_id);
        String username = selected_user.getUsername();
        selectedLabel.setText(username);
        
    }//GEN-LAST:event_tableClicked

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        int id_user = selected_user.getId_user();
        int id_coach = CoachDAO.find(current_user.getId_user()).getId_couch() ;
        
        User_Coach user_coach = new User_Coach(id_user,id_coach,true);
        
        User_Coach previous = User_CoachDAO.find(current_user.getId_user(),selected_user.getId_user());
        if(previous == null){
            if(User_CoachDAO.create(user_coach)>0){
                RequestDAO.delete(id_selected_request);
                JOptionPane.showMessageDialog(this, "Acabas de aceptar la solicitud de entrenamiento");
            }else{
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
            }
        }else{
                JOptionPane.showMessageDialog(this, "Parece que ya estás entrenando a este usuario");
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        RequestDAO.delete(id_selected_request);
        JOptionPane.showMessageDialog(this, "Acabas de rechazar la solicitud de entrenamiento");
    }//GEN-LAST:event_denyBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReceivedRequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceivedRequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceivedRequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceivedRequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceivedRequestsView(current_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton denyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable requestsTable;
    private javax.swing.JLabel selectedLabel;
    private javax.swing.JLabel selected_userLabel;
    // End of variables declaration//GEN-END:variables
}