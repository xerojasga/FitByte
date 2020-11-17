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
public class Request {
    
    int id_request ;
    int user_sender_id ;
    int user_receiver_id ;
    //agregar al constructor tipo
    String type;
    //type puede ser igual a "Amistad" o "Entrenamiento"
    
    public Request() {
    }

    public Request(int user_sender_id, int user_receiver_id, String type) {
        this.user_sender_id = user_sender_id;
        this.user_receiver_id = user_receiver_id;
        this.type = type;
    }

    public Request(int id_request, int user_sender_id, int user_receiver_id, String type) {
        this.id_request = id_request;
        this.user_sender_id = user_sender_id;
        this.user_receiver_id = user_receiver_id;
        this.type = type;
    }



    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public int getUser_sender_id() {
        return user_sender_id;
    }

    public void setUser_sender_id(int user_sender_id) {
        this.user_sender_id = user_sender_id;
    }

    public int getUser_receiver_id() {
        return user_receiver_id;
    }

    public void setUser_receiver_id(int user_receiver_id) {
        this.user_receiver_id = user_receiver_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
