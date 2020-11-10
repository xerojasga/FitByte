/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Resena;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class ResenaDAO {
        
    public static final String SELECT_ALL_SQL = "SELECT  * FROM resena";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_RESENA = ?";
    public static final String CREATE_SQL = "INSERT INTO ingrediente (USUARIO_ID, ENTRENADOR_ID, CONTENIDO) VALUES (?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE ingrediente SET USUARIO_ID = ? , ENTRENADOR_ID = ?, CONTENIDO = ? WHERE ID_RESENA = ?";
    public static final String DELETE_SQL = "DELETE FROM  WHERE ID_RESENA = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Resena find(int id_resena){        
        Resena resena = new Resena();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_resena);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        resena = new Resena(
                                resultset.getInt("ID_RESENA"),
                                resultset.getInt("USUARIO_ID"),
                                resultset.getInt("ENTRENADOR_ID"),
                                resultset.getString("CONTENIDO")
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return resena;
      }
    
    public static ArrayList<Resena> findAll(){ 
        ArrayList<Resena> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Resena resena;
                        resena = new Resena(
                                resultSet.getInt("ID_INGREDIENTE"),
                                resultSet.getInt("USUARIO_ID"),
                                resultSet.getInt("ENTRENADOR_ID"),
                                resultSet.getString("CONTENIDO")
                        );
                        data.add(resena);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer las resenas");
            System.out.println(e);
        }
        return data;
    }
    
    public static int create(Resena resena){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setInt(1,resena.getUsuario_id());
          stmnt.setInt(2, resena.getEntrenador_id()); 
          stmnt.setString(1,resena.getContenido());
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Resena resena){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setInt(1, resena.getUsuario_id());
                statement.setInt(2, resena.getEntrenador_id());
                statement.setString(3, resena.getContenido());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_resena){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_resena);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
}
