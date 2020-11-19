/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.models;

/**
@author Brayan Portela
 * Version 1.5 of the class
 * For changes please refer to GitHub Documentation
 */

public class Country {
    //Atributes definition
    private int Id_country;
    private String Name;
    
    //Construction methods based on their usage
    public Country() {
    }
    
    public Country(int CountryID, String name) {
        this.Id_country = CountryID;
        this.Name = name;
    }

    public Country(int Country_ID) {
        this.Id_country = Country_ID;
    }

    //getter and setter methods for each attribute
    public int getId_country() {
        return Id_country;
    }

    public void setId_country(int Id_country) {
        this.Id_country = Id_country;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
 
}