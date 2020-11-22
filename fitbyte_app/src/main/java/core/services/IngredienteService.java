/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
package core.services;

import core.DAO.IngredienteDAO;
import core.models.Ingrediente;
import java.util.ArrayList;
import java.util.Scanner;

public class IngredienteService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del alimento a mostrar (0 oara todos los alimentos) \n >");
        int id_alimento = Integer.parseInt(scanner.nextLine());
        if(id_alimento != 0){
            Ingrediente alimento = IngredienteDAO.find(id_alimento);
            if(alimento != null){
                System.out.println("ID alimento: "+ alimento.getID_INGREDIENTE() );
                System.out.println("nombre alimento : "+ alimento.getNOMBRE());
                System.out.println("id marca : " + alimento.getMARCA_ID());        
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }
    }
    
    public static void findAll(){
         System.out.println("Esta es la lista de paises registrados");
          ArrayList<Ingrediente> data = IngredienteDAO.findAll();
          for(Ingrediente i : data){
               System.out.println("ID pais: "+i.getID_INGREDIENTE());
                System.out.println("nombre pais : "+ i.getNOMBRE());
                System.out.println("id marca : " + i.getMARCA_ID());
          }
     }
    
    public static void create(){
        Ingrediente registro = new Ingrediente();
        System.out.println("------------------------");
        System.out.println("Escribe el codigo del pais:");
        registro.setID_INGREDIENTE(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------");
        System.out.println("Escribe el nombre de tu alimento");
        registro.setNOMBRE(scanner.nextLine());
        System.out.println("Tu alimento tiene marca? (true/false) \n >");
        boolean foo = Boolean.parseBoolean(scanner.nextLine());
        if(foo == true){
            System.out.println("------------------------");
            System.out.println("tu alimento tiene marca");
            System.out.println("cual es el id de la marca de tu alimento");
            registro.setMARCA_ID(Integer.parseInt(scanner.nextLine()));
        }else if(foo ==false){
            System.out.println("------------------------");
            System.out.println("tu alimento no tiene marca");
            registro.setMARCA_ID(1);
        }
        
        if(IngredienteDAO.create(registro)>0){
            System.out.println("El alimento fue creado");
        }else{
            System.out.println("Hubo un error al crear el alimento");
        }
        
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del alimento a actualizar");
        Ingrediente alimento = IngredienteDAO.find(Integer.parseInt(scanner.nextLine()));
        System.out.println("----------------------");
        System.out.println("info del actual alimento que deseas cambiar");
        System.out.println("id:" + alimento.getID_INGREDIENTE());
        System.out.println("nombre:" + alimento.getNOMBRE());
        System.out.println("id marca del alimento:"+ alimento.getMARCA_ID());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.nombre del alimento");
        System.out.println("2.marca del alimento");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(alimento != null){
            switch(opcion){
                case 1:
                    System.out.println("indica el nuevo nombre del alimento");
                    scanner.nextLine(); // Eat enter
                    alimento.setNOMBRE(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("indica el id de la  nueva marca del alimento");
                    alimento.setMARCA_ID(Integer.parseInt(scanner.nextLine()));
                    break;
                default:
                    break;
            }

            if(IngredienteDAO.update(alimento)>0){
                System.out.println("el alimento fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el alimento");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    public static void delete(){
        System.out.println("indica el ID del alimento a borrar \n >");
        if(IngredienteDAO.delete(Integer.parseInt(scanner.nextLine()))>0){
            System.out.println("El alimento fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
    
    
}

*/