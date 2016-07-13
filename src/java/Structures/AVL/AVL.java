/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.AVL;
/**
 *
 * @author Pau
 */
public class AVL {
    private nodoAvl raiz;
    
    public AVL (){
        raiz=null;
    }
    
    
    
    public boolean buscar(String usuario, String password){
        try{
            nodoAvl temp= buscar(usuario,  this.raiz);
            if(temp!=null &&  temp.getContraseña().equals(password))
                return true;
            else
                return false;
            
        }catch(Exception e1){
            return false;
        }
        
    }
    
    public nodoAvl buscar(String usuario, nodoAvl raiz){
                //Si en nodo recibido fuera nulo entonces el nuevo nodo se puede insertar 
        //en esa posición y se terminan las llamadas recursivas a este método.
        if(raiz == null){
            return null;
        //Si el nuevo valor fuera menor que el nodo de actual entonces
        }else if(usuario.compareTo(raiz.getUsuario()) < 0){
            return buscar(usuario,  raiz.getIzq());
        }
        else if(usuario.compareTo(raiz.getUsuario())>0)
        //Si el nuevo valor fuera mayor que el nodo de la actual entonces:
        {          
            return buscar(usuario,  raiz.getDer());
        }else if(raiz.getUsuario().compareTo(usuario)==0){
                //el dato es igual a la raiz
                
                return raiz;
       }
       return null;
       
    }
    public void insertar(String usuario, String contraseña){
        try{
            this.setRaiz(this.insertar(usuario, contraseña, this.raiz));
        }catch(Exception e1){
            System.out.println("Error detectado");
        }
    }
     private nodoAvl insertar(String usuario, String contraseña, nodoAvl raiz){
        //Si en nodo recibido fuera nulo entonces el nuevo nodo se puede insertar 
        //en esa posición y se terminan las llamadas recursivas a este método.
        if(raiz == null){
            raiz = new nodoAvl(usuario, contraseña);
        //Si el nuevo valor fuera menor que el nodo de actual entonces
        }else if(usuario.compareTo(raiz.getUsuario()) < 0){
            raiz.setIzq(insertar(usuario, contraseña,raiz.getIzq()));            
            if(altura(raiz.getDer())-altura(raiz.getIzq()) == -2)
                if(usuario.compareTo(raiz.getIzq().getUsuario()) < 0)
                    raiz = IzquierdaIzquierda(raiz);
                else
                    raiz = IzquierdaDerecha(raiz);
        }
        else if(usuario.compareTo(raiz.getUsuario())>0)
        //Si el nuevo valor fuera mayor que el nodo de la actual entonces:
        {          
            raiz.setDer(insertar(usuario, contraseña, raiz.getDer()));            
            if(altura(raiz.getDer())-altura(raiz.getIzq()) == 2)               
                if(usuario.compareTo(raiz.getDer().getUsuario()) > 0)                   
                    raiz = DerechaDerecha(raiz);
                else
                    raiz = DerechaIzquierda(raiz);
        }else if(raiz.getUsuario().compareTo(usuario)==0){
                //el dato es igual a la raiz
                
                raiz.setFrec(raiz.getFrec()+ 1);
                System.out.println("agregue frecuencia");
            }
        raiz.setAltura(mayor(altura(raiz.getIzq()), altura(raiz.getDer()))+1);
        return raiz;
    }
    /**
     * Método que devuelve la altura de un nodo.
     * @param nodo
     * @return 
     */
    private int altura( nodoAvl nodo )
    {
        if(nodo==null)
            return -1;
        else
            return nodo.getAltura();
    }
    /**
     * Método que recibe como parámetro dos numeros y devuelve el mayor.
     * @param n1
     * @param n2
     * @return 
     */
    private int mayor(int n1, int n2)
    {
        if(n1 > n2)
            return n1;
        return n2;
    }
    /**
     * Rotación simple izquierda izquierda para el proceso de balanceo.
     * @param n1
     * @return 
     */
    private nodoAvl IzquierdaIzquierda(nodoAvl n1){
        nodoAvl n2 = n1.getIzq();
        n1.setIzq(n2.getDer());  
        n2.setDer(n1);
        n1.setAltura( mayor(altura(n1.getIzq()), altura(n1.getDer()))+1);
        n2.setAltura(mayor(altura(n2.getIzq()), n1.getAltura())+1); 
        return n2;
    }
    /**
     * Rotación simple derecha derecha para el proceso de balanceo.
     * @param n1
     * @return 
     */
    private nodoAvl DerechaDerecha( nodoAvl n1 ){
        nodoAvl n2 = n1.getDer();
        n1.setDer(n2.getIzq());
        n2.setIzq(n1);
        n1.setAltura( mayor(altura(n1.getIzq()), altura(n1.getDer()))+1);
        n2.setAltura(mayor(altura(n2.getIzq()), n1.getAltura())+1); 
        return n2;
    }
    /**
     * Rotación doble izuquierda derecha para el proceso de balanceo.
     * @param n1
     * @return 
     */
    private nodoAvl IzquierdaDerecha(nodoAvl n1){
        n1.setIzq(DerechaDerecha(n1.getIzq()));
        return IzquierdaIzquierda(n1);
    }
    /**
     * Rotación doble derecha izquierda para el proceso de balanceo.
     * @param n1
     * @return 
     */
    private nodoAvl DerechaIzquierda(nodoAvl n1 ){
        n1.setDer(IzquierdaIzquierda(n1.getDer()));
        return DerechaDerecha(n1);
    }       

  public String dibujar (String puntero, nodoAvl aux){
        if (puntero==null){
            puntero= "digraph G{ \r\n node[shape=record]; \r\n";
        }
        String actual,izq,der;
        if(aux!=null){
            actual=aux.getUsuario();
            izq=aux.getUsuario()+"l";
            der=aux.getUsuario()+"r";
            puntero+=actual+"[label=\"<"+izq+">left|<"+actual+"m>"+actual+" fe:"+aux.getFe()+"|<"+der+">right\"];\r\n";
            if(aux.getIzq()!=null){
                puntero= dibujar(puntero, aux.getIzq());
                String left=aux.getIzq().getUsuario();
                puntero+=actual+":"+izq+"->"+left+":"+left+"m;\r\n";
            }
            if(aux.getDer()!=null){
                puntero= dibujar(puntero, aux.getDer());
                String right=aux.getDer().getUsuario();
                puntero+=actual+":"+der+"->"+right+":"+right+"m;\r\n";  
            } 
        }
        return puntero;
    }

    public nodoAvl getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoAvl raiz) {
        this.raiz = raiz;
    }
}