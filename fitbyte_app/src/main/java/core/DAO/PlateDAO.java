package com.core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import com.core.models.Plate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author youDoNotRecognizeTheBodiesOnTheWater
 */

public class PlateDAO {

	/*private int plateID;
	private String plateName;
	private String plateDescription;
	private String plateRecipee;
	private boolean platePublic;*/
    
    public static final String SELECT_ALL_SQL = "SELECT ID_PLATO, NOMBRE, DESCRIPCION, RECETA, PUBLICO FROM PLATO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_PLATO = ?";
    public static final String CREATE_SQL = "INSERT INTO PLATO (ID_PLATO,NOMBRE, DESCRIPCION, RECETA, PUBLICO) VALUES (?,?,?,?,?)";

    /**
     *
     */
    public static final String UPDATE_SQL = "UPDATE PLATO SET NOMBRE = ? , DESCRIPCION = ?, RECETA = ?, PUBLICO = ? WHERE ID_PLATO = ?";
    public static final String DELETE_SQL = "DELETE FROM PLATO WHERE ID_PLATO = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Plate find(int plateID){        
        Plate plate = new Plate();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, plateID);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        plate = new Plate(
                                resultset.getInt("ID_PLATO"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("DESCRIPCION"),
                                resultset.getString("RECETA"),
                                resultset.getBoolean("PUBLICO")
                                );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return plate;
      }
    
    public static ArrayList<Plate> findAll(){ 
        ArrayList<Plate> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Plate plate;
                        plate = new Plate(
                                resultSet.getInt("ID_PLATO"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getString("RECETA"),
                                resultSet.getBoolean("PUBLICO")
                        );
                        data.add(plate);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Could not bring any plates");
            System.out.println(e);
        }
        return data;
    }
    
    /*private int plateID;
	private String plateName;
	private String plateDescription;
	private String plateRecipee;
	private boolean platePublic;*/
    public static int create(Plate plate){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setInt(1, plate.getPlateID());
          stmnt.setString(2, plate.getPlateName());
          stmnt.setString(3, plate.getPlateDescription());
          stmnt.setString(4, plate.getPlateRecipee());
          stmnt.setBoolean(5, plate.getPlatePublic());
           
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Plate plate){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                
                statement.setString(1, plate.getPlateName());
                statement.setString(2, plate.getPlateDescription());
                statement.setString(3, plate.getPlateRecipee());
                statement.setBoolean(4, plate.getPlatePublic());
                statement.setInt(5, plate.getPlateID());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int plateID){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, plateID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}