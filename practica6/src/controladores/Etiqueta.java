/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author tepcurso03
 */
public class Etiqueta {

  //test para ver si se sube a git
    private long id;
    private String etiqueta;

    public Etiqueta(String etiqueta) {
        if(!verificarSiSePuedeInsertar(etiqueta)){
            
        }
        this.etiqueta = etiqueta;
        servicios.ServiciosEtiquetas.inserEtiqueta(this);

    }

    public Etiqueta() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Verifica en la BD si ya existe una etiqeuta con este label
     * @param etiqueta1
     * @return 
     */
    private boolean verificarSiSePuedeInsertar(String etiqueta1) {
        Etiqueta e=servicios.ServiciosEtiquetas.getEtiqueta(etiqueta);
        return e.getEtiqueta()!=null;
    }

}
