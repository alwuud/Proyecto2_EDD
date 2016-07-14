/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Structures.AVL.nodoAvl;
import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Venta implements Serializable {
    
    private int factura;
    private double total;
    private String fecha;
    private nodoAvl usuario;
    
    
    public Venta(){}
    public Venta(int factura, String fecha, nodoAvl usuario){
        this.factura=factura;
        this.fecha= fecha;
        
        this.usuario= usuario;
        
    }
   

    /**
     * @return the factura
     */
    public int getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(int factura) {
        this.factura = factura;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    public int  getClave(){
        return this.factura;
    }
    
    
   
    
}
