/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tepcurso03
 */
public class GeneralBaseDeDatos {
    public static Connection con = null;
    public static Connection setConexion(){
        String url = "jdbc:h2:tcp://localhost/~/test";
        
        try {
            con = DriverManager.getConnection(url, "sa", "");
            System.out.println("Conexion abierta con exito");
        } catch (SQLException ex) {
            Logger.getLogger(GeneralBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
     public static void registrarDriver(){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneralBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
       public static void closeConexion(){
        try {
            con.close();
            System.out.println("Conexión cerrada con exito...");
        } catch (SQLException ex) {
            Logger.getLogger(GeneralBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
       
              public static void closeConexion(Connection con){
        try {
            con.close();
            System.out.println("Conexión cerrada con exito...");
        } catch (SQLException ex) {
            Logger.getLogger(GeneralBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
