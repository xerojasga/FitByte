/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auth.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.models.User; 

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */  
public class LoginDAO {
    public static final String SELECT_ALL_SQL = "SELECT * FROM USUARIO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `USERNAME` = ?";
    public static final String PASSWORD = "SELECT `PASSWORD` FROM `usuario` WHERE `ID_USUARIO` = ? AND `EMAIL` = ?";
    
    private static final Connection connection = ConnectionProvider.connection;
    
    public static boolean login(User usuario){
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setString(1, usuario.getUsername());   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        if(usuario.getPassword().equals(resultset.getString("PASSWORD"))){
                            return true;
                        }     
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return false;
    }
    
     public static String Rehearseal(int id,String mail){
        String result = "";
        try (PreparedStatement statement = connection.prepareStatement(PASSWORD)){
            statement.setInt(1, id);
            statement.setString(2, mail);
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        result = resultset.getString("PASSWORD");
                    }
                }catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            } catch (SQLException ex) {
                System.out.println(ex);
        }
        return result;
    }

}
