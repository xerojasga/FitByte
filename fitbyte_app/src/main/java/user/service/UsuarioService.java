/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.service;

import auth.models.Hash;
import java.util.ArrayList;
import java.util.Scanner;
import user.DAO.UsuarioDAO;
import user.models.Usuario;

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
            Usuario usuario = UsuarioDAO.find(id_usuario);
            if(usuario != null){                
                System.out.println("------------------------------------------");
                System.out.println("ID usuario:"+ usuario.getId_usuario());
                System.out.println("Nombre de usuario: "+ usuario.getUsername() );
                System.out.println("Nombre : "+ usuario.getNombre());
                System.out.println("Apellido : " + usuario.getApellido());
                System.out.println("Email : " + usuario.getEmail());
                System.out.println("Pais id : " + usuario.getPais_id());
                System.out.println("Altura : " + usuario.getAltura());
                System.out.println("Peso : " + usuario.getPeso());
                System.out.println("Edad : " + usuario.getEdad());
                System.out.println("Admin :" + usuario.isAdmin());
                System.out.println("Password :" + usuario.getPassword());
                System.out.println("Descripcion :" + usuario.getDescripcion());
                
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Usuario> data = UsuarioDAO.findAll();
            for(Usuario usuario : data){
                System.out.println("------------------------------------------");
                System.out.println("ID usuario:"+ usuario.getId_usuario());
                System.out.println("Nombre de usuario: "+ usuario.getUsername() );
                System.out.println("Nombre : "+ usuario.getNombre());
                System.out.println("Apellido : " + usuario.getApellido());
                System.out.println("Email : " + usuario.getEmail());
                System.out.println("Pais id : " + usuario.getPais_id());
                System.out.println("Altura : " + usuario.getAltura());
                System.out.println("Peso : " + usuario.getPeso());
                System.out.println("Edad : " + usuario.getEdad());
                System.out.println("Admin :" + usuario.isAdmin());
                System.out.println("Password :" + usuario.getPassword());
                System.out.println("Descripcion :" + usuario.getDescripcion());
            }
        }
    }
    
    public static void create(){
        Usuario usuario = new Usuario();
        System.out.println("------------------------");
        System.out.println("Escribe el username:");
        usuario.setUsername(scanner.nextLine());
        System.out.println("Escribe el nombre:");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Escribe el apellido:");
        usuario.setApellido(scanner.nextLine());
        System.out.println("Escribe el email:");
        usuario.setEmail(scanner.nextLine());
        System.out.println("Escribe el id del pais del usuario");
        usuario.setPais_id(scanner.nextInt());
        System.out.println("Escribe la altura del usuario");
        usuario.setAltura(scanner.nextInt());
        System.out.println("Escribe el peso del usuario");
        usuario.setPeso(scanner.nextInt());
        System.out.println("Escribe la edad del usuario");
        usuario.setEdad(scanner.nextInt());
        System.out.println("Eres admin? (true/false)");
        usuario.setAdmin(scanner.nextBoolean());
        System.out.println("Escribe el password:");
        scanner.nextLine();
        usuario.setPassword(Hash.sha1(scanner.nextLine()));
        System.out.println("Escribe la descripción del usuario:");
        usuario.setDescripcion(scanner.nextLine());
        
        if(UsuarioDAO.create(usuario)>0){
            System.out.println("El "+ ENTITY +" fue creado");
        }else{
            System.out.println("Hubo un error al crear el "+ ENTITY +" ");
        }
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del alimento a actualizar");
        Usuario usuario = UsuarioDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual alimento que deseas cambiar");
        System.out.println("ID usuario:"+ usuario.getId_usuario());
        System.out.println("Nombre de usuario: "+ usuario.getUsername() );
        System.out.println("Nombre : "+ usuario.getNombre());
        System.out.println("Apellido : " + usuario.getApellido());
        System.out.println("Email : " + usuario.getEmail());
        System.out.println("Pais id : " + usuario.getPais_id());
        System.out.println("Altura : " + usuario.getAltura());
        System.out.println("Peso : " + usuario.getPeso());
        System.out.println("Edad : " + usuario.getEdad());
        System.out.println("Admin :" + usuario.isAdmin());
        System.out.println("Password :" + usuario.getPassword());
        System.out.println("Descripcion :" + usuario.getDescripcion());
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
                    usuario.setPeso(scanner.nextInt());
                    break;
                default:
                    break;
            }
            
            if(UsuarioDAO.update(usuario)>0){
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
        if(UsuarioDAO.delete(scanner.nextInt())>0){
            System.out.println("El usuario fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }

}
