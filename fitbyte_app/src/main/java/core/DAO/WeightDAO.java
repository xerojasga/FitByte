/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.DAO;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Weight;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeightDAO {
    //Query initializations
    public static final String SELECT_ALL_SQL =
            "SELECT * FROM `PESO`  ";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE `ID_PESO` = ?";
    public static final String CREATE_SQL = 
            "INSERT INTO `peso` (`ID_PESO`, `USUARIO_ID`, `PESO`, `FECHA`) VALUES (NULL, ?, ?, ?)";
    public static final String UPDATE_SQL =
            "UPDATE `PESO` SET `USUARIO_ID`=?,`PESO`=?,`FECHA`=? WHERE `ID_PESO` = ?";
    public static final String DELETE_SQL = 
            "DELETE FROM PESO WHERE ID_PESO = ?"; 
    public static final String SELECT =
            "SELECT `ID_PESO`, `USUARIO_ID`, `PESO`, `FECHA` FROM `peso`";
    public static final String SELECT_BY_ID = 
            "SELECT `ID_PESO`, `PESO`, `FECHA` FROM `peso` WHERE `USUARIO_ID` = ?";
    private static final Connection connection = ConnectionProvider.connection;
    
    public static int create(Weight weight_D){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) { 
          statement.setInt(1, weight_D.getUser_Id());
          statement.setInt(2, weight_D.getWeight());
          statement.setDate(3, (Date) weight_D.getDate());
          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static Weight find(int weightID){        
        Weight weight_D = new Weight();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
            statement.setInt(1,weightID);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           weight_D = new Weight(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("PESO"),
                           resultset.getDate("FECHA"));
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return weight_D;
    }
    
    public static ArrayList<Weight> findAll(){ 
        ArrayList<Weight> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
             if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Weight peso;
                        peso = new Weight(
                           resultset.getInt("ID_PESO"), 
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("PESO"),
                           resultset.getDate("FECHA")
                        );
                        data.add(peso);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Unable to bring the weight");
            System.out.println(e);
        }
        return data;
    }
    
    public static ArrayList<Weight> findAllByID(int user_id){ 
        ArrayList<Weight> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1,user_id);
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Weight peso;
                        peso = new Weight(
                           resultset.getInt("ID_PESO"), 
                           resultset.getInt("PESO"),
                           resultset.getDate("FECHA")
                        );
                        data.add(peso);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Unable to bring the weight");
            System.out.println(e);
        }
        return data;
    }
    
    public static int update(Weight weight_D){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setInt(1, weight_D.getUser_Id());
                statement.setInt(2, weight_D.getWeight());
                statement.setDate(3, (Date) weight_D.getDate());
                statement.setInt(4, weight_D.getId_weight());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    }
    
    public static int delete(int weightID){
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, weightID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}
