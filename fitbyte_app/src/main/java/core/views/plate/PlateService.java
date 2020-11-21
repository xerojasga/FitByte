/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views.plate;

import core.DAO.PlateDAO;
import core.models.Plate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */


/*private int plateID;
    private String plateName;
    private String plateDescription;
    private String plateRecipee;
    private boolean platePublic;

    public int getPlateID(){return plateID;}
     public String getPlateName(){return plateName;}
     public String getPlateDescription(){return plateDescription;}
     public String getPlateRecipee(){return plateRecipee;}
     public boolean getPlatePublic(){return platePublic;}
    */

public class PlateService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del plato a mostrar (0 para todos los platos) \n >");
        int plateID = scanner.nextInt();
        if(plateID != 0){
            scanner.nextLine(); // Eat enter
            Plate plate = PlateDAO.find(plateID);
            if(plate != null){                
                System.out.println("ID Plato: "+ plate.getPlateID());
                System.out.println("Nombre Plato: "+ plate.getPlateName());
                System.out.println("Descripcion Plato : "+ plate.getPlateDescription());
                System.out.println("Receta Plato : "+ plate.getPlateRecipee());
                System.out.println("¿Plato publico? : "+ plate.getPlatePublic());
                        
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Plate> data = PlateDAO.findAll();
            for(Plate i : data){
                System.out.println("ID Plato"+ i.getPlateID());
                System.out.println("Nombre Plato: "+ i.getPlateName());
                System.out.println("Descripcion Plato : "+ i.getPlateDescription());
                System.out.println("Receta Plato : "+ i.getPlateRecipee());
                System.out.println("¿Plato publico? : "+ i.getPlatePublic());
            }
        }
    }
    
   



    public static void create(){
        Plate registro = new Plate();
        System.out.println("------------------------");
        System.out.println("Escribe la ID de tu plato");
        registro.setPlateID(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------");
        scanner.nextLine();
        System.out.println("Escribe el nombre de tu plato");
        registro.setPlateName(scanner.nextLine());
        System.out.println("------------------------");
        System.out.println("Escribe la descripcion tu plato");
        registro.setPlateDescription(scanner.nextLine());
         System.out.println("------------------------");
        System.out.println("Escribe la receta de tu plato");
        registro.setPlateRecipee(scanner.nextLine());
         System.out.println("------------------------");
        System.out.println("¿Quieres que tu plato sea observado por todos (True o False)?");
        registro.setPlatePublic(scanner.nextBoolean());
        
        
        if(PlateDAO.create(registro)>0){
            System.out.println("El plato fue añadido");
        }else{
            System.out.println("Hubo un error al añadir el plato");
        }
        
    }
    
     /*public void setPlateID(plateID){this.plateID=plateID;}
     public void setPlateName(plateName){this.plateName=plateName;}
     public void setPlateDescription(plateDescription){this.plateDescription=plateDescription;}
     public void setPlateRecipee(plateRecipee){this.plateRecipee=plateRecipee;}
     public void setPlatePublic(platePublic){this.platePublic=platePublic;}*/

    public static void update(){
        int opcion;
        System.out.println("indica el id del plato a actualizar");
        Plate plate = PlateDAO.find(Integer.parseInt(scanner.nextLine()));
        
        System.out.println("----------------------");
        System.out.println("info del actual plato que deseas cambiar");
        System.out.println("id:" + plate.getPlateID());
        System.out.println("Nombre plato:" + plate.getPlateName());
        System.out.println("Descripcion Plato:"+ plate.getPlateDescription());
        System.out.println("Receta Plato:"+ plate.getPlateRecipee());
        System.out.println("Estado Public Plato:"+ plate.getPlatePublic());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.Nombre Plato");
        System.out.println("2.Descripcion Plato");
        System.out.println("3.Receta Plato");
        System.out.println("4.Cambiar Estado Publico Plato");
        opcion = Integer.parseInt(scanner.nextLine());
       
        System.out.println("----------------------");
        if(plate != null){
            switch(opcion){
                
                case 1:
                    System.out.println("indica el nuevo nombre de plato");
                    plate.setPlateName(scanner.nextLine());
                   
                    break;
                case 2:
                    System.out.println("indica la nueva descripcion del plato");
                    plate.setPlateDescription(scanner.nextLine());
                    
                    break;
                case 3:
                    System.out.println("indica la nueva receta del plato");
                    plate.setPlateRecipee(scanner.nextLine());
                    
                    break;
                case 4:
                    System.out.println("indica el nuevo estado publico de plato");
                    plate.setPlatePublic(scanner.nextBoolean());
                    
                    break;
                default:
                    break;
            }

            if(PlateDAO.update(plate)>0){
                System.out.println("el plato fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el plato");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del plato a borrar \n >");
        if(PlateDAO.delete(Integer.parseInt(scanner.nextLine()))>0){
            System.out.println("El ingrediente de plato fue eliminado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
       
    }
    
    
}