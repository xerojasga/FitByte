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
public class Solicitud {
    
    int id_solicitud ;
    int usuario_id ;
    int u_entrenador_id ;
    boolean aceptada;

    public Solicitud() {
    }

    
    public Solicitud(int usuario_id, int u_entrenador_id, boolean aceptada) {
        this.usuario_id = usuario_id;
        this.u_entrenador_id = u_entrenador_id;
        this.aceptada = aceptada;
    }

    public Solicitud(int id_solicitud, int usuario_id, int u_entrenador_id, boolean aceptada) {
        this.id_solicitud = id_solicitud;
        this.usuario_id = usuario_id;
        this.u_entrenador_id = u_entrenador_id;
        this.aceptada = aceptada;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getU_entrenador_id() {
        return u_entrenador_id;
    }

    public void setU_entrenador_id(int u_entrenador_id) {
        this.u_entrenador_id = u_entrenador_id;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }
    
}
