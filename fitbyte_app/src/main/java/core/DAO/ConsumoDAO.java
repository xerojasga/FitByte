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
import core.models.Consumo;
/**
 *
 * @author Diego
 */

public class ConsumoDAO {
    //id_consumo, fecha, rec_entrenador, usuario_id, ingrediente_id, plato_id, ejercicio_id, num_horas_ejerc, rec_dia_semana
    public static final String SELECT_ALL_SQL = "SELECT * FROM consumo";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE id_consumo = ?";
    public static final String CREATE_SQL = "INSERT INTO consumo (fecha, rec_entrenador, usuario_id, ingrediente_id, plato_id, ejercicio_id, num_horas_ejerc, rec_dia_semana) VALUES (?,?,?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE consumo SET fecha = ? , rec_entrenador = ? , usuario_id = ?, ingrediente_id = ?, plato_id = ? , ejercicio_id = ? , num_horas_ejerc = ? , rec_dia_semana = ? WHERE id_consumo = ?";
    public static final String DELETE_SQL = "DELETE FROM consumo WHERE id_consumo = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Consumo find(int id_consumo){        
        Consumo consumo = new Consumo();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_consumo);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        consumo = new Consumo(
                            resultset.getInt("id_consumo"),
                            resultset.getString("fecha"),
                            resultset.getBoolean("rec_entenador"),
                            resultset.getInt("usuario_id"),
                            resultset.getInt("ingrediente_id"),
                            resultset.getInt("plato_id"),
                            resultset.getInt("ejercicio_id"),
                            resultset.getInt("num_horas_ejerc"),
                            resultset.getString("rec_dia_semana")
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
    
    public static ArrayList<Consumo> findAll(){ 
        ArrayList<Consumo> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Consumo consumo;
                        consumo = new Consumo(
                            resultSet.getInt("id_consumo"),
                            resultSet.getString("fecha"),
                            resultSet.getBoolean("rec_entenador"),
                            resultSet.getInt("usuario_id"),
                            resultSet.getInt("ingrediente_id"),
                            resultSet.getInt("plato_id"),
                            resultSet.getInt("ejercicio_id"),
                            resultSet.getInt("num_horas_ejerc"),
                            resultSet.getString("rec_dia_semana")
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
    
    public static int create(Consumo consumo){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setString(1, consumo.getFecha());
          stmnt.setBoolean(2, consumo.isRec_entrenador());
          stmnt.setInt(3, consumo.getUsuario_id());
          stmnt.setInt(4, consumo.getIngrediente_id());
          stmnt.setInt(5, consumo.getEjercicio_id());
          stmnt.setInt(6, consumo.getNum_horas_ejerc());
          stmnt.setString(7, consumo.getRec_dia_semana());
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Consumo consumo){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, consumo.getFecha());
            statement.setBoolean(2, consumo.isRec_entrenador());
            statement.setInt(3, consumo.getUsuario_id());
            statement.setInt(4, consumo.getIngrediente_id());
            statement.setInt(5, consumo.getEjercicio_id());
            statement.setInt(6, consumo.getNum_horas_ejerc());
            statement.setString(7, consumo.getRec_dia_semana());
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
