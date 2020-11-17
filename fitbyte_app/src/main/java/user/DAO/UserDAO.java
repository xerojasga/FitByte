/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import user.models.User;

/**
 * 
 * @author developer
 */
public class UserDAO {
    public static final String SELECT_ALL_SQL = "SELECT * FROM USUARIO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `ID_USUARIO` = ?";
    public static final String SELECT_SQL_NAME = SELECT_ALL_SQL + " WHERE `USERNAME` = ?";
    public static final String SELECT_ALL_SQL_NAME = SELECT_ALL_SQL + " WHERE `USERNAME` LIKE ?";
    public static final String SELECT_ALL_ENTRENADOR_SQL_NAME = "SELECT * FROM `USUARIO` JOIN `ENTRENADOR` ON `USUARIO`.`ID_USUARIO` = `ENTRENADOR`.`USUARIO_ID` WHERE `USUARIO`.`USERNAME` LIKE ? ";
    public static final String CREATE_SQL = 
            "INSERT INTO `USUARIO`(`USERNAME`, `NOMBRE`, `APELLIDO`, `EMAIL`, `PAIS_ID`, `ALTURA`, `PESO`, `EDAD`, `ADMIN`, `PASSWORD`, `DESCRIPCION`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = 
            "UPDATE `USUARIO` SET `USERNAME`= ?,`NOMBRE`= ?,`APELLIDO`= ?,`EMAIL`= ?,`PAIS_ID`= ?,`ALTURA`= ? ,`PESO`= ?,`EDAD`= ?,`ADMIN`= ?, `PASSWORD`=?, `DESCRIPCION`= ? WHERE `USUARIO`.`ID_USUARIO` = ? ";
    public static final String DELETE_SQL = 
            "DELETE FROM `USUARIO` WHERE `ID_USUARIO` = ?";
    
    private static final Connection connection = ConnectionProvider.connection;   
    
    public static User find(int id_usuario){        
        User usuario = new User();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_usuario);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        usuario = new User(
                                resultset.getInt("ID_USUARIO"),
                                resultset.getString("USUARIO.USERNAME"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("APELLIDO"),
                                resultset.getString("EMAIL"),
                                resultset.getInt("PAIS_ID"),
                                resultset.getInt("ALTURA"),
                                resultset.getInt("PESO"),
                                resultset.getInt("EDAD"),
                                resultset.getBoolean("ADMIN"),
                                resultset.getString("PASSWORD"),
                                resultset.getString("DESCRIPCION")                
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return usuario;
      }
    public static User find(String nombre_usuario){        
        User usuario = new User();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)) {
            statement.setString(1, nombre_usuario);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        usuario = new User(
                                resultset.getInt("ID_USUARIO"),
                                resultset.getString("USERNAME"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("APELLIDO"),
                                resultset.getString("EMAIL"),
                                resultset.getInt("PAIS_ID"),
                                resultset.getInt("ALTURA"),
                                resultset.getInt("PESO"),
                                resultset.getInt("EDAD"),
                                resultset.getBoolean("ADMIN"),
                                resultset.getString("PASSWORD"),
                                resultset.getString("DESCRIPCION")                
                        );                    
                    }else{
                        System.out.println("No hay registros");
                    }           
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return usuario;
      }
    public static ArrayList<User> findAll(String username){
        ArrayList<User> data = new ArrayList<>();
            
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL_NAME)) {
            String query = username + "_%";
            statement.setString(1, query); 
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User usuario;
                        usuario = new User(
                                resultset.getInt("ID_USUARIO"),
                                resultset.getString("USERNAME"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("APELLIDO"),
                                resultset.getString("EMAIL"),
                                resultset.getInt("PAIS_ID"),
                                resultset.getInt("ALTURA"),
                                resultset.getInt("PESO"),
                                resultset.getInt("EDAD"),
                                resultset.getBoolean("ADMIN"),
                                resultset.getString("PASSWORD"),
                                resultset.getString("DESCRIPCION")
                        );
                        data.add(usuario);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los usuarios");
            System.out.println(e);
        }
        return data;
    }
    public static ArrayList<User> findAllCoach(String username){
        ArrayList<User> data = new ArrayList<>();
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ENTRENADOR_SQL_NAME)) {
            String query = username + "_%";
            statement.setString(1, query);
            
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User usuario;
                        usuario = new User(
                                resultset.getInt("ID_USUARIO"),
                                resultset.getString("USERNAME"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("APELLIDO"),
                                resultset.getString("EMAIL"),
                                resultset.getInt("PAIS_ID"),
                                resultset.getInt("ALTURA"),
                                resultset.getInt("PESO"),
                                resultset.getInt("EDAD"),
                                resultset.getBoolean("ADMIN"),
                                resultset.getString("PASSWORD"),
                                resultset.getString("DESCRIPCION")
                        );
                        data.add(usuario);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los usuarios");
            System.out.println(e);
        }
        return data;
    }
    public static ArrayList<User> findAll(){ 
        ArrayList<User> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        User usuario;
                        usuario = new User(
                                resultset.getInt("ID_USUARIO"),
                                resultset.getString("USERNAME"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("APELLIDO"),
                                resultset.getString("EMAIL"),
                                resultset.getInt("PAIS_ID"),
                                resultset.getInt("ALTURA"),
                                resultset.getInt("PESO"),
                                resultset.getInt("EDAD"),
                                resultset.getBoolean("ADMIN"),
                                resultset.getString("PASSWORD"),
                                resultset.getString("DESCRIPCION")
                        );
                        data.add(usuario);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los usuarios");
            System.out.println(e);
        }
        return data;
    }
    
    public static int create(User usuario){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
          statement.setString( 1, usuario.getUsername());
          statement.setString( 2, usuario.getName());
          statement.setString( 3, usuario.getLast_name());
          statement.setString( 4, usuario.getEmail());
          statement.setInt( 5, usuario.getCountry_id());
          statement.setInt( 6, usuario.getHeight());
          statement.setInt( 7, usuario.getWeight());
          statement.setInt( 8, usuario.getAge());
          statement.setBoolean( 9, usuario.isAdmin());
          statement.setString( 10, usuario.getPassword());
          statement.setString( 11, usuario.getDescription());

          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }

    public static int update(User usuario){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
          statement.setString( 1, usuario.getUsername());
          statement.setString( 2, usuario.getName());
          statement.setString( 3, usuario.getLast_name());
          statement.setString( 4, usuario.getEmail());
          statement.setInt( 5, usuario.getCountry_id());
          statement.setInt( 6, usuario.getHeight());
          statement.setInt( 7, usuario.getWeight());
          statement.setInt( 8, usuario.getAge());
          statement.setBoolean( 9, usuario.isAdmin());
          statement.setString( 10, usuario.getPassword());
          statement.setString( 11, usuario.getDescription());
          statement.setInt( 12, usuario.getId_user());
          return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_usuario){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_usuario);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}