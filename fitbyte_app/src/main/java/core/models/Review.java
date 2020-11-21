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
public class Review {
    int id_review;
    int user_id;
    int coach_id;
    String content;
    
    public Review(){
    }
    public Review(int id_resena){
        this.id_review = id_resena;
    }
    public Review(int id_resena, int usuario_id){
        this(id_resena);
        this.user_id = usuario_id;
    }
    public Review(int id_resena, int usuario_id, int entrenador_id){
        this(id_resena, usuario_id);
        this.coach_id = entrenador_id;
    }
    public Review(int id_resena, int usuario_id, int entrenador_id, String contenido){
        this(id_resena, usuario_id, entrenador_id);
        this.content = contenido;
    }

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
