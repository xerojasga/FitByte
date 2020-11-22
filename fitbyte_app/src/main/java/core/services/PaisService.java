/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
package core.services;


import core.DAO.PaisDAO;
import core.models.Pais;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

 * 
 * @author Brayan
 * Based On Xamir's implementation for AlimentoService.Java
 * Version 1.0 of the class
 * For changes please refer to GitHub Documentation

public class PaisService {
     public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public static void find(){
        System.out.println("indica el id del pais a mostrar  \n >");
        int id_pais = Integer.parseInt(scanner.nextLine());
        if(id_pais != 0){
            Pais pais = PaisDAO.find(id_pais);
            if(pais != null){
                System.out.println("ID pais: "+ pais.getID_PAIS() );
                System.out.println("nombre pais : "+ pais.getNOMBRE());
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }
    }
    
    public static void findAll(){
         System.out.println("Esta es la lista de paises registrados");
          ArrayList<Pais> data = PaisDAO.findAll();
          for(Pais i : data){
               System.out.println("ID pais: "+ i.getID_PAIS());
                System.out.println("nombre pais : "+ i.getNOMBRE());
          }
     }
    
   public static void create() {
        Pais registro = new Pais();
        System.out.println("------------------------");
        System.out.println("Escribe el codigo del pais:");
        registro.setID_PAIS(Integer.parseInt(scanner.nextLine()));
        System.out.println("Escribe el nombre del pais:");
        registro.setNOMBRE(scanner.nextLine());
        if(PaisDAO.create(registro)>0){
            System.out.println("El pais fue añadido");
        }else{
            System.out.println("Hubo un error al añadir el pais");
        }
        
    } 
   
    public static void update(){
        int opcion;
        System.out.println("indica el id del pais actualizar");
        Pais pais= new Pais(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual pais que deseas cambiar");
        System.out.println("id:" + pais.getID_PAIS());
        System.out.println("nombre:" + pais.getNOMBRE());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.nombre del pais");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(pais != null){
            switch(opcion){
                case 1:
                    System.out.println("indica el nuevo nombre del pais");
                    scanner.nextLine(); // Eat enter
                    pais.setNOMBRE(scanner.nextLine());
                    break;
                default:
                    break;
            }

            if(PaisDAO.update(pais)>0){
                System.out.println("el pais fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el pais");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    public static void delete(){
        System.out.println("indica el ID del pais a borrar \n >");
        if(PaisDAO.delete(scanner.nextInt())>0){
            System.out.println("El pais fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
    
}

*/