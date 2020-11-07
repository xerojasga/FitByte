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
import core.models.Favorito;
/**
 *
 * @author Diego
 */
public class FavoritoDAO {
    //id_favorito, fecha, tipo, usuario_id, ingrediente_id, plato_id, ejercicio_id
    public static final String SELECT_ALL_SQL = "SELECT * FROM favorito";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE id_favorito = ?";
    public static final String CREATE_SQL = "INSERT INTO consumo (fecha, tipo, usuario_id, ingrediente_id, plato_id, ejercicio_id) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE consumo SET fecha = ? , red_entrenador = ? , usuario_id = ?, ingrediente_id = ?, plato_id = ? , ejercicio_id = ? WHERE id_favorito = ?";
    public static final String DELETE_SQL = "DELETE FROM favorito WHERE id_favorito = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Favorito find(int id_favorito){        
        Favorito favorito = new Favorito();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id_favorito);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        favorito = new Favorito(
                            resultset.getInt("id_favorito"),
                            resultset.getString("fecha"),
                            resultset.getString("tipor"),
                            resultset.getInt("usuario_id"),
                            resultset.getInt("ingrediente_id"),
                            resultset.getInt("plato_id"),
                            resultset.getInt("ejercicio_id")
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
    
    public static ArrayList<Favorito> findAll(){ 
        ArrayList<Favorito> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Favorito favorito;
                        favorito = new Favorito(
                            resultSet.getInt("id_favorito"),
                            resultSet.getString("fecha"),
                            resultSet.getString("tipo"),
                            resultSet.getInt("usuario_id"),
                            resultSet.getInt("ingrediente_id"),
                            resultSet.getInt("plato_id"),
                            resultSet.getInt("ejercicio_id")
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
    
    public static int create(Favorito favorito){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setString(1, favorito.getFecha());
          stmnt.setString(2, favorito.getTipo());
          stmnt.setInt(3, favorito.getUsuario_id());
          stmnt.setInt(4, favorito.getIngrediente_id());
          stmnt.setInt(5, favorito.getPlato_id());
          stmnt.setInt(6, favorito.getEjercicio_id());
          
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Favorito favorito){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, favorito.getFecha());
            statement.setString(2, favorito.getTipo());
            statement.setInt(3, favorito.getUsuario_id());
            statement.setInt(4, favorito.getIngrediente_id());
            statement.setInt(5, favorito.getPlato_id());
            statement.setInt(6, favorito.getEjercicio_id());
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
