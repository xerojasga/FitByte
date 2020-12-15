/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Request;
import core.models.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author developer
 */
public class RequestDAO {
    
     /*ID_SOLICITUD        ,
       USUARIO_ID       ,
        ENTRENADOR_ID       ,
          TIPO_SOLICITUD        */
    
    public static final String SELECT_ALL_SQL = "SELECT * FROM SOLICITUD  ";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_SOLICITUD=?";   
    public static final String SELECT_SQL_RECEIVED = SELECT_ALL_SQL + " WHERE ENTRENADOR_ID = ? AND TIPO_SOLICITUD = ?";
    
    public static final String CREATE_SQL = "INSERT INTO SOLICITUD (ID_SOLICITUD,USUARIO_ID, ENTRENADOR_ID,TIPO_SOLICITUD) VALUES (?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE SOLICITUD SET  ID_SOLICITUD=? ,USUARIO_ID = ?, ENTRENADOR_ID = ?, TIPO_SOLICITUD= ? WHERE ID_SOLICITUD = ?";
    public static final String DELETE_SQL = "DELETE FROM SOLICITUD WHERE ID_SOLICITUD = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static ArrayList<Request> find_all_received(int id_receiver, String type){        
        
        ArrayList<Request> requests = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_RECEIVED)){
            statement.setInt(1,id_receiver);
            statement.setString(2,type);            
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Request request;
                        request = new Request(
                           resultset.getInt("ID_SOLICITUD"),
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getString("TIPO_SOLICITUD")
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
                          resultset.getInt("ID_SOLICITUD"),
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getString("TIPO_SOLICITUD")
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
    
    public static Request find (int user_id,int coach_id, String type){        
        Request request = new Request();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL)){
            statement.setInt(1,user_id);
            statement.setInt(2,coach_id);
            statement.setString(3,type);
            /*statement.setInt(4,10);*/
             if(statement.execute()){
                 try (ResultSet resultset = statement.getResultSet()) {
                    if(resultset.next()){
                        request = new Request(
                           resultset.getInt("ID_SOLICITUD"),
                           resultset.getInt("USUARIO_ID"),
                           resultset.getInt("ENTRENADOR_ID"),
                           resultset.getString("TIPO_SOLICITUD")
                        );       
                    }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return request;
    }
    
    public static int create(Request request){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            
            statement.setInt(1,request.getId_request());
            statement.setInt(2,request.getUser_sender_id());
            statement.setInt(3,request.getUser_receiver_id());
            statement.setString(4, request.getType());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            return  -1;
        }    
    }

    
     public static int update(Request request){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setInt(1,request.getUser_sender_id());
            statement.setInt(2,request.getUser_receiver_id());
            statement.setString(3, request.getType());
            
            statement.setInt(4, request.getUser_receiver_id());
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
