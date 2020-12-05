/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

import java.sql.Date;
/**
 *
 * @author Diego
 */
public class Consumption {
    int id_consumption;
    Date date;
    boolean rec_coach;
    int user_id;
    int ingredient_id;
    int plate_id;
    int exercise_id;
    int calories;
    int num_hours_excers;
    String rec_day_weak;
    
    public Consumption() {
    }
    
    
    public Consumption(int id_consumption, Date date, boolean rec_coach, int user_id, int ingredient_id, int plate_id, int excersice_id, int calories, int num_hours_excers, String rec_day_weak) {
        this.id_consumption = id_consumption;
        this.date = date;
        this.rec_coach = rec_coach;
        this.user_id = user_id;
        this.ingredient_id = ingredient_id;
        this.plate_id = plate_id;
        this.exercise_id = excersice_id;
        this.calories = calories;
        this.num_hours_excers = num_hours_excers;
        this.rec_day_weak = rec_day_weak;
    }

    public Consumption(int id_consumption, Date date, int plate_id, int exercise_id, int calories, int num_hours_excers, String rec_day_weak) {
        this.id_consumption = id_consumption;
        this.date = date;
        this.plate_id = plate_id;
        this.exercise_id = exercise_id;
        this.calories = calories;
        this.num_hours_excers = num_hours_excers;
        this.rec_day_weak = rec_day_weak;
    }

    

    
    public int getId_consumption() {
        return id_consumption;
    }

    public void setId_consumption(int id_consumption) {
        this.id_consumption = id_consumption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRec_coach() {
        return rec_coach;
    }

    public void setRec_coach(boolean rec_coach) {
        this.rec_coach = rec_coach;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(int plate_id) {
        this.plate_id = plate_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    
    

    public int getNum_hours_excers() {
        return num_hours_excers;
    }

    public void setNum_hours_excers(int num_hours_excers) {
        this.num_hours_excers = num_hours_excers;
    }

    public String getRec_day_weak() {
        return rec_day_weak;
    }

    public void setRec_day_weak(String rec_day_weak) {
        this.rec_day_weak = rec_day_weak;
    }
    
}
