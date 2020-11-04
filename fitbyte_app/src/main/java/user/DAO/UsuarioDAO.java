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
import user.models.Usuario;

/**
 * 
 * @author developer
 */
public class UsuarioDAO {
    public static final String SELECT_ALL_SQL = "SELECT * FROM USUARIO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `ID_USUARIO` = ?";
    public static final String SELECT_SQL_NAME = SELECT_ALL_SQL + " WHERE `USERNAME` = ?";
    public static final String CREATE_SQL = 
            "INSERT INTO `USUARIO`(`USERNAME`, `NOMBRE`, `APELLIDO`, `EMAIL`, `PAIS_ID`, `ALTURA`, `PESO`, `EDAD`, `ADMIN`, `PASSWORD`, `DESCRIPCION`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = 
            "UPDATE `USUARIO` SET `USERNAME`= ?,`NOMBRE`= ?,`APELLIDO`= ?,`EMAIL`= ?,`PAIS_ID`= ?,`ALTURA`= ? ,`PESO`= ?,`EDAD`= ?,`ADMIN`= ?, `PASSWORD`=?, `DESCRIPCION`= ? WHERE `USUARIO`.`ID_USUARIO` = ? ";
    public static final String DELETE_SQL = 
            "DELETE FROM `USUARIO` WHERE `ID_USUARIO` = ?";
    
    private static final Connection connection = ConnectionProvider.connection;   
    
    public static Usuario find(int id_usuario){        
        Usuario usuario = new Usuario();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_usuario);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        usuario = new Usuario(
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
    public static Usuario find(String nombre_usuario){        
        Usuario usuario = new Usuario();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)) {
            statement.setString(1, nombre_usuario);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        usuario = new Usuario(
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
    
    public static ArrayList<Usuario> findAll(){ 
        ArrayList<Usuario> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultset = statement.getResultSet()) {
                    while(resultset.next()){
                        Usuario usuario;
                        usuario = new Usuario(
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
    
    public static int create(Usuario usuario){
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
          statement.setString( 1, usuario.getUsername());
          statement.setString( 2, usuario.getNombre());
          statement.setString( 3, usuario.getApellido());
          statement.setString( 4, usuario.getEmail());
          statement.setInt( 5, usuario.getPais_id());
          statement.setInt( 6, usuario.getAltura());
          statement.setInt( 7, usuario.getPeso());
          statement.setInt( 8, usuario.getEdad());
          statement.setBoolean( 9, usuario.isAdmin());
          statement.setString( 10, usuario.getPassword());
          statement.setString( 11, usuario.getDescripcion());

          return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }

    public static int update(Usuario usuario){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
          statement.setString( 1, usuario.getUsername());
          statement.setString( 2, usuario.getNombre());
          statement.setString( 3, usuario.getApellido());
          statement.setString( 4, usuario.getEmail());
          statement.setInt( 5, usuario.getPais_id());
          statement.setInt( 6, usuario.getAltura());
          statement.setInt( 7, usuario.getPeso());
          statement.setInt( 8, usuario.getEdad());
          statement.setBoolean( 9, usuario.isAdmin());
          statement.setString( 10, usuario.getPassword());
          statement.setString( 11, usuario.getDescripcion());
          statement.setInt( 12, usuario.getId_usuario());
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
