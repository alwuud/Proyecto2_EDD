/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Bussiness.Venta;
import Structures.ArbolB.ArbolB;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Principal {
    
    
    public static void main (String []a){
        
        ArbolB ventas= new ArbolB (5);
        Scanner teclas= new Scanner(System.in);
        int numFactura=1;
        
        while(numFactura!=0){
            System.out.print("Ingrese num factura: ");
            numFactura= teclas.nextInt();
            
            ventas.insertar(new Venta(numFactura, "hoy"));
                  
        }
    
    
    }
    
}
