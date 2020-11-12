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
public class Request {
    
    int id_request ;
    int user_id ;
    int coach_id ;
    boolean accepted;

    public Request() {
    }

    
    public Request(int usuario_id, int u_entrenador_id, boolean aceptada) {
        this.user_id = usuario_id;
        this.coach_id = u_entrenador_id;
        this.accepted = aceptada;
    }

    public Request(int id_solicitud, int usuario_id, int u_entrenador_id, boolean aceptada) {
        this.id_request = id_solicitud;
        this.user_id = usuario_id;
        this.coach_id = u_entrenador_id;
        this.accepted = aceptada;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
}
