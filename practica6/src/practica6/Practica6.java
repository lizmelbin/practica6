/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import controladores.Etiqueta;
import freemarker.template.Configuration;
import java.util.List;
import servicios.GeneralBaseDeDatos;
import spark.Spark;
import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author tepcurso03
 */
public class Practica6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     System.out.println("Ejemplo de BootStrap Spark");
        
         //Indicando la carpeta por defecto.
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Practica6.class, "/recursos/");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        GeneralBaseDeDatos.registrarDriver();
   //     Spark.port(8080);
         get("/hello", (req, res) -> {
            System.out.println("Entrando a la ruta....");

            //Etiqueta e= new Etiqueta("Java");
             List <Etiqueta> e= servicios.ServiciosEtiquetas.getAllEtiquetas();
             String respuesta="hola";
             for (Etiqueta temp: e) {
                 respuesta+="</br> Id: "+temp.getId()+" ---->Etiqueta: "+temp.getEtiqueta();
             }
            
            return respuesta;
        });
         
        
         
         /**inseertar etiquetas listo 
          *Url De prueba
          * localhost:4567/insertarEtiqueta?etiqueta=Java
          */
          
          get("/insertarEtiqueta", (req, res) -> {
            System.out.println("Insertando Etiqueta....");

            
            String etiqueta=req.queryParams("etiqueta");
            String respuesta="";
            if(servicios.ServiciosEtiquetas.getEtiqueta(etiqueta).getEtiqueta()!=null){
                respuesta="Esta etiqueta ya existe";
            }else{
            Etiqueta nueva= new Etiqueta(etiqueta);
            
            respuesta=nueva.getEtiqueta()==null?"La Etiqueta no pudo ser agregada":"La etiqueta "+
                    nueva.getEtiqueta()+" Fue agregada correctamente el id de la misma es: "+nueva.getId();
            }
            return respuesta;
        });
         
         
         
         
    }
    
}
