/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.service;

import entrenador.DAO.EntrenadorDAO;
import entrenador.models.Entrenador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author developer
 */
public class EntrenadorService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del entrenador a mostrar (0 oara todos los entrenadores) \n >");
        int id_entrenador = scanner.nextInt();
        if(id_entrenador != 0){
            scanner.nextLine(); // Eat enter
            Entrenador entrenador = EntrenadorDAO.find(id_entrenador);
            if(entrenador != null){
                System.out.println("ID entrenador: "+ entrenador.getId_entrenador() );
                System.out.println("id usuario : "+ entrenador.getUsuario_id());
                System.out.println("veridicado : " + entrenador.isVerificacion());
                System.out.println("calificacion : " + entrenador.getCalificacion());
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Entrenador> data = EntrenadorDAO.findAll();
            for(Entrenador entrenador : data){
                System.out.println("ID entrenador: "+ entrenador.getId_entrenador() );
                System.out.println("id usuario : "+ entrenador.getUsuario_id());
                System.out.println("veridicado : " + entrenador.isVerificacion());
                System.out.println("calificacion : " + entrenador.getCalificacion());
            }
        }
    }
    
    public static void create(){
        Entrenador registro = new Entrenador();
        System.out.println("------------------------");
        System.out.println("Escribe el id de usuario del entrenador");
        registro.setUsuario_id(scanner.nextInt());
        System.out.println("Tu entrenador está verificado? (true/false)");
        registro.setVerificacion(scanner.nextBoolean());
        System.out.println("Escribe la calificación del entrenador");
        registro.setCalificacion(scanner.nextInt());
        if(EntrenadorDAO.create(registro)>0){
            System.out.println("El entrenador fue creado");
        }else{
            System.out.println("Hubo un error al crear el entrenador");
        }
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del entrenador a actualizar");
        Entrenador entrenador = EntrenadorDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ entrenador.getId_entrenador() );
        System.out.println("id usuario : "+ entrenador.getUsuario_id());
        System.out.println("veridicado : " + entrenador.isVerificacion());
        System.out.println("calificacion : " + entrenador.getCalificacion());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.verificacion");
        System.out.println("2.calificacion");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(entrenador != null){
            switch(opcion){
                case 1:
                    System.out.println("indica si el entrenador esta verificado o no (true / false)");
                    scanner.nextLine(); // Eat enter
                    entrenador.setVerificacion(scanner.nextBoolean());
                    break;
                case 2:
                    System.out.println("indica la nueva calificación del entrenador");
                    entrenador.setCalificacion(scanner.nextInt());
                    break;
                default:
                    break;
            }
        System.out.println("info nueva del entrenador que deseas cambiar");
        System.out.println("ID entrenador: "+ entrenador.getId_entrenador() );
        System.out.println("id usuario : "+ entrenador.getUsuario_id());
        System.out.println("veridicado : " + entrenador.isVerificacion());
        System.out.println("calificacion : " + entrenador.getCalificacion());
        System.out.println("----------------------");
            if(EntrenadorDAO.update(entrenador)>0){
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
        if(EntrenadorDAO.delete(scanner.nextInt())>0){
            System.out.println("El entrenador fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
}
