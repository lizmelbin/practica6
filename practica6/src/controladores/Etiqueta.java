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

    private long id;
    private String etiqueta;

    public Etiqueta(String etiqueta) {

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

}
