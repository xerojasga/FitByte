package com.core.models;

public class Exercise{
   private int exerciseID;
   private String exerciseDescription;
   private int burntHourCalorieExercise;

    public Exercise(){}
    public Exercise(int exerciseID){this.exerciseID=exerciseID;}
    public Exercise(int exerciseID, String exerciseDescription){
        this.exerciseID=exerciseID;
    	this.exerciseDescription=exerciseDescription;}
    public Exercise(int exerciseID, String exerciseDescription,int burntHourCalorieExercise){
    	this.exerciseID=exerciseID;
        this.exerciseDescription=exerciseDescription;
        this.burntHourCalorieExercise=burntHourCalorieExercise;}

    public void setExerciseID(int ExerciseID){this.exerciseID=ExerciseID;}
    public void setExerciseDescription(String exerciseDescription){this.exerciseDescription=exerciseDescription;}
    public void setBurntHourCalorieExercise(int burntHourCalorieExercise){this.burntHourCalorieExercise=burntHourCalorieExercise;}
    
    public int getExerciseID(){return exerciseID;}
    public String getExerciseDescription(){return exerciseDescription;}
    public int getBurntHourCalorieExercise(){return burntHourCalorieExercise;}
}