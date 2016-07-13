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
    
    private Producto productos[];
    private boolean empty[];
    private double factorCarga;
        
    
    int tamanoActual;
    
    public Tabla(){
        productos= new Producto[23];
        empty= new boolean[23];
        
    }
    
    
    
    public int hashFunction(int clave){
        
        
        return 0;
        
        
    }
}
