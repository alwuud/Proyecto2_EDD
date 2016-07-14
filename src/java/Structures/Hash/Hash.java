/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Hash;

import Bussiness.Producto;

/**
 *
 * @author danielherrerahernandez
 */
public class Hash {
    
    
    private Producto producto;
    private boolean empty;
    
    
    public Hash(){
        empty=true;
        
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * @param empty the empty to set
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    
    
    
    
    
    
}
