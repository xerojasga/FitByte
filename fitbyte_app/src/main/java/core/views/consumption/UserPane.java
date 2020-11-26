/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views.consumption;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.DAO.ExerciseDAO;
import core.DAO.User_CoachDAO;
import core.DAO.IngredientDAO;
import core.DAO.PlateDAO;
import core.DAO.ConsumptionDAO;
import core.models.Consumption;
import core.models.Exercise;
import core.models.User_Coach;
import core.models.Ingredient;
import core.models.Plate;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import user.DAO.UserDAO;
import user.models.User;
import com.mycompany.fitbyte_app.MainView;
import core.DAO.plateIngredientDAO;
import core.models.plateIngredient;
import core.views.HomeView;
import java.sql.Date;
/**
 *
 * @author Diego
 */
public class UserPane extends javax.swing.JPanel {
    private static User current_user = new User();
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form UconsumptionView
     */
    public UserPane(User user) {
        this.current_user = user;
        initComponents();
        DefaultComboBoxModel modelWeak = new DefaultComboBoxModel();
        ArrayList<String> weakDays = daySet();
        for(String day: weakDays){
            modelWeak.addElement(day);
        }
        dayCBX.setModel(modelWeak);
        dayCBX.setSelectedIndex(0);
        
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("Ingrediente");
        columnas.add("Plato");
        columnas.add("Ejercicio");
        columnas.add("Calorias");
        columnas.add("Horas de Ejercicio");
        columnas.add("Dia de la semana");
        for (Object columna: columnas){
            model.addColumn(columna);
        }
        
    }
    private ArrayList<String> daySet(){
        ArrayList<String> d = new ArrayList<String>();
            String[] days = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
            for (int i = 0; i < days.length; i++){
                d.add(days[i]);
        }
        return d;
    }
    public String recDay(){
        String a = (String)dayCBX.getSelectedItem();
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        coachPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consumptionTable = new javax.swing.JTable();
        dayCBX = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selectBTM = new javax.swing.JButton();

        jButton1.setText("jButton1");

        consumptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ingrediente", "Plato", "Ejercicio", "Calorias", "Horas de Ejercicio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(consumptionTable);

        dayCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Seleccione un dia de la semana:");

        selectBTM.setText("Seleccionar");
        selectBTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBTMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coachPanelLayout = new javax.swing.GroupLayout(coachPanel);
        coachPanel.setLayout(coachPanelLayout);
        coachPanelLayout.setHorizontalGroup(
            coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(dayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectBTM)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        coachPanelLayout.setVerticalGroup(
            coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachPanelLayout.createSequentialGroup()
                .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(selectBTM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(coachPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectBTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBTMActionPerformed
        ArrayList<Consumption> cons = ConsumptionDAO.findAll();
        ArrayList<Consumption> consumptions = new ArrayList<>();
        for (Consumption c: cons){
            if (c.getRec_day_weak().equals(recDay()) && c.getUser_id() == current_user.getId_user()){
                consumptions.add(c);
            }
        }
        for (Consumption c: consumptions){
            String ingredient = IngredientDAO.find(c.getIngredient_id()).getName();
            String plate = PlateDAO.find(c.getPlate_id()).getPlateName();
            String exercise = ExerciseDAO.find(c.getExercise_id()).getExerciseName();
            int calories = c.getCalories();
            int hExer = c.getNum_hours_excers();
            String weakDay = c.getRec_day_weak();
            Object[] data = new Object[]{ingredient, plate, exercise, calories, hExer, weakDay};
            model.addRow(data);
        }
        consumptionTable.setModel(model);
    }//GEN-LAST:event_selectBTMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel coachPanel;
    private javax.swing.JTable consumptionTable;
    private javax.swing.JComboBox<String> dayCBX;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectBTM;
    // End of variables declaration//GEN-END:variables
}
