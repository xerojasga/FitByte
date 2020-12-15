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
import core.views.consumption.ConsumptionView;
import java.sql.Date;
/**
 *
 * @author Diego
 */
public class ConsumptionCreate extends javax.swing.JFrame {
    private CCCPane coachCons;
   // private CCCPane coachCons;

    private static User current_user;
    
    /**
     * Creates new form ConsumptionCreate
     */
    public ConsumptionCreate(User user) {
        current_user = user;
        initComponents();
        this.setLocationRelativeTo(null);
        if (isCoach()){
            coachCons = new CCCPane(current_user);
            userPane.setVisible(false);
            userPane.removeAll();
            userPane.add(coachCons);
            userPane.setVisible(true);
        } else {
            String s = "Seleccionar";
            DefaultComboBoxModel modelIngre = new DefaultComboBoxModel();
            ArrayList<Ingredient> ingredients = IngredientDAO.findAll();
            DefaultComboBoxModel modelPlate = new DefaultComboBoxModel();
            ArrayList<Plate> plates = PlateDAO.findAll();
            DefaultComboBoxModel modelExer = new DefaultComboBoxModel();
            ArrayList<Exercise> exercises = ExerciseDAO.findAll();
            DefaultComboBoxModel modelWeak = new DefaultComboBoxModel();
            
            modelIngre.addElement(s);
            for(Ingredient ingredient: ingredients){
                modelIngre.addElement(ingredient.getName());
            }
            modelPlate.addElement(s);
            for(Plate plate: plates){
                modelPlate.addElement(plate.getPlateName());
            }
            modelExer.addElement(s);
            for(Exercise exercise: exercises){
                modelExer.addElement(exercise.getExerciseName());
            }
            
            ingredientCBX.setModel(modelIngre);
            plateCBX.setModel(modelPlate);
            exerciseCBX.setModel(modelExer);
        
            ingredientCBX.setSelectedIndex(0);
            plateCBX.setSelectedIndex(0);
            exerciseCBX.setSelectedIndex(0);
        }
        
    }
    
    private boolean isCoach(){
        return current_user.getType().equalsIgnoreCase("Entrenador");
    }
    
    public int ingredient_id(){
        int r;
        if(ingredientCBX.getSelectedIndex() == 0){
            r = -1;
        } else {
            String a = (String)ingredientCBX.getSelectedItem();
            Ingredient ing = IngredientDAO.find(a);
            r = ing.getId_ingredient();
        }
        return r;
    }
    public int plate_id(){
        int r;
        Plate pl = new Plate();
        if(plateCBX.getSelectedIndex() == 0){
            r = -1;
        } else {
            String a = (String)plateCBX.getSelectedItem();
            ArrayList<Plate> plates = PlateDAO.findAll();
            
            for (Plate p: plates){
                if (p.getPlateName().equals(a)){
                    pl = p;
                    break;
                }
            }
            r = pl.getPlateID();
        }
        return r;
    }
    public int exercise_id(){
        String a = (String)exerciseCBX.getSelectedItem();
        System.out.println(a);
        ArrayList<Exercise> exercises = ExerciseDAO.findAll();
        Exercise ex = new Exercise();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ingredientCBX = new javax.swing.JComboBox<>();
        plateCBX = new javax.swing.JComboBox<>();
        exerciseCBX = new javax.swing.JComboBox<>();
        hExerTF = new javax.swing.JTextField();
        acceptB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registrar Consumo");

        userPane.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Ingrediente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        userPane.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Plato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        userPane.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Ejercicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        userPane.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Horas de ejercicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        userPane.add(jLabel5, gridBagConstraints);

        ingredientCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ingredientCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientCBXActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 48, 0, 111);
        userPane.add(ingredientCBX, gridBagConstraints);

        plateCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 48, 0, 111);
        userPane.add(plateCBX, gridBagConstraints);

        exerciseCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 48, 0, 111);
        userPane.add(exerciseCBX, gridBagConstraints);

        hExerTF.setText("0");
        hExerTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hExerTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 168;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 48, 76, 111);
        userPane.add(hExerTF, gridBagConstraints);

        acceptB.setText("Aceptar");
        acceptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBActionPerformed(evt);
            }
        });

        cancelB.setText("Cancelar");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelB)
                        .addGap(18, 18, 18)
                        .addComponent(acceptB)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptB)
                    .addComponent(cancelB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBActionPerformed
        Consumption consumption = new Consumption();
        if (isCoach()){
            consumption.setDate(null);
            consumption.setRec_coach(true);
            User u = this.coachCons.userSelected();
            consumption.setUser_id(u.getId_user());
            consumption.setIngredient_id(coachCons.ingredient_id());
            consumption.setPlate_id(coachCons.plate_id());
            consumption.setExercise_id(coachCons.exercise_id());
            consumption.setNum_hours_excers(coachCons.num_horas_exer());
            consumption.setCalories(coachCons.calories());
            consumption.setRec_day_weak(coachCons.recDay());
            
            
        } else {
            consumption.setDate(new Date(System.currentTimeMillis()));
            consumption.setRec_coach(false);
            consumption.setUser_id(current_user.getId_user());
            consumption.setIngredient_id(ingredient_id());
            consumption.setPlate_id(plate_id());
            consumption.setExercise_id(exercise_id());
            consumption.setNum_hours_excers(num_horas_exer());
            consumption.setCalories(calories());
            consumption.setRec_day_weak(null);
        }
        if (ConsumptionDAO.create(consumption) > 0){
            //this.home.setConsumedCalories();
            //this.home.setCaloriesToConsume();
            JOptionPane.showMessageDialog(this, "Consumo registrado con exito");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el consumo");
        }
    }//GEN-LAST:event_acceptBActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        ConsumptionView back = new ConsumptionView(current_user);
        this.dispose();
        back.setVisible(true);
    }//GEN-LAST:event_cancelBActionPerformed

    private void ingredientCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientCBXActionPerformed

    private void hExerTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hExerTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hExerTFActionPerformed

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
            java.util.logging.Logger.getLogger(ConsumptionCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsumptionCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsumptionCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsumptionCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsumptionCreate(current_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptB;
    private javax.swing.JButton cancelB;
    private javax.swing.JComboBox<String> exerciseCBX;
    private javax.swing.JTextField hExerTF;
    private javax.swing.JComboBox<String> ingredientCBX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> plateCBX;
    private javax.swing.JPanel userPane;
    // End of variables declaration//GEN-END:variables
}
