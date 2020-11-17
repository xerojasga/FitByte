/*
 */

package entrenador.models;

/**
 * 
 * @author developer 
 */
public class Coach {
    int id_couch;
    int user_id;
    boolean verificated;
    int calification;
    int contact_number;
    // falta agregar phone numer a los constructores
    public Coach(){
    }
    
    public Coach(int user_id, boolean verificated, int calification) {
        this.user_id = user_id;
        this.verificated = verificated;
        this.calification = calification;
    }
    
    public Coach(int id_coach, int user_id, boolean verificated, int calification) {
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

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }
           
    
}
