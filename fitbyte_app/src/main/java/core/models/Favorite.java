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
public class Favorite {
    int id_favorite;
    String date;
    String type;
    int user_id;
    int ingredient_id;
    int plate_id;
    int excersice_id;

    public Favorite() {
    }

    public Favorite(int id_favorito, String fecha, String tipo, int usuario_id, int ingrediente_id, int plato_id, int ejercicio_id) {
        this.id_favorite = id_favorito;
        this.date = fecha;
        this.type = tipo;
        this.user_id = usuario_id;
        this.ingredient_id = ingrediente_id;
        this.plate_id = plato_id;
        this.excersice_id = ejercicio_id;
    }

    public int getId_favorite() {
        return id_favorite;
    }

    public void setId_favorite(int id_favorite) {
        this.id_favorite = id_favorite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    
    
    
    
    
}
