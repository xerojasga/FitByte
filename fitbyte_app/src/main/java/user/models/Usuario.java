/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Usuario {
    int id_usuario;
    String username;
    String nombre;
    String apellido;
    String email;
    int pais_id;
    int altura;
    int peso;
    int edad;
    boolean admin;
    String password;
    String descripcion;

  
    public Usuario(){
    }
    public Usuario(String username, String primer_nombre, String apellido, String email, int pais_id, int altura, int peso, int edad, boolean admin, String password, String descripcion) {
        this.username = username;
        this.nombre = primer_nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais_id = pais_id;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.admin = admin;
        this.password = password;
        this.descripcion = descripcion;
    }
    
    public Usuario(int id_usuario, String username, String primer_nombre, String apellido, String email, int pais_id, int altura, int peso, int edad, boolean admin, String password, String descripcion) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.nombre = primer_nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais_id = pais_id;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.admin = admin;
        this.password = password;
        this.descripcion = descripcion;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }
    
   
    
}
