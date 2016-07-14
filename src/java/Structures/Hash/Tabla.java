/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Hash;

import Bussiness.Producto;

/**
 *
 * @author daniel
 */
public class Tabla {
    
    private Hash elementos[];
    private double factorCarga;
        
    
    int tamanoActual;
    
    public Tabla(int tamano){
        elementos=  new Hash[tamano];
        for(int i=0; i< tamano; i++){
            elementos[i]= new Hash();
        }
        
        
        
    }
    
    
    
    
    
    public int hashFunction(int clave){
        
        return 0;
        
    }
}
