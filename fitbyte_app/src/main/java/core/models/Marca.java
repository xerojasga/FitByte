/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author Xamir
 * Based On Xamir's implementation for Alimento.Java
 * Version 1.1 of the class
 * For changes please refer to GitHub Documentation
 */
public class Marca {
    int ID_MARCA;
    String NOMBRE;
    int PAIS_ID;

    public Marca(){
    }

    public Marca(int id_marca) {
        this.ID_MARCA = id_marca;
    }
     
   public Marca(String nombre_marca) {
        this.NOMBRE = nombre_marca;
    }

    public Marca(String nombre_marca, int pais_id) {
        this.NOMBRE = nombre_marca;
        this.PAIS_ID = pais_id;
    }

    public Marca(int id_marca, String nombre_marca, int pais_id) {
        this.ID_MARCA = id_marca;
        this.NOMBRE = nombre_marca;
        this.PAIS_ID = pais_id;
    }
    
    
   
    public int getID_MARCA() {
        return ID_MARCA;
    }

    public void setID_MARCA(int ID_MARCA) {
        this.ID_MARCA = ID_MARCA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getPAIS_ID() {
        return PAIS_ID;
    }

    public void setPAIS_ID(int PAIS_ID) {
        this.PAIS_ID = PAIS_ID;
    }
    
    
}
