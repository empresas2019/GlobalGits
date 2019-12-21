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
    
    
    public TiendaException (String message, Throwable cause){
        super(message,cause);      
    }
            
    public TiendaException(String message){
        super(message);
    }
    
    
}
