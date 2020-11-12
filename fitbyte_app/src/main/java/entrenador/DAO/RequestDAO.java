/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrenador.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Pais;
import entrenador.models.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RequestDAO {
    
    public static final String SELECT_ALL_SQL = "SELECT * FROM `SOLICITUD`  ";
    public static final String SELECT_SQL_ENTRENADOR = SELECT_ALL_SQL + " WHERE `U_ENTRENADOR_ID` = ?";
    public static final String SELECT_SQL_USUARIO = SELECT_ALL_SQL + " WHERE `USUARIO_ID` = ?";
    public static final String CREATE_SQL = "INSERT INTO SOLICITUD (USUARIO_ID,U_ENTRENADOR_ID,ACEPTADA) VALUES (?,?,?)";
    public static final String UPDATE_SQL = "UPDATE SOLICITUD SET USUARIO_ID = ?, U_ENTRENADOR_ID = ?, ACEPTADA= ? WHERE U_ENTRENADOR_ID = ?";
    public static final String DELETE_SQL = "DELETE FROM SOLICITUD WHERE ID_SOLICITUD = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static ArrayList<Request> findCoach(int id_coach){        
        ArrayList<Request> requests = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_ENTRENADOR)){
            statement.setInt(1,id_coach);
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Request request;
                        request = new Request(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("U_ENTRENADOR_ID`"),
                           resultset.getBoolean("ACEPTADA")
                        );
                        requests.add(request);
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return requests;
    }
    
    public static ArrayList<Request> findUser(int id_user){        
        ArrayList<Request> requests = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_ENTRENADOR)){
            statement.setInt(1,id_user);
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Request request;
                        request = new Request(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("U_ENTRENADOR_ID`"),
                           resultset.getBoolean("ACEPTADA")
                        );
                        requests.add(request);
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return requests;
    }
        
    public static ArrayList<Request> findAll(){ 
        ArrayList<Request> requests = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
             
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Request request;
                        request = new Request(
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("U_ENTRENADOR_ID`"),
                           resultset.getBoolean("ACEPTADA")
                        );
                        requests.add(request);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("No se pudieron traer las solicitudes");
            System.out.println(e);
        }
        return requests;
    }
    
    public static int create(Request request){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setInt(1,request.getUser_id());
            statement.setInt(2,request.getCoach_id());
            statement.setBoolean(3, request.isAccepted());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    //pendiente
    
     public static int update(Request request){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setInt(1,request.getUser_id());
            statement.setInt(2,request.getCoach_id());
            statement.setBoolean(3, request.isAccepted());
            statement.setInt(4, request.getCoach_id());
            return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
     public static int delete(int id_request){
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_request);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
            
}
