package mtpPractica.gestor;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan Federico García
 */

/**
 * TIPOS DE MÉTODOS: 
 * a) getTodasEnfermedades
 * b) getTipoEnfermedad(String nombreEnfermedad)
 * c) IniciarSesion(String dniSelec, String nombreSelec, String sexoSelec, int edadSelec)
 * d) getTiposZombies(String nombreZombie)
 * e) getLetalidad(String nombreArma)
 * @author ppere
 */

public class Gestor {
    String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:zombies.db";

        Statement statement = null;
        Connection conexion = null;
        ResultSet resultados = null;
        
        boolean dniB ;
        boolean nomB ; 
        boolean sexB ;
        boolean edadB;
        
        
     public String getTodosZombies(){
        String stringZombies = "";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
           resultados = statement.executeQuery("SELECT nombre FROM zombie");
           
           while (resultados.next()) {
               stringZombies = stringZombies +";"+ resultados.getString("nombre"); 
                   }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringZombies;
     }
    public String getTodasEnfermedades(){
        String string = "";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
           resultados = statement.executeQuery("SELECT * FROM enferm");
           /*
           System.out.println("TIPO DE ENFERMEDAD            IDENTIFICACIÓN DE CURA\n"
                             + " ====================================================== ");
           */
           while (resultados.next()) {
               string = string + ( resultados.getString("nombre") + " =======>   " + 
                       resultados.getString("id")) + "\n";
                   }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
         
    public String getTipoEnfermedad(String nombreEnfermedad) {
        //Este metodo tiene que devolver un String exclusivamente con la cura de la enfermedad.
        String curaE = "";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
            resultados = statement.executeQuery("SELECT * FROM enferm WHERE nombre == '"+nombreEnfermedad+"' ;");
            
            while (resultados.next()) {
                curaE = resultados.getString("id");
                   }
        } catch (Exception e) {
            e.printStackTrace();   
        }return curaE;
    }
    
     public boolean IniciarSesion(String dniSelec, String nombreSelec, String sexoSelec, int edadSelec) {
           //public boolean IniciarSesion(String dniSelec, String nombreSelec){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();

            resultados = statement.executeQuery("SELECT * FROM persona WHERE dni == '" +dniSelec+ "' AND nombre =='"+nombreSelec+"' AND sexo == '"+sexoSelec+"' AND edad =="+edadSelec+";");
            //resultados = statement.executeQuery("SELECT * FROM persona WHERE dni == '" +dniSelec+ "' AND nombre =='" + nombreSelec +"';");
            //SELECT * FROM persona WHERE dni == dniSelec , nombre == nombreSelec , sexo == '"+sexoSelec+"', edad ==edadSelec;
            while (resultados.next()) {
                dniB = (resultados.getString("dni") == null ? dniSelec == null : resultados.getString("dni").equals(dniSelec));
                nomB = (resultados.getString("nombre") == null ? nombreSelec == null : resultados.getString("nombre").equals(nombreSelec));
                sexB = (resultados.getString("sexo") == null ? sexoSelec == null : resultados.getString("sexo").equals(sexoSelec));
                edadB = resultados.getInt("edad") == edadSelec;                 
             
                   }
        } catch (Exception e) {
            e.printStackTrace();
        } 
            //RETURN:
            //return(dniB == true)&&(nomB==true)&&(sexB==true)&&(edadB==true);
            return(nomB & dniB&sexB &edadB); 
            }   
        
     public String getTiposZombies(String nombreZombie) {
         String resultado = "";
        try {
            Class.forName(driver);
//          conexion = DriverManager.getConnection(url, usuario, clave);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();

            resultados = statement.executeQuery("SELECT * FROM zombie WHERE nombre == '" + nombreZombie + "';");
            
            while (resultados.next()) {
                resultado = (resultados.getString("nombre") + ";" +
                       resultados.getString("tipoAtaque")+ ";" + 
                       resultados.getString("nivelInfeccion") +  ";" +
                       resultados.getString("rapidez"));
                   }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return resultado;
    }
     
     public String getLetalidad(String nombreArma) {
         //A este metodo se le pasa un string q contiene el nombre del arma.
         //Este metodo debe devolver un String EXCLUSIVAMENTE con la letalidad del arma.
         //En caso de no poder encontrar el arma, el metodo devolvera "error".
        String resultado2 = "";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            statement = conexion.createStatement();
            
           resultados = statement.executeQuery("SELECT letalidad FROM arma WHERE nombre == '" + nombreArma + "';");  
            while (resultados.next()) {
                
                resultado2 = resultados.getString("letalidad");
                   }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en la base de datos");
            resultado2 = "error";
        }
        System.out.println(resultado2);
        return resultado2;
    }
    
}