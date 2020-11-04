/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
@author Brayan Portela
 * Version 1.0 of the class
 * For changes please refer to GitHub Documentation
 */
public class PaisDAO {
    
    public static final String SELECT_ALL_SQL = "SELECT * FROM `PAIS`  ";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `ID_PAIS` = ?";
    public static final String SELECT_SQL_NAME = SELECT_ALL_SQL + " WHERE `NOMBRE` = ?";
    public static final String CREATE_SQL = "INSERT INTO PAIS (ID_PAIS,NOMBRE) VALUES (?,?)";
    public static final String UPDATE_SQL = "UPDATE PAIS SET NOMBRE = ?  WHERE ID_PAIS = ?";
    public static final String DELETE_SQL = "DELETE FROM PAIS WHERE ID_PAIS = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Pais find(int id_pais){        
        Pais pais = new Pais();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
            statement.setInt(1,id_pais);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           pais=new Pais(
                           resultset.getInt("ID_PAIS"),
                           resultset.getString("NOMBRE"));
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return pais;
    }
    
    public static Pais find(String nombre){        
        Pais pais = new Pais();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)){
            statement.setString(1,nombre);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           pais=new Pais(
                           resultset.getInt("ID_PAIS"),
                           resultset.getString("NOMBRE"));
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return pais;
    }
    
    public static ArrayList<Pais> findAll(){ 
        ArrayList<Pais> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Pais pais;
                        pais = new Pais(
                           resultset.getInt("ID_PAIS"), 
                           resultset.getString("NOMBRE")
                        );
                        data.add(pais);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("No se pudieron traer los paises");
            System.out.println(e);
        }
        return data;
    }
    
     public static int create(Pais pais){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
          statement.setInt(1,pais.getID_PAIS()); 
          statement.setString(2, pais.getNOMBRE());
          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
     
     public static int update(Pais pais){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, pais.getNOMBRE());
                statement.setInt(2, pais.getID_PAIS());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
     public static int delete(int id_pais){
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_pais);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
}