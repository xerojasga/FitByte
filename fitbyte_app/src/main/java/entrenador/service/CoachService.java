/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.service;

import entrenador.DAO.CoachDAO;
import entrenador.models.Coach;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author developer
 */
public class CoachService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del entrenador a mostrar (0 oara todos los entrenadores) \n >");
        int id_coach = scanner.nextInt();
        if(id_coach != 0){
            scanner.nextLine(); // Eat enter
            Coach coach = CoachDAO.find(id_coach);
            if(coach != null){
                System.out.println("ID entrenador: "+ coach.getId_coach() );
                System.out.println("id usuario : "+ coach.getId_user());
                System.out.println("veridicado : " + coach.isVerified());
                System.out.println("calificacion : " + coach.getScore());
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Coach> data = CoachDAO.findAll();
            for(Coach coach : data){
                System.out.println("ID entrenador: "+ coach.getId_coach() );
                System.out.println("id usuario : "+ coach.getId_user());
                System.out.println("veridicado : " + coach.isVerified());
                System.out.println("calificacion : " + coach.getScore());
            }
        }
    }
    
    public static void create(){
        Coach coach = new Coach();
        System.out.println("------------------------");
        System.out.println("Escribe el id de usuario del entrenador");
        coach.setId_user(scanner.nextInt());
        System.out.println("Tu entrenador está verificado? (true/false)");
        coach.setVerified(scanner.nextBoolean());
        System.out.println("Escribe la calificación del entrenador");
        coach.setScore(scanner.nextInt());
        if(CoachDAO.create(coach)>0){
            System.out.println("El entrenador fue creado");
        }else{
            System.out.println("Hubo un error al crear el entrenador");
        }
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del entrenador a actualizar");
        Coach coach = CoachDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ coach.getId_coach() );
        System.out.println("id usuario : "+ coach.getId_user());
        System.out.println("veridicado : " + coach.isVerified());
        System.out.println("calificacion : " + coach.getScore());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.verificacion");
        System.out.println("2.calificacion");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(coach != null){
            switch(opcion){
                case 1:
                    System.out.println("indica si el entrenador esta verificado o no (true / false)");
                    scanner.nextLine(); // Eat enter
                    coach.setVerified(scanner.nextBoolean());
                    break;
                case 2:
                    System.out.println("indica la nueva calificación del entrenador");
                    coach.setScore(scanner.nextInt());
                    break;
                default:
                    break;
            }
        System.out.println("info nueva del entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ coach.getId_coach() );
        System.out.println("id usuario : "+ coach.getId_user());
        System.out.println("veridicado : " + coach.isVerified());
        System.out.println("calificacion : " + coach.getScore());
        System.out.println("----------------------");
            if(CoachDAO.update(coach)>0){
                System.out.println("el entrenador fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el entrenador");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del entrenador a borrar \n >");
        if(CoachDAO.delete(scanner.nextInt())>0){
            System.out.println("El entrenador fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
}
