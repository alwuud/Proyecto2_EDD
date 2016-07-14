/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Cola;

import Structures.List.Nodo1;

/**
 *
 * @author danielherrerahernandez
 */
public class Cola <T>{
    private Nodo1 cabeza;
      int tamano;
      
      
      
    public Cola(){
        tamano=0;
    }
    
    public boolean isEmpty() {
        if (getCabeza() == null) {
            return true;
        }
        return false;
    }
    
    
    public void push(T objeto) {
        Nodo1 nuevo = new Nodo1(objeto);
        if (isEmpty()) {
            setCabeza(nuevo);
        } else {
            
            Nodo1 actual = this.getCabeza();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamano++;
    }

    public T pop() {
        
        Nodo1 retorno = this.getCabeza();
        
        if(retorno==null){
            return null;
        }
        
        this.setCabeza(retorno.getSiguiente());
        tamano--;
        return (T) retorno.getObjeto();
        
    }
    
    
    
    
    public T obtenerIndice(int indice) {

        if (isEmpty() || indice < 0 || indice>= tamano) {
            return null;
        } else {
            Nodo1 actual = cabeza;
            int i = 0;

            for (i = 0; indice > i && actual.getSiguiente() != null; i++) {

                actual = actual.getSiguiente();

            }

            return (T) actual.getObjeto();

        }

    }

    public boolean eliminar(int indice) {
        if (isEmpty()|| indice<0 || indice>=tamano) {
            return false;

        } else {
            
            if (indice == 0) {
                cabeza= cabeza.getSiguiente();
                
            }else{
                indice--;
                Nodo1 actual = cabeza;
                int i ;

                for (i = 0; indice > i && actual.getSiguiente() != null; i++) {
                    
                    actual = actual.getSiguiente();

                }
                
               
                if(actual.getSiguiente()==null){
                    return false;
                            
                }else{
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                }
                
                
            }
            tamano--;
            return true;
            
                

        }
        
        
    }
    /**
     * @return the cabeza
     */
    public Nodo1 getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(Nodo1 cabeza) {
        this.cabeza = cabeza;
    }
}