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
public class User {
    int id_user;
    String username;
    String name;
    String last_name;
    String email;
    int country_id;
    int height;
    int weight;
    int age;
    boolean admin;
    String password;
    String description;
    int last_login;
    String type;
  
    public User(){
    }
    public User(String username, String primer_nombre, String apellido, String email, int pais_id, int altura, int peso, int edad, boolean admin, String password, String descripcion) {
        this.username = username;
        this.name = primer_nombre;
        this.last_name = apellido;
        this.email = email;
        this.country_id = pais_id;
        this.height = altura;
        this.weight = peso;
        this.age = edad;
        this.admin = admin;
        this.password = password;
        this.description = descripcion;
    }
    
    public User(int id_usuario, String username, String primer_nombre, String apellido, String email, int pais_id, int altura, int peso, int edad, boolean admin, String password, String descripcion) {
        this.id_user = id_usuario;
        this.username = username;
        this.name = primer_nombre;
        this.last_name = apellido;
        this.email = email;
        this.country_id = pais_id;
        this.height = altura;
        this.weight = peso;
        this.age = edad;
        this.admin = admin;
        this.password = password;
        this.description = descripcion;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
    
   
    
}
