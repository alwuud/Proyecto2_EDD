/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.ArbolB;

import Bussiness.Venta;

/**
 *
 * @author daniel
 */


public class Pagina {
    public static int correlativo =0;
    
    
    private Venta claves[];
    private Pagina ramas[];
    private int cuenta;
    private int orden;
    private int id;
    
    public Pagina (int orden){
        this.orden=orden;
        claves = new Venta[orden];
        ramas= new Pagina[orden];
        cuenta=0;
        id=correlativo++;
        
        
    }
    
    
    public boolean lleno(){
        return ( cuenta== orden-1);
        
    }
    
    
    public boolean medioLleno(){
        return ( cuenta < orden/2);
    }
    
    public Venta getClave ( int index){
        try{
            return claves[index];
        }catch(Exception ex){
            return null;
            
        }
        
        
    }
    
    public void setClave(int index, Venta venta){
        try{
            claves[index]= venta;
        }catch(Exception ex){
            System.out.println("Error en el indice");
        }
        
            
    }
    
    public Pagina getRama( int index){
        try{
               return ramas[index];
        }catch(Exception ex){
            return null;
        }
     
    } 
    
    public void setRama(int index, Pagina pagina){
        try{
                  ramas[index]= pagina;
        }catch(Exception ex){
            System.out.println("rama fuera de orden");
        }
  
    }
    
    public int getCuenta(){
        return this.cuenta;
        
        
    }
    
    
    public void setCuenta(int cuenta){
        this.cuenta= cuenta;
        
    }
    
    
    public void imprimirPagina(){
        System.out.println("Facturas: ");
        for(int i=1; i<=cuenta; i++){
            System.out.print(", " + claves[i].getFactura());
            
        }
        System.out.println();
    }
    
    
    /****** 
     *              METODOS PARA GRAPHVIZ
     * 
     */
    
    public String getName(){
        return "p" + this.id;
    }
    
    public String getLabel(){
        String retorno="";
        if(this.getCuenta()>0){
            retorno+= this.getName() + "[label=\"<f0>";
            for(int i=1; i<= this.getCuenta(); i++){
                retorno+= "|"+ claves[i].getClave() + "|<f" + i +">";
            }
            retorno+= "\"]\n";
        }
        
        return retorno;
    }
    
    
    
    
}
