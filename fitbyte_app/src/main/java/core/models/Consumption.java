/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author Diego
 */
public class Consumption {
    int id_consumption;
    String date;
    boolean rec_coach;
    int user_id;
    int ingredient_id;
    int plate_id;
    int excersice_id;
    int calories;
    int num_hours_excers;
    String rec_day_weak;

    public Consumption() {
    }

    public Consumption(int id_consumo, String fecha, boolean rec_entrenador, int usuario_id, int ingrediente_id, int plato_id, int ejercicio_id,int calorias, int num_horas_ejerc, String rec_dia_semana) {
        this.id_consumption = id_consumo;
        this.date = fecha;
        this.rec_coach = rec_entrenador;
        this.user_id = usuario_id;
        this.ingredient_id = ingrediente_id;
        this.plate_id = plato_id;
        this.excersice_id = ejercicio_id;
        this.calories = calorias;
        this.num_hours_excers = num_horas_ejerc;
        this.rec_day_weak = rec_dia_semana;
    }

    public int getId_consumption() {
        return id_consumption;
    }

    public void setId_consumption(int id_consumption) {
        this.id_consumption = id_consumption;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public int getExcersice_id() {
        return excersice_id;
    }

    public void setExcersice_id(int excersice_id) {
        this.excersice_id = excersice_id;
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
