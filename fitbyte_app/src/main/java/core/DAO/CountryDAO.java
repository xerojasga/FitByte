/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
@author Brayan Portela
 * Version 2.0 of the class
 * For changes please refer to GitHub Documentation
 */
public class CountryDAO {
    //Query Initializations
    public static final String SELECT_ALL_SQL =
            "SELECT * FROM `PAIS`  ";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE `ID_PAIS` = ?";
    public static final String SELECT_SQL_NAME = 
            SELECT_ALL_SQL + " WHERE `NOMBRE` = ?";
    public static final String CREATE_SQL = 
            "INSERT INTO PAIS (NOMBRE) VALUES (?)";
    public static final String UPDATE_SQL =
            "UPDATE PAIS SET NOMBRE = ?  WHERE ID_PAIS = ?";
    public static final String DELETE_SQL = 
            "DELETE FROM PAIS WHERE ID_PAIS = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    //cambio del metodo create 11/11/20
    //Data Access Object Methods
    public static int create(Country country_D){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) { 
          statement.setString(1, country_D.getName());
          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static Country find(int countryID){        
        Country country_D = new Country();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
            statement.setInt(1,countryID);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           country_D=new Country(
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
        return country_D;
    }
    
    public static Country find(String name){        
        Country country_D = new Country();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)){
            statement.setString(1,name);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           country_D=new Country(
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
        return country_D;
    }
    
    public static ArrayList<Country> findAll(){ 
        ArrayList<Country> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Country pais;
                        pais = new Country(
                           resultset.getInt("ID_PAIS"), 
                           resultset.getString("NOMBRE")
                        );
                        data.add(pais);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Unable to bring the countries");
            System.out.println(e);
        }
        return data;
    }
     
    public static int update(Country country_D){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, country_D.getName());
                statement.setInt(2, country_D.getId_country());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int countryID){
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, countryID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
}