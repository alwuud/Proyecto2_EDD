/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Bussiness.Producto;
import Structures.AVL.*;
import Structures.Hash.Tabla;
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
   
   public static Tabla productos= new Tabla();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        usuarios.insertar("admin", "admin");
        return "Hello " + txt + " !";
        
        
        
    }
    
    

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
    @WebMethod(operationName = "buscarProducto")
    public Producto buscarProducto(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        
        
        return null;
    }
    
    
}
