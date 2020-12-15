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
import core.models.Favorite;
import java.sql.Date;
/**
 *
 * @author Diego
 */
public class FavoriteDAO {
    //id_favorito, fecha, tipo, usuario_id, ingrediente_id, plato_id, ejercicio_id
    public static final String SELECT_ALL_SQL = "SELECT * FROM FAVORITO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_FAVORITO = ?";
    public static final String CREATE_SQL = "INSERT INTO consumo (FECHA,TIPO,USUARIO_ID,INGREDIENTE_ID,PLATO_ID,EJERCICIO_ID) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE consumo SET FECHA = ? ,TIPO=? ,USUARIO_ID = ?,INGREDIENTE_ID = ?,PLATO_ID = ? ,EJERCICIO_ID = ? WHERE ID_FAVORITO = ?";
    public static final String DELETE_SQL = "DELETE FROM FAVORITO WHERE ID_FAVORITO = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Favorite find(int id_favorito){        
        Favorite favorito = new Favorite();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_favorito);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        favorito = new Favorite(
                            resultset.getInt("ID_FAVORITO"),
                            resultset.getDate("FECHA"),
                            resultset.getString("TIPO"),
                            resultset.getInt("USUARIO_ID"),
                            resultset.getInt("INGREDIENTE_ID"),
                            resultset.getInt("PLATO_ID"),
                            resultset.getInt("EJERCICIO_ID")
                        );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return favorito;
      }
    
    public static ArrayList<Favorite> findAll(){ 
        ArrayList<Favorite> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Favorite favorito;
                        favorito = new Favorite(
                            resultSet.getInt("ID_FAVORITO"),
                            resultSet.getDate("FECHA"),
                            resultSet.getString("TIPO"),
                            resultSet.getInt("USUARIO_ID"),
                            resultSet.getInt("INGREDIENTE_ID"),
                            resultSet.getInt("PLATO_ID"),
                            resultSet.getInt("EJERCICIO_ID")
                        );
                        data.add(favorito);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("no se pudieron traer los Favoritos");
            System.out.println(e);
        }
        return data;
    }
    
    public static int create(Favorite favorito){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
         
            stmnt.setDate(1, favorito.getDate());
          stmnt.setString(2, favorito.getType());
          stmnt.setInt(3, favorito.getUser_id());
          stmnt.setInt(4, favorito.getIngredient_id());
          stmnt.setInt(5, favorito.getPlate_id());
          stmnt.setInt(6, favorito.getExercise_id());
          
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Favorite favorito){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setDate(1, favorito.getDate());
            statement.setString(2, favorito.getType());
            statement.setInt(3, favorito.getUser_id());
            statement.setInt(4, favorito.getIngredient_id());
            statement.setInt(5, favorito.getPlate_id());
            statement.setInt(6, favorito.getExercise_id());
            return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int id_favorito){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, id_favorito);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }
}
