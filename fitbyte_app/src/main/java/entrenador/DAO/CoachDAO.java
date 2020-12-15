/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import entrenador.models.Coach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author developer
 */
public class CoachDAO {
    
    /*  int id_coach; 
    int id_user;
    boolean Verified;
    float Score;
    int Contact_Number;
    */
    public static final String SELECT_ALL_SQL = "SELECT * FROM ENTRENADOR";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_ENTRENADOR = ?";
    
    public static final String CREATE_SQL = "INSERT INTO ENTRENADOR (ID_ENTRENADOR,USUARIO_ID,VERIFICADO,"
            + "NUM_CONTACTO,CALIFICACION)"
            + " VALUES (NULL,?,?,?,?)";
    
    public static final String UPDATE_SQL = "UPDATE ENTRENADOR SET ID_ENTRENADOR=?,USUARIO_ID=?,"
            + "VERIFICADO=?,"
            + "CALIFICACION=?,NUMERO_DE_CONTACTO=?";
    
    public static final String DELETE_SQL = "DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR = ?";       
    
    private static final Connection connection = ConnectionProvider.connection;
    
    
    public static Coach find(int id_user){        
        Coach couch = new Coach();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_user);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        couch = new Coach(
                      /*(`ID_ENTRENADOR`,`USUARIO_ID`,`VERIFICADO`,"
            + "`CALIFICACION`,`NUMERO_DE_CONTACTO`)"*/         
                                
                                resultset.getInt("ID_ENTRENADOR"),
                                resultset.getInt("USUARIO_ID"),
                                resultset.getBoolean("VERIFICADO"),
                                resultset.getFloat("CALIFICACION"),
                                resultset.getLong("NUM_CONTACTO")
                        );                
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return couch;
      }
    
    public static ArrayList<Coach> findAll(){ 
        ArrayList<Coach> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Coach couch;
                        couch = new Coach(
                                 
                                resultset.getInt("ID_ENTRENADOR"),
                                resultset.getInt("USUARIO_ID"),
                                resultset.getBoolean("VERIFICADO"),
                                resultset.getFloat("CALIFICACION"),
                                resultset.getLong("NUM_CONTACTO")
                        );
                        data.add(couch);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los entrenadores");
            System.out.println(e);
        }
        return data;
    }
    
    
    public static int create(Coach couch){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
    /*  public int getId_coach() { return id_coach;}
 public int getId_user() {return id_user;}
public float getScore() {return Score;}
public boolean isVerified() {return Verified;}
public int getContact_Number() {return Contact_Number;}
*/
            //tatement.setInt(, couch.getId_coach()); 
            statement.setInt(1, couch.getId_user());
            statement.setBoolean(2, couch.isVerified());
            statement.setString(4, String.valueOf(couch.getScore()));
            statement.setLong(3, couch.getContact_Number());
            
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    
    public static int update(Coach couch){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                
            
            statement.setInt(1, couch.getId_user());
            statement.setFloat(2, couch.getScore());
            statement.setBoolean(3, couch.isVerified());
            statement.setLong(4, couch.getContact_Number());
            statement.setInt(5, couch.getId_coach()); 
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }

    public static int delete(int id_couch){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_couch);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

    
}
