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
public class User_Coach {
    int id_user_coach;
    int user_id;
    int couch_id;
    boolean active;

    public User_Coach(){
    }
    public User_Coach(int usuario_id, int entrenamiento_id, boolean active) {
        this.user_id = usuario_id;
        this.couch_id = entrenamiento_id;
        this.active = active;
    }
    
    public User_Coach(int id_user_coach,int usuario_id, int entrenamiento_id, boolean active) {
        this.id_user_coach = id_user_coach;
        this.user_id = usuario_id;
        this.couch_id = entrenamiento_id;
        this.active = active;
    }
    
    public int getId_user_coach() {
        return id_user_coach;
    }

    public void setId_user_coach(int id_user_coach) {
        this.id_user_coach = id_user_coach;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCouch_id() {
        return couch_id;
    }

    public void setCouch_id(int couch_id) {
        this.couch_id = couch_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
