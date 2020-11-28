/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Ingredient;
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

public class IngredientDAO {
    //Query Initializations
    public static final String SELECT_ALL_SQL = 
            "SELECT * FROM INGREDIENTE ";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE ID_INGREDIENTE = ?";
    public static final String SELECT_SQL_NAME = 
            SELECT_ALL_SQL + " WHERE `NOMBRE` = ?";
    public static final String SELECT_ENTIRELY = 
            "SELECT  NOMBRE, MARCA_ID, CALORIAS, CARBOHIDRATOS, PROTEINAS FROM ingrediente WHERE ID_INGREDIENTE = ?";
    public static final String CREATE_SQL = 
            "INSERT INTO ingrediente (NOMBRE,MARCA_ID) VALUES (?,?)";
    public static final String CREATE_ALL_SQL = 
            "INSERT INTO `ingrediente` (NOMBRE, MARCA_ID, CALORIAS, CARBOHIDRATOS, PROTEINAS) VALUES (?,?,?,?,?)";
    public static final String UPDATE_SQL = 
            "UPDATE `ingrediente` SET `NOMBRE` = ?, `MARCA_ID` = ?, `CALORIAS` = ?, `CARBOHIDRATOS` = ?, `PROTEINAS` = ? WHERE ID_INGREDIENTE = ? ";
    public static final String DELETE_SQL = 
            "DELETE FROM ingrediente WHERE ID_INGREDIENTE = ?";    
    public static final String IMAGE_SQL = 
            "UPDATE ingrediente SET IMAGEN = ? WHERE ID_INGREDIENTE = ?;";
    public static final String DISPLAY_SQL = 
            "SELECT IMAGEN FROM ingrediente WHERE ID_INGREDIENTE = ?;";
    public static final String SELECT =
            "SELECT `ID_INGREDIENTE`, `NOMBRE`, `MARCA_ID` FROM `ingrediente`";
    private static final Connection connection = ConnectionProvider.connection;        
    //cambio del metodo create 11/11/20
    //Data Access Object Methods
    public static int create(Ingredient ingredient_D){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setString(1, ingredient_D.getName());
          stmnt.setInt(2, ingredient_D.getBrand_id()); 
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    
    public static int createEntirely(Ingredient ingredient_D){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_ALL_SQL)) {
          statement.setString(1, ingredient_D.getName());
                statement.setInt(2, ingredient_D.getBrand_id());
                statement.setInt(3, ingredient_D.getCalories());
                statement.setInt(4,ingredient_D.getCarbohidrates());
                statement.setInt(5, ingredient_D.getProteins());
          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
   
    public static Ingredient find(int ingredientID){        
        Ingredient ingredient_D = new Ingredient();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, ingredientID);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        ingredient_D = new Ingredient(
                                resultset.getInt("ID_INGREDIENTE"),
                                resultset.getString("NOMBRE"),
                                resultset.getInt("MARCA_ID")
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return ingredient_D;
      }
   
    public static Ingredient findExtra(int ingredientID){        
        Ingredient ingredient_D = new Ingredient();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ENTIRELY)) {
            statement.setInt(1, ingredientID);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        ingredient_D = new Ingredient(
                                resultset.getString("NOMBRE"),
                                resultset.getInt("MARCA_ID"),
                                resultset.getInt("CALORIAS"),
                                resultset.getInt("CARBOHIDRATOS"),
                                resultset.getInt("PROTEINAS")
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return ingredient_D;
      }
        
    public static Ingredient find(String name){        
        Ingredient ingredient_D = new Ingredient();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)){
            statement.setString(1,name);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           ingredient_D = new Ingredient(
                                resultset.getInt("ID_INGREDIENTE"),
                                resultset.getString("NOMBRE"),
                                resultset.getInt("MARCA_ID"));
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return ingredient_D;
    }
    
    public static ArrayList<Ingredient> findAll(){ 
        ArrayList<Ingredient> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Ingredient alimento;
                        alimento = new Ingredient(
                                resultSet.getInt("ID_INGREDIENTE"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getInt("MARCA_ID")
                        );
                        data.add(alimento);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los alimentos");
            System.out.println(e);
        }
        return data;
    }
    
    public static int update(Ingredient ingredient_D){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, ingredient_D.getName());
                statement.setInt(2, ingredient_D.getBrand_id());
                statement.setInt(3, ingredient_D.getCalories());
                statement.setInt(4,ingredient_D.getCarbohidrates());
                statement.setInt(5, ingredient_D.getProteins());
                statement.setInt(6, ingredient_D.getId_ingredient());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int ingredientID){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, ingredientID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}
