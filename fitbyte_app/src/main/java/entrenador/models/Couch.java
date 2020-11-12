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
public class Couch {
    int id_couch;
    int user_id;
    boolean verificated;
    int calification;
    
    public Couch(){
    }
    
    public Couch(int user_id, boolean verificated, int calification) {
        this.user_id = user_id;
        this.verificated = verificated;
        this.calification = calification;
    }
    
    public Couch(int id_coach, int user_id, boolean verificated, int calification) {
        this.id_couch = id_coach;
        this.user_id = user_id;
        this.verificated = verificated;
        this.calification = calification;
    }

    public int getId_couch() {
        return id_couch;
    }

    public void setId_couch(int id_couch) {
        this.id_couch = id_couch;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isVerificated() {
        return verificated;
    }

    public void setVerificated(boolean verificated) {
        this.verificated = verificated;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }
           
    
}
