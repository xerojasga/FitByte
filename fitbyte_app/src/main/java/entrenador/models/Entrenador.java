/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Entrenador {
    int id_entrenador;
    int usuario_id;
    boolean verificacion;
    int calificacion;
    
    public Entrenador(){
    }
    
    public Entrenador(int usuario_id, boolean verificacion, int calificación) {
        this.usuario_id = usuario_id;
        this.verificacion = verificacion;
        this.calificacion = calificación;
    }
    
    public Entrenador(int id_entrenador, int usuario_id, boolean verificacion, int calificación) {
        this.id_entrenador = id_entrenador;
        this.usuario_id = usuario_id;
        this.verificacion = verificacion;
        this.calificacion = calificación;
    }

    public int getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(int id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public boolean isVerificacion() {
        return verificacion;
    }

    public void setVerificacion(boolean verificacion) {
        this.verificacion = verificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
           
    
}
