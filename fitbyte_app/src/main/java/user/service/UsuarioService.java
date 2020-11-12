/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.service;

import auth.models.Hash;
import java.util.ArrayList;
import java.util.Scanner;
import user.DAO.UserDAO;
import user.models.User;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UsuarioService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ENTITY = "usuario";
    
    public static void find(){
        
        System.out.println("indica el id del "+ ENTITY +" a mostrar (0 oara todos los "+ ENTITY +"s ) \n >");
        int id_usuario = scanner.nextInt();
        if(id_usuario != 0){
            scanner.nextLine(); // Eat enter
            User usuario = UserDAO.find(id_usuario);
            if(usuario != null){                
                System.out.println("------------------------------------------");
                System.out.println("ID usuario:"+ usuario.getId_user());
                System.out.println("Nombre de usuario: "+ usuario.getUsername() );
                System.out.println("Nombre : "+ usuario.getName());
                System.out.println("Apellido : " + usuario.getLast_name());
                System.out.println("Email : " + usuario.getEmail());
                System.out.println("Pais id : " + usuario.getCountry_id());
                System.out.println("Altura : " + usuario.getHeight());
                System.out.println("Peso : " + usuario.getWeight());
                System.out.println("Edad : " + usuario.getAge());
                System.out.println("Admin :" + usuario.isAdmin());
                System.out.println("Password :" + usuario.getPassword());
                System.out.println("Descripcion :" + usuario.getDescription());
                
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<User> data = UserDAO.findAll();
            for(User usuario : data){
                System.out.println("------------------------------------------");
                System.out.println("ID usuario:"+ usuario.getId_user());
                System.out.println("Nombre de usuario: "+ usuario.getUsername() );
                System.out.println("Nombre : "+ usuario.getName());
                System.out.println("Apellido : " + usuario.getLast_name());
                System.out.println("Email : " + usuario.getEmail());
                System.out.println("Pais id : " + usuario.getCountry_id());
                System.out.println("Altura : " + usuario.getHeight());
                System.out.println("Peso : " + usuario.getWeight());
                System.out.println("Edad : " + usuario.getAge());
                System.out.println("Admin :" + usuario.isAdmin());
                System.out.println("Password :" + usuario.getPassword());
                System.out.println("Descripcion :" + usuario.getDescription());
            }
        }
    }
    
    public static void create(){
        User usuario = new User();
        System.out.println("------------------------");
        System.out.println("Escribe el username:");
        usuario.setUsername(scanner.nextLine());
        System.out.println("Escribe el nombre:");
        usuario.setName(scanner.nextLine());
        System.out.println("Escribe el apellido:");
        usuario.setLast_name(scanner.nextLine());
        System.out.println("Escribe el email:");
        usuario.setEmail(scanner.nextLine());
        System.out.println("Escribe el id del pais del usuario");
        usuario.setCountry_id(scanner.nextInt());
        System.out.println("Escribe la altura del usuario");
        usuario.setHeight(scanner.nextInt());
        System.out.println("Escribe el peso del usuario");
        usuario.setWeight(scanner.nextInt());
        System.out.println("Escribe la edad del usuario");
        usuario.setAge(scanner.nextInt());
        System.out.println("Eres admin? (true/false)");
        usuario.setAdmin(scanner.nextBoolean());
        System.out.println("Escribe el password:");
        scanner.nextLine();
        usuario.setPassword(Hash.sha1(scanner.nextLine()));
        System.out.println("Escribe la descripción del usuario:");
        usuario.setDescription(scanner.nextLine());
        
        if(UserDAO.create(usuario)>0){
            System.out.println("El "+ ENTITY +" fue creado");
        }else{
            System.out.println("Hubo un error al crear el "+ ENTITY +" ");
        }
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del alimento a actualizar");
        User usuario = UserDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual alimento que deseas cambiar");
        System.out.println("ID usuario:"+ usuario.getId_user());
        System.out.println("Nombre de usuario: "+ usuario.getUsername() );
        System.out.println("Nombre : "+ usuario.getName());
        System.out.println("Apellido : " + usuario.getLast_name());
        System.out.println("Email : " + usuario.getEmail());
        System.out.println("Pais id : " + usuario.getCountry_id());
        System.out.println("Altura : " + usuario.getHeight());
        System.out.println("Peso : " + usuario.getWeight());
        System.out.println("Edad : " + usuario.getAge());
        System.out.println("Admin :" + usuario.isAdmin());
        System.out.println("Password :" + usuario.getPassword());
        System.out.println("Descripcion :" + usuario.getDescription());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.passoword");
        System.out.println("2.peso");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(usuario != null){
            switch(opcion){
                case 1:
                    System.out.println("Ingresa la nueva contraseña");
                    scanner.nextLine(); // Eat enter
                    usuario.setPassword(Hash.sha1(scanner.nextLine()));
                    break;
                case 2:
                    System.out.println("indica el nuevo peso del usuario");
                    usuario.setWeight(scanner.nextInt());
                    break;
                default:
                    break;
            }
            
            if(UserDAO.update(usuario)>0){
                System.out.println("el usuario fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el usuario");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del usuario a borrar \n >");
        if(UserDAO.delete(scanner.nextInt())>0){
            System.out.println("El usuario fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }

}
