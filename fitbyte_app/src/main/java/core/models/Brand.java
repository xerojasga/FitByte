/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author Xamir
 * @Modified_by : Brayan
 * Version 1.5 of the class
 * For changes please refer to GitHub Documentation
 */
public class Brand {
    //Atributes definition
    int Id_brand;
    String Name;
    int Country_id;
    
    //Construction methods based on their usage
    public Brand(){
    }

    public Brand(int brandID) {
        this.Id_brand = brandID;
    }
     
   public Brand(String name) {
        this.Name = name;
    }

    public Brand(String name, int countryID) {
        this.Name = name;
        this.Country_id = countryID;
    }

    public Brand(int brandID, String name, int countryID) {
        this.Id_brand = brandID;
        this.Name = name;
        this.Country_id = countryID;
    }
    
    //getter and setter methods for each attribute
    public int getId_brand() {
        return Id_brand;
    }

    public void setId_brand(int Id_brand) {
        this.Id_brand = Id_brand;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCountry_id() {
        return Country_id;
    }

    public void setCountry_id(int Country_id) {
        this.Country_id = Country_id;
    }
    
    
}
