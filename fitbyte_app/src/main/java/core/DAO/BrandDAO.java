/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Xamir
 * @Modified_by : Brayan
 * Version 2.0 of the class
 * For changes please refer to GitHub Documentation
 */
public class BrandDAO {
    //Query Initializations
    public static final String SELECT_ALL_SQL = 
            "SELECT ID_MARCA, NOMBRE,PAIS_ID FROM marca";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE ID_MARCA = ?";
    public static final String SELECT_SQL_NAME = 
            SELECT_ALL_SQL + " WHERE `NOMBRE` = ?";
    public static final String CREATE_SQL =
            "INSERT INTO marca (NOMBRE,PAIS_ID) VALUES (?,?)";
    public static final String UPDATE_SQL =
            "UPDATE marca SET NOMBRE = ? ,PAIS_ID = ?  WHERE ID_MARCA = ?";
    public static final String DELETE_SQL =
            "DELETE FROM marca WHERE ID_MARCA = ?";       
    private static final Connection connection = ConnectionProvider.connection;
    //cambio del metodo create 11/11/20
    //Data Access Object Methods
    public static int create(Brand brand_D){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setString(1,brand_D.getName());
            statement.setInt(2,brand_D.getCountry_id());
            statement.executeUpdate();
            System.out.println("Brand Created");
             return statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
             return  -1;
        }
    }
    
    public static Brand find(int brandID){
        Brand brand_D = new Brand();
         try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
             statement.setInt(1, brandID);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                     if(resultset.next()){
                         brand_D = new Brand(
                             resultset.getInt("ID_MARCA"),
                             resultset.getString("NOMBRE"),
                             resultset.getInt("PAIS_ID"));
                     }
                 }catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
         }catch(SQLException ex){
             System.out.println(ex);
         }
         return brand_D;
    }
    
    public static Brand find(String name){        
        Brand brand_D = new Brand();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)){
            statement.setString(1,name);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           brand_D = new Brand(
                             resultset.getInt("ID_MARCA"),
                             resultset.getString("NOMBRE"),
                             resultset.getInt("PAIS_ID"));
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return brand_D;
    }
    
    public static ArrayList<Brand> findAll(){ 
        ArrayList<Brand> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Brand  marca;
                       marca = new Brand(
                             resultset.getInt("ID_MARCA"),
                             resultset.getString("NOMBRE"),
                             resultset.getInt("PAIS_ID"));
                        data.add(marca);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Unable to bring the brands");
            System.out.println(e);
        }
        return data;
    }
    
    public static int update(Brand brand_D){
           try(PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)){
               statement.setString(1,brand_D.getName());
               statement.setInt(2, brand_D.getCountry_id());
               statement.setInt(3,brand_D.getId_brand());
               return statement.executeUpdate();
           } catch (SQLException ex) {
               System.out.println(ex);
              return -1;
        }
    }
    
    public static int delete(int brandID){
         try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1,brandID);
             return statement.executeUpdate();           
        }catch(SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
}
