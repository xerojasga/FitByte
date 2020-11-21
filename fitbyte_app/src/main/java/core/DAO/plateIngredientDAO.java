/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.plateIngredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author youDoNotRecognizeTheBodiesOnTheWater
 */

public class plateIngredientDAO {

	/*private int plateIngredientID;
    private int plateID //Foreing
    private int ingredientID; //Foreing, Subject to change*/
    
    public static final String SELECT_ALL_SQL = "SELECT ID_PLATO_INGREDIENTE,PLATO_ID, INGREDIENTE_ID FROM  PLATO_INGREDIENTE";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_PLATO_INGREDIENTE = ?";
    public static final String CREATE_SQL = "INSERT INTO PLATO_INGREDIENTE (ID_PLATO_INGREDIENTE,PLATO_ID, INGREDIENTE_ID) VALUES (?,?,?)";
    public static final String UPDATE_SQL = "UPDATE PLATO_INGREDIENTE SET PLATO_ID = ?,INGREDIENTE_ID = ?  WHERE ID_PLATO_INGREDIENTE = ?";
    public static final String DELETE_SQL = "DELETE FROM PLATO_INGREDIENTE WHERE ID_PLATO_INGREDIENTE = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static plateIngredient find(int plateIngredientID){        
        plateIngredient plateingredient = new plateIngredient();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, plateIngredientID);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        plateingredient = new plateIngredient(
                                resultset.getInt("ID_PLATO_INGREDIENTE"),
                                resultset.getInt("PLATO_ID"),
                                resultset.getInt("INGREDIENTE_ID")
                                );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return plateingredient;
      }
    
    public static ArrayList<plateIngredient> findAll(){ 
        ArrayList<plateIngredient> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        plateIngredient plateingredient;
                        plateingredient = new plateIngredient(
                               resultSet.getInt("ID_PLATO_INGREDIENTE"),
                                resultSet.getInt("PLATO_ID"),
                                resultSet.getInt("INGREDIENTE_ID")
                        );
                        data.add(plateingredient);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Could not bring any plate ingredients");
            System.out.println(e);
        }
        return data;
    }
    
  
    /*private int plateIngredientID;
    private int plateID //Foreing
    private int ingredientID; //Foreing, Subject to change*/

    public static int create(plateIngredient plateingredient){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setInt(1, plateingredient.getPlateIngredientID());
          stmnt.setInt(2, plateingredient.getPlateIngredientPlateID());
          stmnt.setInt(3, plateingredient.getPlateIngredientIngredientID());
           
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(plateIngredient plateingredient){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
               
                statement.setInt(1, plateingredient.getPlateIngredientPlateID());
                statement.setInt(2, plateingredient.getPlateIngredientIngredientID());
                statement.setInt(3, plateingredient.getPlateIngredientID());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int plateIngredientID){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, plateIngredientID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}