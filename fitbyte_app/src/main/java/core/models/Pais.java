/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.models;

/**
@author Brayan Portela
 * Version 1.0 of the class
 * For changes please refer to GitHub Documentation
 */

public class Pais {
    private int ID_PAIS;
    private String NOMBRE;
    
    //Empty constructor for non-initialized fields in the object
    public Pais() {
    }
    
    //Constructor with an entire set of data
    public Pais(int id_pais, String nombre_pais) {
        this.ID_PAIS = id_pais;
        this.NOMBRE = nombre_pais;
    }

    public Pais(int id_pais) {
        this.ID_PAIS = id_pais;
    }

    //Getters and setters
    public int getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(int ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }
 
}