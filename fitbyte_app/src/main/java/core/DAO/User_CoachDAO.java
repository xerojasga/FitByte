/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.User_Coach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author developer
 */
public class User_CoachDAO {

        
    public static final String SELECT_ALL_SQL = "SELECT * FROM USUARIO_ENTRENADOR";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE USUARIO_ID = ? AND ENTRENADOR_ID = ?";
    public static final String SELECT_SQL_ENTRENADOR = SELECT_ALL_SQL + " WHERE ENTRENADOR_ID = ?";
    public static final String SELECT_SQL_USUARIO = SELECT_ALL_SQL + " WHERE USUARIO_ID = ?";
    public static final String CREATE_SQL = "INSERT INTO USUARIO_ENTRENADOR (USUARIO_ID,ENTRENADOR_ID,ACTIVO) VALUES (?,?,?)";
    public static final String UPDATE_SQL = "UPDATE SOLICITUD SET USUARIO_ID = ?, ENTRENADOR_ID = ?, ACTIVO= ? WHERE USUARIO_ID = ? , ENTRENADOR_ID = ?";
    public static final String DELETE_SQL = "DELETE FROM USUARIO_ENTRENADOR WHERE ID_USUARIO_ENTRENADOR = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
        public static User_Coach find(int id_user, int id_coach){        
        User_Coach user_coach = null;
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
            statement.setInt(1,id_user);
            statement.setInt(2,id_coach);
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    if(resultset.next()){
                        user_coach = new User_Coach(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getBoolean("ACTIVO")
                        );
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return user_coach;
    }
        
    public static ArrayList<User_Coach> find_all_User(int id_user){        
        ArrayList<User_Coach> user_coach_items = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_USUARIO)){
            statement.setInt(1,id_user);
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User_Coach user_coach;
                        user_coach = new User_Coach(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getBoolean("ACTIVO")
                        );
                        user_coach_items.add(user_coach);
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return user_coach_items;
    }
    
    public static ArrayList<User_Coach> find_all_Coach(int id_coach){        
        ArrayList<User_Coach> user_coach_items = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_ENTRENADOR)){
            statement.setInt(1,id_coach);
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User_Coach user_coach;
                        user_coach = new User_Coach(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getBoolean("ACTIVO")
                        );
                        user_coach_items.add(user_coach);
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return user_coach_items;
    }
        
    public static ArrayList<User_Coach> findAll(){ 
        ArrayList<User_Coach> user_coach_items = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
             
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User_Coach user_coach;
                        user_coach = new User_Coach(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getBoolean("ACTIVO")
                        );
                        user_coach_items.add(user_coach);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("No se pudieron traer las solicitudes");
            System.out.println(e);
        }
        return user_coach_items;
    }
    
    public static int create(User_Coach user_coach){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setInt(1,user_coach.getUser_id());
            statement.setInt(2,user_coach.getCouch_id());
            statement.setBoolean(3, user_coach.isActive());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    //pendiente
    
     public static int update(User_Coach user_coach){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            //new data user_coach
            statement.setInt(1,user_coach.getUser_id());
            statement.setInt(2,user_coach.getCouch_id());
            statement.setBoolean(3, user_coach.isActive());
            //specific ids of the relationship
            statement.setInt(4,user_coach.getUser_id());
            statement.setInt(5, user_coach.getCouch_id());
            return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
     public static int delete(int id_user_coach){
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_user_coach);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
