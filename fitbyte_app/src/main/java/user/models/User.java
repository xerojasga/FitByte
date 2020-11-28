/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.models;

import java.sql.Date;

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
    // agregar a los constructores :
    Date last_login;
    String type;
    //eliminar weight
    //hacer DAOs de lo nuevo

    public User() {
    }

    public User(String username, String name, String last_name, String email, int country_id, int height, int weight, int age, boolean admin, String password, String description, Date last_login, String type) {
        this.id_user = id_user;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.country_id = country_id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.admin = admin;
        this.password = password;
        this.description = description;
        this.last_login = last_login;
        this.type = type;
    }
    
    public User(int id_user, String username, String name, String last_name, String email, int country_id, int height, int weight, int age, boolean admin, String password, String description, Date last_login, String type) {
        this.id_user = id_user;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.country_id = country_id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.admin = admin;
        this.password = password;
        this.description = description;
        this.last_login = last_login;
        this.type = type;
    }
    
    public User(int id_user, String username, String name, String last_name, String email, String password, Date last_login,String type) {
        this.id_user = id_user;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.last_login = last_login;
        this.type = type;
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
    
    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
  
   
    
}
