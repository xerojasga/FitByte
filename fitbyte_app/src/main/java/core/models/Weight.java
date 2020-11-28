/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.models;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Weight {
    //Atributes Definition
    private int Id_weight;
    private int user_Id;
    private int weight;
    private Date date;
    
//constructors

    public Weight() {
    }

    public Weight(int Id_weight) {
        this.Id_weight = Id_weight;
    }

    public Weight(int Id_weight, int user_Id) {
        this.Id_weight = Id_weight;
        this.user_Id = user_Id;
    }

    public Weight(int Id_weight, int user_Id, int weight) {
        this.Id_weight = Id_weight;
        this.user_Id = user_Id;
        this.weight = weight;
    }

    public Weight(int Id_weight, int weight, Date date) {
        this.Id_weight = Id_weight;
        this.weight = weight;
        this.date = date;
    }

    public Weight(int Id_weight, int user_Id, int weight, Date date) {
        this.Id_weight = Id_weight;
        this.user_Id = user_Id;
        this.weight = weight;
        this.date = date;
    }

    

    //Getters and setters

    public int getId_weight() {
        return Id_weight;
    }

    public void setId_weight(int Id_weight) {
        this.Id_weight = Id_weight;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
