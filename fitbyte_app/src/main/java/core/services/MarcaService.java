/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package core.services;

import core.DAO.MarcaDAO;
import core.models.Marca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 * 
 * @author Brayan
 * Based On Xamir's implementation for AlimentoService.Java
 * Version 1.0 of the class
 * For changes please refer to GitHub Documentation

public class MarcaService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    
     public static void find(){
        System.out.println("indica el id de la marca a mostrar  \n >");
        int id_marca = scanner.nextInt();
        if(id_marca != 0){
           Marca marca = MarcaDAO.find(id_marca);
            if(marca != null){                
                System.out.println("ID marca: "+ marca.getID_MARCA() );
                System.out.println("nombre marca : "+marca.getNOMBRE());
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }
    }
     
     public static void findAll(){
         System.out.println("Esta es la lista de paises registrados");
          ArrayList<Marca> data = MarcaDAO.findAll();
          for(Marca i : data){
               System.out.println("ID marca: "+ i.getID_MARCA());
                System.out.println("nombre marca : "+ i.getNOMBRE());
                System.out.println("Pais marca"+i.getPAIS_ID());
          }
     }
    
      public static void create(){
        Marca registro = new Marca();
        System.out.println("------------------------");
        System.out.println("Escribe el codigo de la marca:");
        registro.setID_MARCA(Integer.parseInt(scanner.nextLine()));
        System.out.println("");
        System.out.println("Escribe el nombre de la marca:");
        registro.setNOMBRE(scanner.nextLine());
        System.out.println("Escribe  el ID del pais  de la marca:");
        registro.setPAIS_ID(Integer.parseInt(scanner.nextLine()));
        if(MarcaDAO.create(registro)>0){
            System.out.println("La marca fue añadida");
        }else{
            System.out.println("Hubo un error al añadir la marca");
        }
        
    } 
      
      public static void update(){
        int opcion;
        System.out.println("indica el id de la marca a actualizar");
        Marca marca= new Marca(Integer.parseInt(scanner.nextLine()));
        System.out.println("----------------------");
        System.out.println("info de la actual marca que deseas cambiar");
        System.out.println("id:" + marca.getID_MARCA());
        System.out.println("nombre:" + marca.getID_MARCA());
        System.out.println("pais:" + marca.getID_MARCA());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.nombre de la marca");
        System.out.println("2.pais de la marca");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(marca != null){
            switch(opcion){
                case 1:
                    System.out.println("indica el nuevo nombre de la marca");
                    scanner.nextLine(); // Eat enter
                   marca.setNOMBRE(scanner.nextLine());
                    break;
                 case 2:
                    System.out.println("indica el nuevo nombre del pais de la marca");
                    scanner.nextLine(); // Eat enter
                   marca.setPAIS_ID(Integer.parseInt(scanner.nextLine()));
                    break;
                default:
                    break;
            }

            if(MarcaDAO.update(marca)>0){
                System.out.println("la marca fue actualizada");        
            }else{
                System.out.println("hubo un error al actualizar la marca");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
      
      public static void delete(){
        System.out.println("indica el ID de la marca a borrar \n >");
        if(MarcaDAO.delete(Integer.parseInt(scanner.nextLine()))>0){
            System.out.println("La marca fue borrada");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
      }

}

*/