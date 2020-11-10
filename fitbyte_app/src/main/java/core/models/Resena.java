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
public class Resena {
    int id_resena;
    int usuario_id;
    int entrenador_id;
    String contenido;
    
    public Resena(){
    }
    public Resena(int id_resena){
        this.id_resena = id_resena;
    }
    public Resena(int id_resena, int usuario_id){
        this(id_resena);
        this.usuario_id = usuario_id;
    }
    public Resena(int id_resena, int usuario_id, int entrenador_id){
        this(id_resena, usuario_id);
        this.entrenador_id = entrenador_id;
    }
    public Resena(int id_resena, int usuario_id, int entrenador_id, String contenido){
        this(id_resena, usuario_id, entrenador_id);
        this.contenido = contenido;
    }

    public int getId_resena() {
        return id_resena;
    }

    public void setId_resena(int id_resena) {
        this.id_resena = id_resena;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getEntrenador_id() {
        return entrenador_id;
    }

    public void setEntrenador_id(int entrenador_id) {
        this.entrenador_id = entrenador_id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
