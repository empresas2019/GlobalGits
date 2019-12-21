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
    
    /**
     * COnstructor privado para que no se inicie una nueva instancia de TIenda
     * @param nombre Un objeto String para asignar un nomnbre a la tienda.
     */
    
    private Tienda(String nombre){
        this.nombre=nombre;
        productos=new ArrayList<Producto>();
        ventas=new ArrayList<Producto>();   
    }

    /**
     * Retorna  la instancia de Tienda.
     * @return tienda Retorna un objeto tipo Tienda que  representara la unica instancia del objeto Tienda
      */
    
    public static Tienda getTienda() {
        return tienda;
    }

    /**
     * Retorna el nombre de la tienda
     * @return nombre Retorna un objeto String que representa el ombre de la tienda.
     */
    
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna a  lista de productos que tiene el almacen.
     * @return productos List<Producto> Que contiene todos los productos del almacen.
     */
    
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Retorna todas las ventas del almacen.
     * @return ventas List<Producto> Retorna una lista de productos vendidos.
     */
    
    public List<Producto> getVentas() {
        return ventas;
    }

    /**
     * Establece un objeto de tipo tienda a tienda.
     * @param tienda Objeto para establecer la unica estancia de Tienda.
     */
    
    public static void setTienda(Tienda tienda) {
        Tienda.tienda = tienda;
    }

    /**
     * MOdifica el nombre del objeto Tienda
     * @param nombre Objeto String que representa el nuevo nombre de la tienda.
     */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Modifica la lista de productos de la tienda.
     * @param productos Objeto de tipo List<Producto>  que representa la nueva lista de productos de la tienda.
     */
    
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Modifica la lista de ventas realizadas de la tienda.
     * @param ventas Objeto de tipo List<Proudcto> Que representa la nueva lista de las ventas realizadas en el almacen.
     */
    
    public void setVentas(List<Producto> ventas) {
        this.ventas = ventas;
    }
    
    /**
     * Este metodo adiciona un nuevo producto a la tienda.
     * @param producto OBjeto de tipo producto que representa el nuevo objeto a agregar.
     */
    
    public void addProducto(Producto producto){
        productos.add(producto);
    }
    
    /**
     * Este metodo solo permite tener una instancia del objeto Tienda
     * @param nombre String representa el nombre de la tienda.
     * @return tienda Objeto de tipo Tienda que sera la unica instancia del objeto Tienda.
     */
    public static Tienda getTienda(String nombre){
                   
        if(tienda==null){
            tienda=new Tienda(nombre);
            
        }else{
            TiendaException dr=new TiendaException("No se puede crear otra tienda");            
        }
    return tienda;
    }
    
    
    @Override
    public String toString() {
        return "Tienda{" + "nombre=" + nombre + "Productos=" +productos.toString() +"ventas="+ventas.toString()+ '}';
    }
    
}
