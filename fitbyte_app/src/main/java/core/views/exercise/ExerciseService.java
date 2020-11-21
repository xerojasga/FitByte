package core.views.exercise;

import core.DAO.ExerciseDAO;
import core.models.Exercise;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */


/*private int exerciseID;
   private String exerciseDescription;
   private int burntHourCalorieExercise*/

public class ExerciseService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del ejercicio a mostrar (0 para todos los Ejercicios) \n >");
        int exerciseID = scanner.nextInt();
        if(exerciseID != 0){
            scanner.nextLine(); // Eat enter
            Exercise exercise = ExerciseDAO.find(exerciseID);
            if(exercise != null){                
                System.out.println("id Ejercicio"+ exercise.getExerciseID());
                System.out.println("Descripcion ejercicio: "+ exercise.getExerciseDescription());
                System.out.println("calorias quemadas por hora : "+ exercise.getBurntHourCalorieExercise());
                        
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Exercise> data = ExerciseDAO.findAll();
            for(Exercise i : data){
                System.out.println("id ejercicio"+ i.getExerciseID());
                System.out.println("Descripcion ejercicio: "+ i.getExerciseDescription());
                System.out.println("Calorias Quemadas por hora : "+ i.getBurntHourCalorieExercise());
            }
        }
    }
    
    public static void create(){
        Exercise registro = new Exercise();
        System.out.println("------------------------");
        System.out.println("Escribe la ID de tu ejercicio");
        registro.setExerciseID(scanner.nextInt());
        scanner.nextLine();
        System.out.println("------------------------");
        System.out.println("Escribe la descripcion de tu ejercicio");
        registro.setExerciseDescription(scanner.nextLine());
        System.out.println("------------------------");
        System.out.println("Ingresa la cantidad de calorias quemadas por hora de tu ejercicio");
        registro.setBurntHourCalorieExercise(scanner.nextInt());
        
        
        if(ExerciseDAO.create(registro)>0){
            System.out.println("el ejercicio fue añadido");
        }else{
            System.out.println("Hubo un error al crear el ejercicio");
        }
        
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del ejercicio a actualizar");
        Exercise exercise = ExerciseDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual ejercicio que deseas cambiar");
        System.out.println("id:" + exercise.getExerciseID());
        System.out.println("Descripcion de ejercicio:" + exercise.getExerciseDescription());
        System.out.println("Calorias quemadas por hora"+ exercise.getBurntHourCalorieExercise());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.Descripcion ejercicio");
        System.out.println("2.Cantidad calorias quemadas por hora");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(exercise != null){
            switch(opcion){
                case 1:
                    System.out.println("indica la nueva descripcion del ejercicio");
                     
                    exercise.setExerciseDescription(scanner.nextLine());
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("indica cantidad de calorias quemadas por hora");
                    exercise.setBurntHourCalorieExercise(scanner.nextInt());
                    break;
                default:
                    break;
            }

            if(ExerciseDAO.update(exercise)>0){
                System.out.println("el ejercicio fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el ejercicio");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del ejercicio a borrar \n >");
        if(ExerciseDAO.delete(scanner.nextInt())>0){
            System.out.println("El ejercicio fue eliminado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
    
    
}