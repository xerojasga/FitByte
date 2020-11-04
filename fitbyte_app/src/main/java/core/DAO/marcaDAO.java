/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.marca;
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
 * Based On Xamir's implementation for Alimento.Java
 * Version 1.1 of the class
 * For changes please refer to GitHub Documentation
 */
public class marcaDAO {
    
    public static final String SELECT_ALL_SQL = 
            "SELECT ID_MARCA, NOMBRE,PAIS_ID FROM marca";
    public static final String SELECT_SQL = 
            SELECT_ALL_SQL + " WHERE ID_MARCA = ?";
    public static final String CREATE_SQL =
            "INSERT INTO marca (ID_MARCA,NOMBRE,PAIS_ID) VALUES (?,?,?)";
    public static final String UPDATE_SQL =
            "UPDATE marca SET NOMBRE = ? ,PAIS_ID = ?  WHERE ID_MARCA = ?";
    public static final String DELETE_SQL =
            "DELETE FROM marca WHERE ID_MARCA = ?";       
    private static final Connection connection = ConnectionProvider.connection;


    public static int create(marca marca){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setInt(1, marca.getID_MARCA());
            statement.setString(2,marca.getNOMBRE());
            statement.setInt(3,marca.getPAIS_ID());
            statement.executeUpdate();
            System.out.println("marca creada");
             return statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
             return  -1;
        }
    }
    
    public static marca find(int id_marca){
        marca marca = new marca();
         try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
             statement.setInt(1, id_marca);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                     if(resultset.next()){
                         marca = new marca(
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
         return marca;
    }
    
    public static ArrayList<marca> findAll(){ 
        ArrayList<marca> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        marca  marca;
                       marca = new marca(
                             resultset.getInt("ID_MARCA"),
                             resultset.getString("NOMBRE"),
                             resultset.getInt("PAIS_ID"));
                        data.add(marca);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("No se pudieron traer los paises");
            System.out.println(e);
        }
        return data;
    }
    
    public static int delete(int id_marca){
         try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1,id_marca);
             return statement.executeUpdate();           
        }catch(SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
    
    public static int update(marca marca){
           try(PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)){
               statement.setString(1,marca.getNOMBRE());
               statement.setInt(2, marca.getPAIS_ID());
               return statement.executeUpdate();
           } catch (SQLException ex) {
               System.out.println(ex);
              return -1;
        }
    }


}
