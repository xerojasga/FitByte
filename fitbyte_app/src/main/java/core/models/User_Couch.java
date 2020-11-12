/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class User_Couch {
    int user_id;
    int couch_id;
    int status;

    public User_Couch(){
    }
    public User_Couch(int usuario_id, int entrenamiento_id, int status) {
        this.user_id = usuario_id;
        this.couch_id = entrenamiento_id;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
