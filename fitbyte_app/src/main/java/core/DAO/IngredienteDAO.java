/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Xamir
 Based On Xamir's implementation for Ingrediente.Java
 Version 1.1 of the class
 For changes please refer to GitHub Documentation
 */

public class IngredienteDAO {
    
    public static final String SELECT_ALL_SQL = "SELECT  NOMBRE, MARCA_ID FROM ingrediente";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_INGREDIENTE = ?";
    public static final String CREATE_SQL = "INSERT INTO ingrediente (ID_INGREDIENTE,INOMBRE,MARCA_ID) VALUES (?,?,?)";
    public static final String UPDATE_SQL = "UPDATE ingrediente SET NOMBRE = ? , MARCA_ID = ? CALORIAS = ? , CARBOHIDRATOS = ? , PROTEINAS = ?  WHERE ID_INGREDIENTE = ?";
    public static final String DELETE_SQL = "DELETE FROM ingrediente WHERE ID_INGREDIENTE = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Ingrediente find(int id_alimento){        
        Ingrediente alimento = new Ingrediente();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_alimento);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        alimento = new Ingrediente(
                                resultset.getInt("ID_INGREDIENTE"),
                                resultset.getString("NOMBRE"),
                                resultset.getInt("MARCA_ID"));                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return alimento;
      }
    
    public static ArrayList<Ingrediente> findAll(){ 
        ArrayList<Ingrediente> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Ingrediente alimento;
                        alimento = new Ingrediente(
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
    
    public static int create(Ingrediente alimento){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setInt(1,alimento.getMARCA_ID());
          stmnt.setString(2, alimento.getNOMBRE());
          stmnt.setInt(3, alimento.getMARCA_ID()); 
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Ingrediente alimento){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, alimento.getNOMBRE());
                statement.setInt(2, alimento.getMARCA_ID());
                statement.setInt(3, alimento.getCALORIAS());
                statement.setInt(4,alimento.getCARBOHIDRATOS());
                statement.setInt(5, alimento.getPROTEINAS());
                statement.setInt(6, alimento.getID_INGREDIENTE());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_alimento){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_alimento);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}
