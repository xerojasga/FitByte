/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

public class plateIngredient{

 	private int plateIngredientID;
 	private int plateID; //Foreing
 	private int ingredientID; //Foreing, Subject to change
 
   public plateIngredient(){}
   public plateIngredient(int plateIngredientID){this.plateIngredientID=plateIngredientID;}
   public plateIngredient(int plateIngredientID, int plateID, int ingredientID){
   	this.plateIngredientID=plateIngredientID;
   	this.plateID=plateID;
   	this.ingredientID=ingredientID;
   }
   public plateIngredient(int plateIngredientID,int plateID){
   	this.plateIngredientID=plateIngredientID;
   	this.plateID=plateID;
   }

  public void setPlateIngredientID(int plateIngredientID){this.plateIngredientID=plateIngredientID;}
  public void setPlateIngredientPlateID (int plateID){this.plateID=plateID;}
  public void setPlateIngredientIngredientID(int ingredientID){this.ingredientID=ingredientID;}

  public int getPlateIngredientID(){return plateIngredientID;}
  public int getPlateIngredientPlateID(){return plateID;}
  public int getPlateIngredientIngredientID(){return ingredientID;}
}  