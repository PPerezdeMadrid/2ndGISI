package databaseconn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo2a {

    public static void imprimeMetainformacionDeConexion(Connection conexion) {
        try {
            DatabaseMetaData resultSetMetaData = conexion.getMetaData();
            System.out.println(resultSetMetaData.getDatabaseProductName());
            System.out.println(resultSetMetaData.getDatabaseProductVersion());
            System.out.println(resultSetMetaData.getDriverName());
            System.out.println(resultSetMetaData.getDriverVersion());
            System.out.println(resultSetMetaData.getURL());
            System.out.println(resultSetMetaData.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void imprimeMetainformacionDeConsulta(ResultSet resultSet) {
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numeroDeColumnas = resultSetMetaData.getColumnCount();
            StringBuilder stringBuilder = new StringBuilder(300);
            for (int i = 1; i <= numeroDeColumnas; i++) {
                stringBuilder.append("|");
                String nombreDeLaColumna = resultSetMetaData.getColumnName(i);
                String tipoDeLaColumna = resultSetMetaData.getColumnTypeName(i);
                stringBuilder.append(nombreDeLaColumna).append(" (").
                        append(tipoDeLaColumna).append(")");
            }
            stringBuilder.append("\n--------------------------------------------\n");
            while (resultSet.next()) {
                for (int i = 1; i <= numeroDeColumnas; i++) {
                    stringBuilder.append("|").append(resultSet.getString(i)).append("\t");
                }
                stringBuilder.append("\n").append("--------------------------------------------\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/amigos";
//        String usuario = "mtp";
//        String clave = "mtpPass";
        String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:prueba.db";
//        String url = "jdbc:sqlite:chinook.db";

        Statement statement = null;
        Connection conexion = null;
        ResultSet resultado = null;

        try {
            Class.forName(driver);
//            conexion = DriverManager.getConnection(url, usuario, clave);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
            resultado = statement.executeQuery("SELECT * FROM usuarios");
//            resultado = statement.executeQuery("SELECT * FROM artists");
            imprimeMetainformacionDeConexion(conexion);
            imprimeMetainformacionDeConsulta(resultado);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
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