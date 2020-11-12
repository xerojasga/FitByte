/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.service;

import entrenador.DAO.CouchDAO;
import entrenador.models.Couch;
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
            Couch coach = CouchDAO.find(id_coach);
            if(coach != null){
                System.out.println("ID entrenador: "+ coach.getId_couch() );
                System.out.println("id usuario : "+ coach.getUser_id());
                System.out.println("veridicado : " + coach.isVerificated());
                System.out.println("calificacion : " + coach.getCalification());
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Couch> data = CouchDAO.findAll();
            for(Couch coach : data){
                System.out.println("ID entrenador: "+ coach.getId_couch() );
                System.out.println("id usuario : "+ coach.getUser_id());
                System.out.println("veridicado : " + coach.isVerificated());
                System.out.println("calificacion : " + coach.getCalification());
            }
        }
    }
    
    public static void create(){
        Couch coach = new Couch();
        System.out.println("------------------------");
        System.out.println("Escribe el id de usuario del entrenador");
        coach.setUser_id(scanner.nextInt());
        System.out.println("Tu entrenador está verificado? (true/false)");
        coach.setVerificated(scanner.nextBoolean());
        System.out.println("Escribe la calificación del entrenador");
        coach.setCalification(scanner.nextInt());
        if(CouchDAO.create(coach)>0){
            System.out.println("El entrenador fue creado");
        }else{
            System.out.println("Hubo un error al crear el entrenador");
        }
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del entrenador a actualizar");
        Couch coach = CouchDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ coach.getId_couch() );
        System.out.println("id usuario : "+ coach.getUser_id());
        System.out.println("veridicado : " + coach.isVerificated());
        System.out.println("calificacion : " + coach.getCalification());
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
                    coach.setVerificated(scanner.nextBoolean());
                    break;
                case 2:
                    System.out.println("indica la nueva calificación del entrenador");
                    coach.setCalification(scanner.nextInt());
                    break;
                default:
                    break;
            }
        System.out.println("info nueva del entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ coach.getId_couch() );
        System.out.println("id usuario : "+ coach.getUser_id());
        System.out.println("veridicado : " + coach.isVerificated());
        System.out.println("calificacion : " + coach.getCalification());
        System.out.println("----------------------");
            if(CouchDAO.update(coach)>0){
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
        if(CouchDAO.delete(scanner.nextInt())>0){
            System.out.println("El entrenador fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
}
