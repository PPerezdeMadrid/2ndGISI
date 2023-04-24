package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1a {

    public static void main(String args[]) {
        String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:prueba.db";

//        String usuario = "mtp";
//        String clave = "mtpPass";

        Statement statement = null;
        Connection conexion = null;
        ResultSet resultados = null;

        try {
            Class.forName(driver);
//            conexion = DriverManager.getConnection(url, usuario, clave);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();

            statement.executeUpdate("CREATE TABLE usuarios (nombre VARCHAR(25), login VARCHAR(15), edad INT, nivelParticipacion FLOAT)");

            statement.executeUpdate("INSERT INTO usuarios VALUES('Pepe','pepe',23, 0.64)");
            statement.executeUpdate("INSERT INTO usuarios VALUES('Juan','juan',38, 0.23)");
            statement.executeUpdate("INSERT INTO usuarios VALUES('Antonio','anton',28, 0.82)");
            statement.executeUpdate("INSERT INTO usuarios VALUES('Maria','mar',22, 0.84)");
            statement.executeUpdate("INSERT INTO usuarios VALUES('Natalia','Nati',35, 0.33)");
            statement.executeUpdate("INSERT INTO usuarios VALUES('Paco','paco',42, 0.22)");

            resultados = statement.executeQuery("SELECT NOMBRE FROM usuarios WHERE nivelParticipacion > 0.5");

            while (resultados.next()) {
                System.out.println(resultados.getString("NOMBRE")
                        + " gracias por ser un usuario tan activo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultados != null) {
                    resultados.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
} 
