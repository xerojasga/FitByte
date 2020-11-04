/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author developer
 */
public class ingrediente {
    private int ID_INGREDIENTE;
    private String NOMBRE;
    private int MARCA_ID;
    private int CALORIAS;
    private int CARBOHIDRATOS;
    private int PROTEINAS;
    
    public ingrediente(){
    }
    
     public ingrediente(String nombre_alimento) {
        this.NOMBRE = nombre_alimento;
    }
     
    public ingrediente(String nombre_alimento, int marca_id) {
        this.NOMBRE = nombre_alimento;
        this.MARCA_ID = marca_id;
    }
    
    public ingrediente(int id_alimento, String nombre_alimento, int marca_id) {
        this.ID_INGREDIENTE = id_alimento;
        this.NOMBRE = nombre_alimento;
        this.MARCA_ID = marca_id;
    }

    public ingrediente(int id_alimento, int marca_id, String nombre_alimento, int calorias_alimento, int carbs_alimento, int prot_alimento) {
        this.ID_INGREDIENTE = id_alimento;
        this.MARCA_ID = marca_id;
        this.NOMBRE = nombre_alimento;
        this.CALORIAS = calorias_alimento;
        this.CARBOHIDRATOS = carbs_alimento;
        this.PROTEINAS = prot_alimento;
    }
    
    
    
    public int getID_INGREDIENTE() {
        return ID_INGREDIENTE;
    }

    public void setID_INGREDIENTE(int ID_INGREDIENTE) {
        this.ID_INGREDIENTE = ID_INGREDIENTE;
    }

    public int getMARCA_ID() {
        return MARCA_ID;
    }

    public void setMARCA_ID(int fk_marca_id) {
        this.MARCA_ID = fk_marca_id;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getCALORIAS() {
        return CALORIAS;
    }

    public void setCALORIAS(int CALORIAS) {
        this.CALORIAS = CALORIAS;
    }

    public int getCARBOHIDRATOS() {
        return CARBOHIDRATOS;
    }

    public void setCARBOHIDRATOS(int CARBOHIDRATOS) {
        this.CARBOHIDRATOS = CARBOHIDRATOS;
    }

    public int getPROTEINAS() {
        return PROTEINAS;
    }

    public void setPROTEINAS(int PROTEINAS) {
        this.PROTEINAS = PROTEINAS;
    }
    
    
}
