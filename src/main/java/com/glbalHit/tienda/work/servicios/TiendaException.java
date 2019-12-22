/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.servicios;

/**
 *
 * @author Cefar -- Dicomatico
 */
public class TiendaException  extends Exception {
    
    /**
     * Lanza una excepcion con un mensage y su causa.
     * @param message   Mnesage al momento de decir la excepcion.
     * @param cause     Causa por la que sucedio la excepcion.
     */
    public TiendaException (String message, Throwable cause){
        super(message,cause);      
    }
       
    /**
     * Lanza una excepcion pero solo muestra un mensaje.
     * @param message   String Mensaje  que se genera cuando ocurre una excepcion.
     */    
    public TiendaException(String message){
        super(message);
    }
}