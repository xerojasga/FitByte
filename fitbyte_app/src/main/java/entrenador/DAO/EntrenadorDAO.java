/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import entrenador.models.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author developer
 */
public class EntrenadorDAO {
    public static final String SELECT_ALL_SQL = "SELECT * FROM ENTRENADOR";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `USUARIO_ID` = ?";
    public static final String CREATE_SQL = 
            "INSERT INTO `ENTRENADOR` (`USUARIO_ID`,`VERIFICADO`,`CALIFICACION`) VALUES (?,?,?)";
    public static final String UPDATE_SQL = 
            "UPDATE `ENTRENADOR` SET `USUARIO_ID` = ? , `VERIFICADO` = ? , `CALIFICACION` = ? WHERE `ID_ENTRENADOR` = ? ";
    public static final String DELETE_SQL = 
            "DELETE FROM `ENTRENADOR` WHERE `ID_ENTRENADOR` = ?";       
    private static final Connection connection = ConnectionProvider.connection;
    
    
    public static Entrenador find(int id_usuario){        
        Entrenador entrenador = new Entrenador();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_usuario);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        entrenador = new Entrenador(
                                resultset.getInt("ID_ENTRENADOR"),
                                resultset.getInt("USUARIO_ID"),
                                resultset.getBoolean("VERIFICADO"),
                                resultset.getInt("CALIFICACION")
                        );                
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return entrenador;
      }
    
    public static ArrayList<Entrenador> findAll(){ 
        ArrayList<Entrenador> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Entrenador entrenador;
                        entrenador = new Entrenador(
                                resultset.getInt("ID_ENTRENADOR"),
                                resultset.getInt("USUARIO_ID"),
                                resultset.getBoolean("VERIFICADO"),
                                resultset.getInt("CALIFICACION")
                        );
                        data.add(entrenador);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los entrenadores");
            System.out.println(e);
        }
        return data;
    }
    
    
    public static int create(Entrenador entrenador){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setInt(1, entrenador.getUsuario_id()); 
            statement.setBoolean(2, entrenador.isVerificacion());    
            statement.setInt(3, entrenador.getCalificacion()); 
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    
    public static int update(Entrenador entrenador){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setInt(1, entrenador.getUsuario_id()); 
                statement.setBoolean(2, entrenador.isVerificacion());    
                statement.setInt(3, entrenador.getCalificacion());
                statement.setInt(4, entrenador.getId_entrenador());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }

    public static int delete(int id_entrenador){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_entrenador);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

    
}
