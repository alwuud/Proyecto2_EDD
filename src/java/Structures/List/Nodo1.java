/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.List;

/**
 *
 * @author danielherrerahernandez
 */
public  class Nodo1  {
    
    private  Object objeto;
    
    private Nodo1 siguiente;
    
    
    public Nodo1(Object objeto){
        this.objeto= objeto;
        
    }

    
    public  Object getObjeto() {
        return this.objeto;
    }
    
    public void setSiguiente(Nodo1 siguiente){
        this.siguiente= siguiente;
        
    }
    
    public Nodo1 getSiguiente(){
        return siguiente;
        
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    
    
}
