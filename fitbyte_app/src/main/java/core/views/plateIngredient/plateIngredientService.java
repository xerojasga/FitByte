/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views.plateIngredient;

import core.DAO.plateIngredientDAO;
import core.models.plateIngredient;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */


/*private int plateIngredientID;
    private int plateID //Foreing
    private int ingredientID;*/

public class plateIngredientService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del ingrediente a mostrar (0 para todos los alimentos) \n >");
        int plateIngredientID = scanner.nextInt();
        if(plateIngredientID != 0){
            scanner.nextLine(); // Eat enter
            plateIngredient plateingredient = plateIngredientDAO.find(plateIngredientID);
            if(plateingredient != null){                
                System.out.println("id Plato Ingrediente"+ plateingredient.getPlateIngredientID());
                System.out.println("ID ingrediente: "+ plateingredient.getPlateIngredientIngredientID());
                System.out.println("ID Plato : "+ plateingredient.getPlateIngredientPlateID());
                        
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<plateIngredient> data = plateIngredientDAO.findAll();
            for(plateIngredient i : data){
                System.out.println("id Plato Ingrediente"+ i.getPlateIngredientID());
                System.out.println("ID ingrediente: "+ i.getPlateIngredientIngredientID());
                System.out.println("ID Plato : "+ i.getPlateIngredientPlateID());
            }
        }
    }
    
    public static void create(){
        plateIngredient registro = new plateIngredient();
        System.out.println("------------------------");
        System.out.println("Escribe la ID de tu ingrediente - plato");
        registro.setPlateIngredientID(scanner.nextInt());
        System.out.println("------------------------");
        System.out.println("Escribe la ID de tu plato para el ingrediente");
        registro.setPlateIngredientPlateID(scanner.nextInt());
        System.out.println("------------------------");
        System.out.println("Escribe la ID del ingrediente de tu plato");
        registro.setPlateIngredientIngredientID(scanner.nextInt());
        
        
        if(plateIngredientDAO.create(registro)>0){
            System.out.println("el ingrediente del plato fue añadido");
        }else{
            System.out.println("Hubo un error al crear el ingrediente para el plato");
        }
        
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del ingrediente del plato a actualizar");
        plateIngredient plateingredient = plateIngredientDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual ingrediente de plato que deseas cambiar");
        System.out.println("id:" + plateingredient.getPlateIngredientID());
        System.out.println("id Ingrediente:" + plateingredient.getPlateIngredientIngredientID());
        System.out.println("id Plato:"+ plateingredient.getPlateIngredientPlateID());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.ID Ingrediente");
        System.out.println("2.ID Plato");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(plateingredient != null){
            switch(opcion){
                case 1:
                    System.out.println("indica el nuevo ID de ingrediente");
                    scanner.nextLine(); // Eat enter
                    plateingredient.setPlateIngredientIngredientID(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("indica el nuevo id de plato");
                    plateingredient.setPlateIngredientPlateID(scanner.nextInt());
                    break;
                default:
                    break;
            }

            if(plateIngredientDAO.update(plateingredient)>0){
                System.out.println("el ingrediente del plato fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el ingrediente del plato");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del ingrediente de plato a borrar \n >");
        if(plateIngredientDAO.delete(scanner.nextInt())>0){
            System.out.println("El ingrediente de plato fue eliminado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
    
    
}
