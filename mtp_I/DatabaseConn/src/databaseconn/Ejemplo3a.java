/*
 * Ejemplo para meter, de forma automática, un ResultSet en un JTable
 * En la base de datos se supone que hay una base de datos llamada prueba y que
 * tiene una tabla persona con tres campos, de esta manera:
 * mysql> create database prueba;
 * mysql> use prueba;
 * mysql> create table persona (id smallint auto_increment, nombre varchar(60), 
 *      nacimiento date, primary key(id)); 
 */ 
package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Ejemplo3a {
    private TablaDeDatos tabla;         /** Clase encargada de construir y visualizar la ventana */
    private DefaultTableModel modelo;   /** Clase donde se guardan los datos leidos de base de datos */
    String driver = "org.sqlite.JDBC";
//    String url = "jdbc:sqlite:prueba.db";
    String url = "jdbc:sqlite:chinook.db";
//    String driver = "com.mysql.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/amigos";
//    String usuario = "mtp";
//    String clave = "mtpPass";
    

    Statement statement = null;
    Connection conexion = null;
    ResultSet resultado = null;

    public Ejemplo3a()
    {
        try {
            Class.forName(driver);
//            conexion = DriverManager.getConnection(url, usuario, clave);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
//            resultado = statement.executeQuery("SELECT * FROM usuarios");
//            resultado = statement.executeQuery("SELECT * FROM tracks");
            resultado = statement.executeQuery("SELECT trackid, tracks.name, albums.Title AS album, media_types.Name AS media, genres.Name AS genres FROM tracks INNER JOIN albums ON Albums.AlbumId = tracks.AlbumId INNER JOIN media_types ON media_types.MediaTypeId = tracks.MediaTypeId INNER JOIN genres ON genres.GenreId = tracks.GenreId");

            modelo = new DefaultTableModel();
            ConversorResultSetADefaultTableModel.rellena(resultado, modelo);
            tabla = new TablaDeDatos();

            tabla.creaYMuestraVentana();
            tabla.tomaDatos(modelo);
            
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

    public static void main(String[] args)
    {
        Ejemplo3a app = new Ejemplo3a();
    }
}
