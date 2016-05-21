/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controladores.Etiqueta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tepcurso03
 */
public class ServiciosEtiquetas {
    
    public static  boolean  inserEtiqueta(Etiqueta eti){
        boolean ok =false;
        long id=-1;
         Connection con = null;        
        try {
            
            String query = "insert into etiqueta set etiqueta=?";
            con = GeneralBaseDeDatos.setConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            con.setAutoCommit(false);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, eti.getEtiqueta());
            
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
            if(ok){
                //se inserto buscar el id
               Etiqueta  nueva= getEtiqueta(eti.getEtiqueta(), con);
               eti.setId(nueva.getId());
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    
    public static List<Etiqueta> getAllEtiquetas() {
        List<Etiqueta> lista = new ArrayList<>();
        Connection con = null;        
        try {
            
            String query = "select id,etiqueta from etiqueta";
            con = GeneralBaseDeDatos.setConexion() ;
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Etiqueta e = new Etiqueta();
                e.setId(rs.getLong("id"));
                e.setEtiqueta(rs.getString("etiqueta"));
                lista.add(e);
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        }
        
        return lista;
    }
    
    
    
    public static Etiqueta getEtiqueta (String etiqueta ) {
     Etiqueta respueta= new Etiqueta();
           Connection con = null;  
        try {
             con = GeneralBaseDeDatos.setConexion() ;
            String query = "select id,etiqueta from etiqueta where etiqueta=? limit 1";
           
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, etiqueta);
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()){
                respueta.setId(rs.getLong("id"));
                respueta.setEtiqueta(rs.getString("etiqueta"));
                break;
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        } finally{
            GeneralBaseDeDatos.closeConexion(con);
        }
        
        return respueta;
    }
    
    
        public static Etiqueta getEtiqueta (String etiqueta,Connection con ) {
     Etiqueta respueta= new Etiqueta();
            
        try {
             con = GeneralBaseDeDatos.setConexion() ;
            String query = "select id,etiqueta from etiqueta where etiqueta=? limit 1";
           
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, etiqueta);
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()){
                respueta.setId(rs.getLong("id"));
                respueta.setEtiqueta(rs.getString("etiqueta"));
                break;
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        } 
        
        return respueta;
    }
}
