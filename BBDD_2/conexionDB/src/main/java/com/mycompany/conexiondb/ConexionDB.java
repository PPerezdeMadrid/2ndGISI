/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.conexiondb;

import java.sql.*;

/**
 *
 * @author ppere
 */
public class ConexionDB {

    public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/sakila"; // URL de la base de datos
    String usuario = "root"; // Usuario de la base de datos
    String password = "root"; // Contraseña de la base de datos
    Connection conexion;
    Statement statement;

   
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            //Crear Usuario
             String sql = "CREATE USER 'guillermo'@'localhost' IDENTIFIED BY '1234';";
            statement.executeUpdate(sql);
            
            //Darle permisos solo de SELECT
             String sql1 = "GRANT SELECT ON sakila.* TO 'guillermo'@'localhost';";
             String sql2 = "FLUSH PRIVILEGES;";
             statement.executeUpdate(sql1);
             statement.executeUpdate(sql2);
             
            statement.close();
            conexion.close();


        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
