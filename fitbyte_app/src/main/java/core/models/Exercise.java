package core.models;

public class Exercise{
   private int exerciseID;
   private String exerciseName;
   private String exerciseDescription;
   private int burntHourCalorieExercise;

    public Exercise(){}
    public Exercise(int exerciseID){
        this.exerciseID=exerciseID;
    }
    public Exercise(int exerciseID, String exerciseName, String exerciseDescription){
        this.exerciseID=exerciseID;
        this.exerciseName = exerciseName;
    	this.exerciseDescription=exerciseDescription;
    }
    public Exercise(int exerciseID, String exerciseName, String exerciseDescription,int burntHourCalorieExercise){
    	this.exerciseID=exerciseID;
    	this.exerciseName = exerciseName;
        this.exerciseDescription=exerciseDescription;
        this.burntHourCalorieExercise=burntHourCalorieExercise;}

    public void setExerciseID(int ExerciseID){this.exerciseID=ExerciseID;}
    public void setExerciseDescription(String exerciseDescription){this.exerciseDescription=exerciseDescription;}
    public void setBurntHourCalorieExercise(int burntHourCalorieExercise){this.burntHourCalorieExercise=burntHourCalorieExercise;}
    
    public int getExerciseID(){return exerciseID;}
    public String getExerciseDescription(){return exerciseDescription;}
    public int getBurntHourCalorieExercise(){return burntHourCalorieExercise;}

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    
}