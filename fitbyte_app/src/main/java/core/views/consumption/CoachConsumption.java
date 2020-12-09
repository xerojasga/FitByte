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
import core.DAO.plateIngredientDAO;
import core.models.plateIngredient;
import core.models.Exercise;
import core.models.User_Coach;
import core.models.Ingredient;
import core.models.Plate;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import user.DAO.UserDAO;
import user.models.User;

/**
 *
 * @author Diego
 */
public class CoachConsumption extends javax.swing.JPanel {
    private static User current_user;
    private int cal = 0;
    
    /**
     * Creates new form CoachConsumption
     */
    public CoachConsumption(User user) {
        user = current_user;
        initComponents();
        String s = "Seleccionar";
        DefaultComboBoxModel modelUser = new DefaultComboBoxModel();
        ArrayList<User_Coach> users = User_CoachDAO.find_all_User(current_user.getId_user());
        DefaultComboBoxModel modelIngre = new DefaultComboBoxModel();
        ArrayList<Ingredient> ingredients = IngredientDAO.findAll();
        DefaultComboBoxModel modelPlate = new DefaultComboBoxModel();
        ArrayList<Plate> plates = PlateDAO.findAll();
        DefaultComboBoxModel modelExer = new DefaultComboBoxModel();
        ArrayList<Exercise> exercises = ExerciseDAO.findAll();
        DefaultComboBoxModel modelWeak = new DefaultComboBoxModel();
        ArrayList<String> weakDays = daySet();
        
        for(User_Coach u_c: users){
            User u = UserDAO.find(u_c.getUser_id());
            modelUser.addElement(u.getUsername());
        }
        modelIngre.addElement(s);
        for(Ingredient ingredient: ingredients){
            modelIngre.addElement(ingredient.getName());
        }
        modelPlate.addElement(s);
        for(Plate plate: plates){
            modelPlate.addElement(plate.getPlateName());
        }
        for(Exercise exercise: exercises){
            modelExer.addElement(exercise.getExerciseName());
        }
        for(String day: weakDays){
            modelWeak.addElement(day);
        }
        userCBX.setModel(modelUser);
        ingredientCBX.setModel(modelIngre);
        plateCBX.setModel(modelPlate);
        exerciseCBX.setModel(modelExer);
        dayCBX.setModel(modelWeak);
        
        userCBX.setSelectedIndex(0);
        ingredientCBX.setSelectedIndex(0);
        plateCBX.setSelectedIndex(0);
        exerciseCBX.setSelectedIndex(0);
        dayCBX.setSelectedIndex(0);
    }
    private ArrayList<String> daySet(){
        ArrayList<String> d = new ArrayList<String>();
            String[] days = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
            for (int i = 0; i < days.length; i++){
                d.add(days[i]);
        }
        return d;
    }
    public User userSelected(){
        String uSelected = (String)userCBX.getSelectedItem();
        User u = UserDAO.find(uSelected);
        return u;
    }
    public int ingredient_id(){
        int r;
        if(ingredientCBX.getSelectedIndex() == 0){
            r = -1;
        } else {
            String a = (String)ingredientCBX.getSelectedItem();
            r = Integer.parseInt(a);
        }
        return r;
    }
    public int plate_id(){
        int r;
        if(plateCBX.getSelectedIndex() == 0){
            r = -1;
        } else {
            String a = (String)plateCBX.getSelectedItem();
            r = Integer.parseInt(a);
        }
        return r;
    }
    public int exercise_id(){
        String a = (String)exerciseCBX.getSelectedItem();
        ArrayList<Exercise> exercises = ExerciseDAO.findAll();
        Exercise ex = null;
        for (Exercise e: exercises){
            if (e.getExerciseName().equals(a)){
                ex = e;
                break;
            }
        }
        return ex.getExerciseID();
    }
    public int num_horas_exer(){
        return Integer.parseInt(hExerTF.getText());
    }
    public String recDay(){
        String a = (String)dayCBX.getSelectedItem();
        return a;
    }
    public int calories(){
        int i = 0;
        if (ingredient_id() != -1)i = IngredientDAO.find(ingredient_id()).getCalories();
        int p = 0;
        if (plate_id() != -1){
            ArrayList<plateIngredient> pIngredients = plateIngredientDAO.findAll();
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            for (plateIngredient pi: pIngredients){
                if (plate_id() == pi.getPlateIngredientPlateID()){
                    Ingredient ing = IngredientDAO.find(pi.getPlateIngredientIngredientID());
                    ingredients.add(ing);
                }
            }
            for (Ingredient ing: ingredients){
                p = p + ing.getCalories();
            }
        }        
        int e = ExerciseDAO.find(exercise_id()).getBurntHourCalorieExercise();
        int h = num_horas_exer();
        return i + p - e * h;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        userPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ingredientCBX = new javax.swing.JComboBox<>();
        plateCBX = new javax.swing.JComboBox<>();
        exerciseCBX = new javax.swing.JComboBox<>();
        hExerTF = new javax.swing.JTextField();
        dayCBX = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        userCBX = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Ingrediente:");

        jLabel3.setText("Plato:");

        jLabel4.setText("Ejercicio:");

        jLabel5.setText("Horas de ejercicio:");

        jLabel6.setText("Dia de la semana");

        ingredientCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ingredientCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientCBXActionPerformed(evt);
            }
        });

        plateCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        exerciseCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        hExerTF.setText("0");
        hExerTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hExerTFActionPerformed(evt);
            }
        });

        dayCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dayCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCBXActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        userCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout userPaneLayout = new javax.swing.GroupLayout(userPane);
        userPane.setLayout(userPaneLayout);
        userPaneLayout.setHorizontalGroup(
            userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneLayout.createSequentialGroup()
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPaneLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6))
                            .addGroup(userPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(17, 17, 17)))
                        .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userPaneLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exerciseCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hExerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(userPaneLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(plateCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPaneLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(dayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userCBX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ingredientCBX, 0, 176, Short.MAX_VALUE))))))
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5))
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        userPaneLayout.setVerticalGroup(
            userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ingredientCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(plateCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exerciseCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hExerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(userPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(userPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ingredientCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientCBXActionPerformed

    private void hExerTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hExerTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hExerTFActionPerformed

    private void dayCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayCBXActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dayCBX;
    private javax.swing.JComboBox<String> exerciseCBX;
    private javax.swing.JTextField hExerTF;
    private javax.swing.JComboBox<String> ingredientCBX;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> plateCBX;
    private javax.swing.JComboBox<String> userCBX;
    private javax.swing.JPanel userPane;
    // End of variables declaration//GEN-END:variables
}
