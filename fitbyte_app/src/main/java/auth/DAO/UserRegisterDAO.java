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
public class UserRegisterDAO {
    public static final String SELECT_ALL_SQL = "SELECT * FROM USUARIO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE `USERNAME` = ?";
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
}
