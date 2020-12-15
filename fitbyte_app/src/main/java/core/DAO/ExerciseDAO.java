package core.DAO;

import com.mycompany.fitbyte_app.ConnectionProvider;
import core.models.Exercise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author youDoNotRecognizeTheBodiesOnTheWater
 */

public class ExerciseDAO {

	/*private int exerciseID;
   private String exerciseDescription;
   private int burntHourCalorieExercise;*/
    
    public static final String SELECT_ALL_SQL = "SELECT * FROM  EJERCICIO";
    public static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE ID_EJERCICIO = ?";
    public static final String SELECT_SQL_NAME =  SELECT_ALL_SQL + " WHERE DESCRIPCION = ?";
    public static final String CREATE_SQL = "INSERT INTO EJERCICIO (ID_EJERCICIO,NOMBRE, DESCRIPCION, CALORIAS_QUEMA_HORA) VALUES (?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE EJERCICIO SET NOMBRE = ?, DESCRIPCION = ?, CALORIAS_QUEMA_HORA = ? WHERE ID_EJERCICIO = ?";
    public static final String DELETE_SQL = "DELETE FROM EJERCICIO WHERE ID_EJERCICIO = ?";       
    private static final Connection connection = ConnectionProvider.connection;        
    
    public static Exercise find(int exerciseID){        
        Exercise exercise = new Exercise();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, exerciseID);   
            if(statement.execute()){
                try(ResultSet resultset = statement.getResultSet()){
                    if(resultset.next()){
                        exercise = new Exercise(
                                resultset.getInt("ID_EJERCICIO"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("DESCRIPCION"),
                                resultset.getInt("CALORIAS_QUEMA_HORA")
                                );                    
                    }            
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return exercise;
      }
    
    
    public static Exercise find(String name){        
        Exercise exercise_D = new Exercise();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_SQL_NAME)){
            statement.setString(1,name);
             if(statement.execute()){
                 try(ResultSet resultset = statement.getResultSet()){
                       if(resultset.next()){
                           exercise_D = new Exercise(
                                resultset.getInt("ID_EJERCICIO"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("DESCRIPCION"),
                                resultset.getInt("CALORIAS_QUEMA_HORA")
                                ); 
                       }
                 } catch(SQLException ex){
                     System.out.println(ex);
                 }
             }
        }catch(SQLException ex){
           System.out.println(ex);
        }
        return exercise_D;
    }
    
    public static ArrayList<Exercise> findAll(){ 
        ArrayList<Exercise> data = new ArrayList<>();
        
         try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while(resultSet.next()){
                        Exercise exercise;
                        exercise = new Exercise(
                                resultSet.getInt("ID_EJERCICIO"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CALORIAS_QUEMA_HORA")
                        );
                        data.add(exercise);
                    }
                }
            }           
        }catch(SQLException e){
            System.out.println("Could not bring any exercises");
            System.out.println(e);
        }
        return data;
    }
    
  
    /*private int exerciseID;
   private String exerciseDescription;
   private int burntHourCalorieExercise;*/

    public static int create(Exercise exercise){
        try (PreparedStatement stmnt = connection.prepareStatement(CREATE_SQL)) {
          stmnt.setInt(1, exercise.getExerciseID());
          stmnt.setString(2, exercise.getExerciseName());
          stmnt.setString(3, exercise.getExerciseDescription());
          stmnt.setInt(4, exercise.getBurntHourCalorieExercise());
           
          return stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
           return  -1;
        }        
    }
    
    public static int update(Exercise exercise){       
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
                statement.setString(1, exercise.getExerciseName());
                statement.setString(2, exercise.getExerciseDescription());
                statement.setInt(3, exercise.getBurntHourCalorieExercise());
                statement.setInt(4, exercise.getExerciseID());
                return statement.executeUpdate();
        }catch(SQLException ex){ 
                System.out.println(ex);
                return -1;
        }   
    
    }
    
    public static int delete(int exerciseID){
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
             statement.setInt(1, exerciseID);
             return statement.executeUpdate();             
        }catch(SQLException e) {
            System.out.println(e);
            return -1;
        }        
    }

}