/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Bussiness.Producto;
import Structures.AVL.*;
import Structures.Hash.Tabla;
import Tools.Escritor;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author danielherrerahernandez
 */
@WebService(serviceName = "Usuario")
public class Usuario {
   public static AVL usuarios= new AVL();
   
   //public static Tabla productos= new Tabla();

   public static Producto[] productos = new Producto[100];
   
   public static int conteoProductos=0;
   
   
   
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public Boolean login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        boolean nodo= usuarios.buscar(user, password);
        
        return nodo;
        
        
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        usuarios.insertar(user, password);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public nodoAvl getUser(@WebParam(name = "user") String user) {
        //TODO write your implementation code here:
        
        try{
            return usuarios.buscar(user);
        }catch(Exception e1){
            return null;
            
        }
      
    }
    
    

    /**
     * Web service operation
     * ESTE METODO SE USA PARA MODIFICAR
     */
    @WebMethod(operationName = "updateUser")
    public Boolean updateUser(@WebParam(name = "actualUser") String actualUser, @WebParam(name = "newUser") String newUser, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        nodoAvl actual=null;
        try{
            actual= usuarios.buscar(actualUser);
            if(actual!=null){
                actual.setUsuario(newUser);
                actual.setContrasena(password);
                return true;
            }else{
                return false;
                
            }
     
        }catch(Exception e1){
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "pushCarritoCompra")
    public Boolean pushCarritoCompra(@WebParam(name = "codProducto") int codProducto, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "usuario") String usuario) {
        //TODO write your implementation code here:
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "pushPorComprar")
    public Boolean pushPorComprar(@WebParam(name = "codProducto") int codProducto, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "usuario") String usuario) {
        //TODO write your implementation code here:
        return true;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "realizarCompra")
    public Boolean realizarCompra(@WebParam(name = "usuario") String usuario, @WebParam(name = "totalCompra") double totalCompra) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminardeCarrito")
    public Boolean eliminardeCarrito(@WebParam(name = "usuario") String usuario, @WebParam(name = "codigoProducto") int codigoProducto) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarporComprar")
    public Boolean eliminarporComprar(@WebParam(name = "usuario") String usuario, @WebParam(name = "codigoProducto") int codigoProducto) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "trasladaraCarrito")
    public Boolean trasladaraCarrito(@WebParam(name = "usuario") String usuario, @WebParam(name = "codigoProducto") int codigoProducto) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarProducto")
    public Boolean agregarProducto(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "marca") String marca, @WebParam(name = "precio") double precio, @WebParam(name = "ruta") String ruta) {
        //TODO write your implementation code here:
        try{
            Producto nuevo= new Producto(codigo);
        
            nuevo.setNombre(nombre);
            nuevo.setMarca(marca);
            nuevo.setPrecio(precio);
            nuevo.setRuta(ruta);
            
            if(conteoProductos<10){
                   productos[conteoProductos++]= nuevo;
                   return true;
            }
            return false;
            
        }catch(Exception e1){
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProducto")
    public Producto getProducto(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        try{
                    Producto aux=null;
            for(int i=0; i<conteoProductos; i++){
                aux= productos[i];
                if(aux!=null){
                    if(aux.getCodigo()== codigo){
                        return aux;
                    }
                }

            }
        
             return null;
        }catch(Exception e1){
            return null;
        }
            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "graficarUsuarios")
    public Boolean graficarUsuarios(@WebParam(name = "sayHello") String sayHello) {
        //TODO write your implementation code here:
        try{
            return usuarios.graficar();
            
        }catch(Exception e1){
            return false;
        }

//        try{
//            Escritor writer= new Escritor();
//            writer.escribir("avl.dot", "digraph G{\n "  + "a->b\nb->c\na->c\n}");
//            Process p = Runtime.getRuntime().exec("dot -Tpng avl.dot -o avl.png");
//            return true;
//        }catch(Exception e1){
//            return false;
//        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCodigosProducto")
    public String getCodigosProducto() {
        //TODO write your implementation code here:
            String retorno="";
            try{
                    Producto aux=null;
                for(int i=0; i<conteoProductos; i++){
                    aux= productos[i];
                    if(aux!=null){
                        retorno += aux.getCodigo() + " ";

                    }

            }
        
             return null;
        }catch(Exception e1){
            return null;
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cantidadProductos")
    public Integer cantidadProductos() {
        //TODO write your implementation code here:
        return conteoProductos;
    }
    
    
    
    
    

   
    
}
