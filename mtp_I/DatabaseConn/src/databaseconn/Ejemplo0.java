package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo0 {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/basedatos";
            Connection conexion = DriverManager.getConnection(mysqlURL, "usuario", "pass");
            
            Statement myStatement = conexion.createStatement();
            ResultSet result = myStatement.executeQuery("SELECT * FROM Clientes");
            
            int id;
            String nombre;
            while(result.next()){
                id = result.getInt("Id");
                nombre = result.getString("Nombre");
                System.out.println("Cliente " + id + " -- Nombre: " + nombre);
            }

            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex);
        }
        
        
    }
    
}
