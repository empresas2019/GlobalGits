/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cefar -- Dicomatico
 */
@Service
public class Cliente {
    
    
    private String nombre;
    private Integer identificacion;
    private List<Producto> HistorialCompras;
    private List<Producto> CarritoCompras;
            
    /**
     * Constructor libre para el formateo de SpringBoot.
     */
    public Cliente(){}
    
    /**
     * Constructor con 2 atributos para crear un nuevo cliente.
     * @param nombre El atributo para asignar el nombre al nuevo cliente.
     * @param identificacion EL atributo para identificar al nuevo cliente.
     */
    public Cliente(String nombre, Integer identificacion ){
        this.nombre=nombre;
        this.identificacion=identificacion;
        HistorialCompras=new ArrayList<Producto>();
        CarritoCompras=new ArrayList<Producto>();
    
    }

    /**
     * Este metodo retorna el nombre del cliente.
     * @return nombre String Retorna el nombre del Cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo retorna un entero que identifica al cliente.
     * @return identificacion Integer Retorna el identificador del cliente.
     */
    public Integer getIdentificacion() {
        return identificacion;
    }

    /**
     * Retorna una lista con el historial de compras de productos del cliente. 
     * @return HistorialCompras List<Producto> Lista de productos que ha comprado el cliente.
     */
    public List<Producto> getHistorialCompras() {
        return HistorialCompras;
    }

    /**
     * Retorna una lista con el carrito de compras con los productos que el cliente aun no ha comprado.
     * @return List<Producto> LIsta de productos que estan proximos a ser comprados por el cliente.
     */
    
    public List<Producto> getCarritoCompras() {
        return CarritoCompras;
    }

    /**
     * Establece un nuevo nombre al cliente
     * @param nombre Un objeto String que modifica el nombre del cliente.
     */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece una nueva identificacion al cliente
     * @param identificacion Un objeto entero que modifica la identifiacion del cliente.
     */
    
    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Establece una lista de historal de compras del cliente.
     * @param HistorialCompras Un objeto de lista de tipo producto que modfica el historial de compras del cliente.
     */
    public void setHistorialCompras(List<Producto> HistorialCompras) {
        this.HistorialCompras = HistorialCompras;
    }

    /**
     * Establece una lista de carrito de compras del cliente.
     * @param CarritoCompras Un objeto de lista de tipo Producto que modifica el carrito de compras del cliente.
     */
    
    public void setCarritoCompras(List<Producto> CarritoCompras) {
        this.CarritoCompras = CarritoCompras;
    }
    public void addProudcto(Producto producto){
        CarritoCompras.add(producto);    
    }
    
    public void clearCarritoCompras(){
        CarritoCompras.clear();                
    }
    
    public void addHistorial(Producto producto){
        HistorialCompras.add(producto);
    
    }
    
    
    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + "identificacion=" + identificacion + "HistorialCompras=" +HistorialCompras.toString() +"CarritoCompras="+CarritoCompras.toString() + '}';
    }
    
}
