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
public class ArbolB {
    
    private Pagina raiz;
    private int orden;
    
    public ArbolB(int orden){
        raiz=null;
        this.orden= orden;
        mediana=null;
        nuevaPagina=null;
        index=0;
    }
    
    
    public Pagina getRaiz(){
        return this.raiz;    
    }
    
    public void setRaiz(Pagina pagina){
        raiz= pagina;
        
    }
    
    public int getOrden(){
        return orden;
    }
    
    

    private Venta mediana;
    private Pagina nuevaPagina;
    private int index;
    
    public void insertar(Venta v){
        
        
        try{
            raiz= insertar(this.raiz, v);
        }catch(Exception e1){
            System.out.println("Error al realizar insercion");
        }
        

        
        System.out.println("Claves en raiz : "  +raiz.getCuenta());
        /***Variables auxiliares para todo el proceso de insercion**/
        mediana=null;
        nuevaPagina=null;
    }
    
    
    private Pagina insertar(Pagina raiz, Venta nueva){
        
        boolean goingUp;
        
      
        
        goingUp= empujar(raiz,nueva);
   
        if(goingUp){
            Pagina p= new Pagina(this.orden);
            p.setCuenta(1);
            p.setClave(1, this.mediana);
            p.setRama(0, raiz);
            p.setRama(1, this.nuevaPagina);
            raiz= p;
        }
        
         raiz.imprimirPagina();
        
        return raiz;
      
    }
    
    

    
    private boolean empujar(Pagina actual, Venta nueva){
        
        boolean subeArriba=false;
        if(actual==null){
            subeArriba= true;
            this.mediana= nueva;
            nuevaPagina= null;
            
            
            
        }else{
            Busqueda b= buscarNodo(actual, nueva.getClave());
            if(b.encontrado){
                //throw
            }
            subeArriba= empujar ( actual.getRama(b.index), nueva);
            if (subeArriba){
                if(actual.lleno()){
                   
                    dividirNodo(actual, b.index );    
                    
                }else{
                    subeArriba=false;
                    meterPagina(actual,nuevaPagina,mediana, b.index);
                }
            }
        }
        
        
        return subeArriba;
        
    }
    
    
    public void meterPagina (Pagina actual,Pagina derecha,  Venta nuevo, int indice){
       
        for(int i= actual.getCuenta(); i>=indice; i--){
            actual.setClave(i+1, actual.getClave(i));
            actual.setRama(i+1, actual.getRama(i));
        }
        
        actual.setClave(indice+1, nuevo);
        actual.setRama(indice+1,derecha );
        
        actual.setCuenta(actual.getCuenta()+1);
        
        }
    public void dividirNodo(Pagina actual , int indice){
            int i, posMed, k;
            Pagina nuevaPagina= new Pagina(orden);
            k=indice;
            
            posMed= (k<=orden/2)? orden/2: orden/2 +1;
            
            for(i= posMed+1 ; i<orden ; i ++){
                nuevaPagina.setClave(i-posMed, actual.getClave(i));
                nuevaPagina.setRama(i - posMed, actual.getRama(i));
            }
            
            nuevaPagina.setCuenta((orden-1) - posMed);
            actual.setCuenta(posMed);
            
            if(k <= (orden/2)){
                meterPagina(actual, this.nuevaPagina, mediana, indice   );
            }else{
                indice = k - posMed;
                meterPagina(nuevaPagina, this.nuevaPagina, mediana, indice);
                
            }
            
            mediana= actual.getClave(actual.getCuenta());
            nuevaPagina.setRama(0, actual.getRama(actual.getCuenta()));
            actual.setCuenta(actual.getCuenta()-1);
            this.nuevaPagina= nuevaPagina;
            
            
    }
    
    public class Busqueda{
        int index;
        boolean encontrado;
        
        public Busqueda(int index, boolean encontrado){
            this.index= index;
            this.encontrado= encontrado;
        }
    }
    
    public class Busqueda2{
        Pagina p;
        int index;
        
        public Busqueda2(int index, Pagina p){
            this.p= p;
            this.index= index;
            
        }
    }
    
    
    private Busqueda buscarNodo(Pagina actual, int clave){
        int index;
        boolean encontrado;
        if(clave < actual.getClave(1).getClave()){
            encontrado=false;
            index=0;
            
        }else{
            index= actual.getCuenta();
            while(clave< actual.getClave(index).getClave() && (index>1)){
                index--;
            }
            encontrado= (clave== actual.getClave(index).getClave());
            
        }
        
        return new Busqueda(index, encontrado);
        
    }
    
    private Busqueda2 buscar(Venta venta){
        try{
            return buscar(raiz, venta.getClave());
        }catch(Exception e1){
            return null;
        }
    }
    
    public Busqueda2 buscar(Pagina actual, int clave){
        if(actual==null){
            return null;
        }else{
            Busqueda b= buscarNodo(actual,  clave);
            if(b.encontrado){
                return new Busqueda2(b.index, actual);
                
            }else{
                return buscar(actual.getRama(b.index), clave);
            }
        }
    }


}
