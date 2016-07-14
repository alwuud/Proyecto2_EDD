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
public class ListaEnlazada<T> {

    Nodo1 inicio;
    
    int tamano;

    public ListaEnlazada() {

        inicio = null;
        tamano=0;
        
    }
    
    
    public int getTamano(){
        return tamano;
        
    }
    public boolean agregar(T objeto) {
        Nodo1 nuevo;

        nuevo = new Nodo1(objeto);

        if (esVacia()) {
            inicio = nuevo;
            tamano++;
            return true;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            tamano++;
            return true;

        }

    }

    public boolean esVacia() {

        if (inicio == null) {
            return true;
        } else {
            return false;
        }

    }

    public T obtenerIndice(int indice) {

        if (esVacia() || indice < 0 || indice>= tamano) {
            return null;
        } else {
            Nodo1 actual = inicio;
            int i = 0;

            for (i = 0; indice > i && actual.getSiguiente() != null; i++) {

                actual = actual.getSiguiente();

            }

            return (T) actual.getObjeto();

        }

    }

    public boolean eliminar(int indice) {
        if (esVacia()|| indice<0 || indice>=tamano) {
            return false;

        } else {
            
            if (indice == 0) {
                inicio = inicio.getSiguiente();
                
            }else{
                indice--;
                Nodo1 actual = inicio;
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

}
