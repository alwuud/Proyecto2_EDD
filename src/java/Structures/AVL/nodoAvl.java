/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.AVL;

import Structures.Lista.lista;
import java.io.Serializable;

/**
 *
 * @author Pau
 */
public class nodoAvl implements Serializable{
    public static int id=0;
    private String usuario;
    private String contrasena;
    
    
    private lista direcciones;
    private lista carrito;
    private lista porComprar;
    
    
    
    private nodoAvl izq;
    private nodoAvl der;
    
    
    private int frec;
    private int fe;  
    private int altura;  
    private int iD;
    
    
    public nodoAvl(String usuario, String contrasena){
        this.usuario=usuario;
        this.contrasena=contrasena;
        direcciones=carrito=porComprar=null;
        izq=der=null;
        frec=1;
        fe=0;
        iD= id++;
    }
    
    public nodoAvl(String usuario, String contrasena, nodoAvl izq, nodoAvl der){
        this.usuario=usuario;
        this.contrasena=contrasena;
        direcciones=carrito=porComprar=null;
        this.izq=izq;
        this.der=der;
        frec=1;
        fe=0;
        iD= id++;
    }
    
    
    public String getLabel(){
        try{
            return "u" + this.iD;
        }catch(Exception e1){
            return "";
        }
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contraseña the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the direcciones
     */
    public lista getDirecciones() {
        return direcciones;
    }

    /**
     * @param direcciones the direcciones to set
     */
    public void setDirecciones(lista direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * @return the carrito
     */
    public lista getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(lista carrito) {
        this.carrito = carrito;
    }

    /**
     * @return the porComprar
     */
    public lista getPorComprar() {
        return porComprar;
    }

    /**
     * @param porComprar the porComprar to set
     */
    public void setPorComprar(lista porComprar) {
        this.porComprar = porComprar;
    }

    /**
     * @return the izq
     */
    public nodoAvl getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(nodoAvl izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public nodoAvl getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(nodoAvl der) {
        this.der = der;
    }

    /**
     * @return the frec
     */
    public int getFrec() {
        return frec;
    }

    /**
     * @param frec the frec to set
     */
    public void setFrec(int frec) {
        this.frec = frec;
    }

    /**
     * @return the fe
     */
    public int getFe() {
        return fe;
    }

    /**
     * @param fe the fe to set
     */
    public void setFe(int fe) {
        this.fe = fe;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
}