/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import core.models.Consumption;
/**
 *
 * @author Diego
 * Modified by Brayan
 */

public class ConsumptionDAO {
    //id_consumo, fecha, rec_entrenador, usuario_id, ingrediente_id, plato_id, ejercicio_id, calorias, num_horas_ejerc, rec_dia_semana
    public static final String SELECT_ALL_SQL = "SELECT * FROM CONSUMO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_CONSUMO = ?";
    public static final String SELECT_ID = SELECT_ALL_SQL + " WHERE USUARIO_ID = ?";
    
    public static final String SELECT_USER = "SELECT * FROM CONSUMO WHERE USUARIO_ID = ? ORDER BY `FECHA` DESC LIMIT ?";
    public static final String CREATE_SQL = "INSERT INTO CONSUMO (FECHA, REC_ENTRENADOR, USUARIO_ID, INGREDIENTE_ID, PLATO_ID, EJERCICIO_ID, CALORIAS, NUM_HORAS_EJERC, REC_DIA_SEMANA) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE CONSUMO SET FECHA = ? , REC_ENTRENADOR = ? , USUARIO_ID = ?, INGREDIENTE_ID = ?, PLATO_ID = ? , EJERCICIO_ID = ? , CALORIAS = ?, NUM_HORAS_EJERC = ? , REC_DIA_SEMANA = ? WHERE ID_CONSUMO = ?";
    public static final String DELETE_SQL = "DELETE FROM CONSUMO WHERE id_consumo = ?";         
    public static final String REGISTER = "SELECT * FROM CONSUMO WHERE `FECHA` = (SELECT MAX(`FECHA`) FROM `consumo`) ORDER BY `ID_CONSUMO` DESC LIMIT ?";

    private static final Connection connection = ConnectionProvider.connection;        

    
    public static Consumption find(int id_consumo){        
        Consumption consumo = new Consumption();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_consumo);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        consumo = new Consumption(
                            resultset.getInt("ID_CONSUMO"),
                            resultset.getDate("FECHA"),
                            resultset.getBoolean("REC_ENTRENADOR"),
                            resultset.getInt("USUARIO_ID"),
                            resultset.getInt("INGREDIENTE_ID"),
                            resultset.getInt("PLATO_ID"),
                            resultset.getInt("EJERCICIO_ID"),
                            resultset.getInt("CALORIAS"),
                            resultset.getInt("NUM_HORAS_EJERC"),
                            resultset.getString("REC_DIA_SEMANA")
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return consumo;
      }
    
    public static ArrayList<Consumption> findAll(){ 
        ArrayList<Consumption> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Consumption consumo;
                        consumo = new Consumption(
                            resultSet.getInt("ID_CONSUMO"),
                            resultSet.getDate("FECHA"),
                            resultSet.getBoolean("REC_ENTRENADOR"),
                            resultSet.getInt("USUARIO_ID"),
                            resultSet.getInt("INGREDIENTE_ID"),
                            resultSet.getInt("PLATO_ID"),
                            resultSet.getInt("EJERCICIO_ID"),
                            resultSet.getInt("CALORIAS"),
                            resultSet.getInt("NUM_HORAS_EJERC"),
                            resultSet.getString("REC_DIA_SEMANA")
                        );
                        data.add(consumo);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los consumos");
            System.out.println(e);
        }
        return data;
    }
    
    public static ArrayList<Consumption> findAllID(int user_id){ 
        ArrayList<Consumption> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ID)) {
             statement.setInt(1, user_id);
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Consumption consumo;
                        consumo = new Consumption(
                            resultSet.getInt("ID_CONSUMO"),
                            resultSet.getDate("FECHA"),
                            resultSet.getBoolean("REC_ENTRENADOR"),
                            resultSet.getInt("USUARIO_ID"),
                            resultSet.getInt("INGREDIENTE_ID"),
                            resultSet.getInt("PLATO_ID"),
                            resultSet.getInt("EJERCICIO_ID"),
                            resultSet.getInt("CALORIAS"),
                            resultSet.getInt("NUM_HORAS_EJERC"),
                            resultSet.getString("REC_DIA_SEMANA")
                        );
                        data.add(consumo);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los consumos");
            System.out.println(e);
        }
        return data;
    }
    
    public static ArrayList<Consumption> findAllU(int id_usuario,int n_reg){ 
        ArrayList<Consumption> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_USER)) {
             statement.setInt(1, id_usuario);
             statement.setInt(2, n_reg);
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Consumption consumo;
                        consumo = new Consumption(
                            resultSet.getInt("ID_CONSUMO"),
                            resultSet.getDate("FECHA"),
                            //resultSet.getBoolean("REC_ENTRENADOR"),
                            //resultSet.getInt("usuario_id"),
                            //resultSet.getInt("ingrediente_id"),
                            resultSet.getInt("PLATO_ID"),
                            resultSet.getInt("EJERCICIO_ID"),
                            resultSet.getInt("CALORIAS"),
                            resultSet.getInt("NUM_HORAS_EJERC"),
                            resultSet.getString("REC_DIA_SEMANA")
                        );
                        data.add(consumo);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los consumos");
            System.out.println(e);
        }
        return data;
    }
    
    public static int create(Consumption consumo){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
            if (consumo.getDate() == null){
                stmnt.setNull(1, 0);
            } else {
                stmnt.setDate(1, consumo.getDate());
            }
            stmnt.setBoolean(2, consumo.isRec_coach());
            stmnt.setInt(3, consumo.getUser_id());
            if (consumo.getIngredient_id() == -1){
                stmnt.setNull(4, consumo.getIngredient_id());
            } else {
                stmnt.setInt(4, consumo.getIngredient_id());
            }
            if (consumo.getPlate_id() == -1){
                stmnt.setNull(5, consumo.getPlate_id());
            } else {
                stmnt.setInt(5, consumo.getPlate_id());
            }
            stmnt.setInt(6, consumo.getExercise_id());
            stmnt.setInt(7, consumo.getCalories());
            stmnt.setInt(8, consumo.getNum_hours_excers());
            if (consumo.getRec_day_weak() == null){
                stmnt.setNull(9, 0);
            } else {
                stmnt.setString(9, consumo.getRec_day_weak());
            }
            return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            return  -1;
        }        
    }
    
    public static int update(Consumption consumo){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setDate(1, consumo.getDate());
            statement.setBoolean(2, consumo.isRec_coach());
            statement.setInt(3, consumo.getUser_id());
            statement.setInt(4, consumo.getIngredient_id());
            statement.setInt(5, consumo.getPlate_id());
            statement.setInt(6, consumo.getExercise_id());
            statement.setInt(7, consumo.getCalories());
            statement.setInt(8, consumo.getNum_hours_excers());
            statement.setString(9, consumo.getRec_day_weak());
            return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_consumo){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_consumo);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
}
