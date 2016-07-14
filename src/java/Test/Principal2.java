/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Tools.Escritor;

/**
 *
 * @author danielherrerahernandez
 */
public class Principal2 {
    
    
    public static void main (String []a){
       Escritor writer= new Escritor();
        
        try{
            writer.escribir("avl.dot", "digraph G{\n "  + "a->b\nb->c\na->c\n}");
            Process p = Runtime.getRuntime().exec("dot -Tpng avl.dot -o avl.png");
            
        }catch(Exception e1){
            
           System.out.println("Carajo");
        }
    }
    
}
