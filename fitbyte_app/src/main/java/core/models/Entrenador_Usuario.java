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
public class Entrenador_Usuario {
    int usuario_id;
    int entrenador_id;
    int status;

    public Entrenador_Usuario(){
    }
    public Entrenador_Usuario(int usuario_id, int entrenamiento_id, int status) {
        this.usuario_id = usuario_id;
        this.entrenador_id = entrenamiento_id;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
