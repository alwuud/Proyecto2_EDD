/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Direccion implements Serializable{
    
    public static int idGenerator=0;
    private String direccion;
    private boolean envio, facturacion;
    private int id;
    
    public Direccion(){
        this.id= idGenerator++;
        direccion="";
        envio= false;
        facturacion = false;
        
        
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the envio
     */
    public boolean isEnvio() {
        return envio;
    }

    /**
     * @param envio the envio to set
     */
    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    /**
     * @return the facturacion
     */
    public boolean isFacturacion() {
        return facturacion;
    }

    /**
     * @param facturacion the facturacion to set
     */
    public void setFacturacion(boolean facturacion) {
        this.facturacion = facturacion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
