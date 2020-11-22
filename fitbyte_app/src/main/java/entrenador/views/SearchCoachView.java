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
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("USERNAME");
        columnas.add("EMAIL");
        for(Object columna : columnas){
            model.addColumn(columna);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        usuariosTabla = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        usernameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entrenadorSeleccionadoLabel = new javax.swing.JLabel();
        send_requestBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscador de Entrenador");

        usuariosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "USERNAME", "EMAIL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        usuariosTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntrenadorMouseCliked(evt);
            }
        });
        jScrollPane1.setViewportView(usuariosTabla);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("usuario seleccionado :");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(send_requestBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(116, 116, 116)
                            .addComponent(entrenadorSeleccionadoLabel))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(entrenadorSeleccionadoLabel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_requestBtn)
                    .addComponent(backBtn))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("USERNAME");
        columnas.add("EMAIL");
        for(Object columna : columnas){
            model.addColumn(columna);
        }
        ArrayList<User> usuarios = UserDAO.findAllCoach(usernameInput.getText());
        System.out.println(usuarios);
        for(User usuario : usuarios){
            System.out.println("username:" + usuario.getUsername());
            Object[] data = new Object[]{usuario.getId_user(),usuario.getUsername(),usuario.getEmail()};
            model.addRow(data);
        }
        usuariosTabla.setModel(model);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void send_requestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_requestBtnActionPerformed
        Request existing_request = RequestDAO.find(current_user.getId_user(), selected_coach.getUser_id(),"Entrenamiento");
        
        int id_coach = selected_coach.getId_couch();
        User_Coach user_coach = User_CoachDAO.find( current_user.getId_user(),id_coach );
        
        if(user_coach == null){
            if(existing_request == null){
                Request request = new Request(current_user.getId_user(),selected_coach.getUser_id(),"Entrenamiento"); 
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

    private void EntrenadorMouseCliked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrenadorMouseCliked
        // TODO add your handling code here:
        int row = usuariosTabla.getSelectedRow();
        int user_coach_id = (int) usuariosTabla.getValueAt(row, 0);
        String code = usuariosTabla.getValueAt(row, 0).toString();
        String username = usuariosTabla.getValueAt(row, 1).toString();
        entrenadorSeleccionadoLabel.setText(username);
        selected_coach = CoachDAO.find(user_coach_id);
    }//GEN-LAST:event_EntrenadorMouseCliked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        HomeView home = new HomeView(current_user);
        home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel entrenadorSeleccionadoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton send_requestBtn;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JTable usuariosTabla;
    // End of variables declaration//GEN-END:variables
}
