/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

/**
 *
 * @author Xamir
 * @Modified_by : Brayan
 * Version 1.5 of the class
 * For changes please refer to GitHub Documentation
 */
public class Ingredient {
    //Atributes definition
    private int Id_ingredient;
    private String Name;
    private int Brand_id;
    private int Calories;
    private int Carbohidrates;
    private int Proteins;
   
    //Construction methods based on their usage
    public Ingredient(){
    }

    public Ingredient(String Name, int Brand_id, int Calories, int Carbohidrates, int Proteins) {
        this.Name = Name;
        this.Brand_id = Brand_id;
        this.Calories = Calories;
        this.Carbohidrates = Carbohidrates;
        this.Proteins = Proteins;
    }
    
     public Ingredient(String name) {
        this.Name = name;
    }
     
    public Ingredient(String name, int brandID) {
        this.Name = name;
        this.Brand_id = brandID;
    }
    
    public Ingredient(int ingredientID, String name, int brandID) {
        this.Id_ingredient = ingredientID;
        this.Name = name;
        this.Brand_id = brandID;
    }

    public Ingredient(int ingredientID, int brandID, String name, int calories, int carbohidrates, int proteins) {
        this.Id_ingredient = ingredientID;
        this.Brand_id = brandID;
        this.Name = name;
        this.Calories = calories;
        this.Carbohidrates = carbohidrates;
        this.Proteins = proteins;
    }
    
    //getter and setter methods for each attribute
    public int getId_ingredient() {
        return Id_ingredient;
    }

    public void setId_ingredient(int Id_ingredient) {
        this.Id_ingredient = Id_ingredient;
    }

    public int getBrand_id() {
        return Brand_id;
    }

    public void setBrand_id(int FKbrandID) {
        this.Brand_id = FKbrandID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int Calories) {
        this.Calories = Calories;
    }

    public int getCarbohidrates() {
        return Carbohidrates;
    }

    public void setCarbohidrates(int Carbohidrates) {
        this.Carbohidrates = Carbohidrates;
    }

    public int getProteins() {
        return Proteins;
    }

    public void setProteins(int Proteins) {
        this.Proteins = Proteins;
    }


     
}
