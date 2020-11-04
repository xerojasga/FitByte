/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fitbyte_app;

import java.util.Scanner;
import user.service.UsuarioService;
/**
 *
 * @author developer
 * Version 1
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void showMenu(){
            System.out.println("-----------------------------------");
            System.out.println(" 1. crear usuario");
            System.out.println(" 2. buscador");
            System.out.println(" 3. borrar un usuario");
            System.out.println(" 4. actualizar un usuario ");
            System.out.println(" 5. salir ");
            System.out.println("-----------------------------------");
            System.out.print("> ");
    }
    public static void processOption(String option){
            switch (option){
                case "1":
                    UsuarioService.create();
                    break;
                case "2":
                    UsuarioService.find();
                    break;
                case "3":
                    UsuarioService.delete();
                    break;
                case "4":
                    UsuarioService.update();
                    break;
                default:
                    break;
            }
    }
    public static void main(String[] args) {
        System.out.println(" FitByte");
        ConnectionProvider conexion = new ConnectionProvider();
        Scanner sc = new Scanner(System.in);
        String option;
        do{                
            showMenu();
            //leemos la opcion del usuario
            option = scanner.nextLine();
            processOption(option);                    
        }while(!"5".equals(option));
    }
    
}
