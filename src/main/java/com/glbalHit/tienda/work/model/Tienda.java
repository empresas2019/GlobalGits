/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.model;

import com.glbalHit.tienda.work.servicios.TiendaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cefar -- Dicomatico
 */

public class Tienda {
    
    private static Tienda tienda;
    private String nombre ;
    private List<Producto> productos;
    private List<Producto> ventas;
    
    private Tienda(String nombre){
        this.nombre=nombre;
        productos=new ArrayList<Producto>();
        ventas=new ArrayList<Producto>();   
    }

    public static Tienda getTienda() {
        return tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> getVentas() {
        return ventas;
    }

    public static void setTienda(Tienda tienda) {
        Tienda.tienda = tienda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setVentas(List<Producto> ventas) {
        this.ventas = ventas;
    }
    
    public void addProducto(Producto producto){
        productos.add(producto);
    }
    
    public static Tienda getTienda(String nombre){
                   
        if(tienda==null){
            tienda=new Tienda(nombre);
            
        }else{
            TiendaException dr=new TiendaException("No se puede crear otra tienda");            
        }
    return tienda;
    }
    
}
