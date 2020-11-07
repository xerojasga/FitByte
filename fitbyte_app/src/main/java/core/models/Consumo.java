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
public class Consumo {
    int id_consumo;
    String fecha;
    boolean rec_entrenador;
    int usuario_id;
    int ingrediente_id;
    int plato_id;
    int ejercicio_id;
    int num_horas_ejerc;
    String rec_dia_semana;

    public Consumo() {
    }

    public Consumo(int id_consumo, String fecha, boolean rec_entrenador, int usuario_id, int ingrediente_id, int plato_id, int ejercicio_id, int num_horas_ejerc, String rec_dia_semana) {
        this.id_consumo = id_consumo;
        this.fecha = fecha;
        this.rec_entrenador = rec_entrenador;
        this.usuario_id = usuario_id;
        this.ingrediente_id = ingrediente_id;
        this.plato_id = plato_id;
        this.ejercicio_id = ejercicio_id;
        this.num_horas_ejerc = num_horas_ejerc;
        this.rec_dia_semana = rec_dia_semana;
    }

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isRec_entrenador() {
        return rec_entrenador;
    }

    public void setRec_entrenador(boolean rec_entrenador) {
        this.rec_entrenador = rec_entrenador;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getIngrediente_id() {
        return ingrediente_id;
    }

    public void setIngrediente_id(int ingrediente_id) {
        this.ingrediente_id = ingrediente_id;
    }

    public int getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(int plato_id) {
        this.plato_id = plato_id;
    }

    public int getEjercicio_id() {
        return ejercicio_id;
    }

    public void setEjercicio_id(int ejercicio_id) {
        this.ejercicio_id = ejercicio_id;
    }

    public int getNum_horas_ejerc() {
        return num_horas_ejerc;
    }

    public void setNum_horas_ejerc(int num_horas_ejerc) {
        this.num_horas_ejerc = num_horas_ejerc;
    }

    public String getRec_dia_semana() {
        return rec_dia_semana;
    }

    public void setRec_dia_semana(String rec_dia_semana) {
        this.rec_dia_semana = rec_dia_semana;
    }
    
}
