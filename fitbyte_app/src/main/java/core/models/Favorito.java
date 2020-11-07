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
public class Favorito {
    int id_favorito;
    String fecha;
    String tipo;
    int usuario_id;
    int ingrediente_id;
    int plato_id;
    int ejercicio_id;

    public Favorito() {
    }

    public Favorito(int id_favorito, String fecha, String tipo, int usuario_id, int ingrediente_id, int plato_id, int ejercicio_id) {
        this.id_favorito = id_favorito;
        this.fecha = fecha;
        this.tipo = tipo;
        this.usuario_id = usuario_id;
        this.ingrediente_id = ingrediente_id;
        this.plato_id = plato_id;
        this.ejercicio_id = ejercicio_id;
    }

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getIngrediente_id() {
        return ingrediente_id;
    }

    public void setIngrediente_id(int ingrediente_id) {
        this.ingrediente_id = ingrediente_id;
    }

    public int getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(int plato_id) {
        this.plato_id = plato_id;
    }

    public int getEjercicio_id() {
        return ejercicio_id;
    }

    public void setEjercicio_id(int ejercicio_id) {
        this.ejercicio_id = ejercicio_id;
    }
    
    
    
    
    
}
