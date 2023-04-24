package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo0a {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("org.sqlite.JDBC");
//            String mysqlURL = "jdbc:sqlite:C:\\sqlite\\chinook.db";
            String mysqlURL = "jdbc:sqlite:chinook.db";
            Connection conexion = DriverManager.getConnection(mysqlURL);
            
            Statement myStatement = conexion.createStatement();
            ResultSet result = myStatement.executeQuery("SELECT * FROM Artists");
            
            int id;
            String nombre;
            while(result.next()){
                id = result.getInt("ArtistID");
                nombre = result.getString("Name");
                System.out.println("Artista " + id + " -- Nombre: " + nombre);
            }

            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex);
        }
        
        
    }
    
}
