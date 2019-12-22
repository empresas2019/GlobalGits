/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.model;

import com.glbalHit.tienda.work.servicios.TiendaException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Cefar -- Dicomatico
 */
@Service
public class Producto {
    
    private String nombre;
    private Integer id;
    private String descripcion;
    private Integer precio;
    //private Date fechCompra;
    //private SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 

    /**
     * Constructor vacio para el parseo de SPringBoot
     */    
    public Producto() {}
    
    /**
     * Este metodo crea un nuevo producto.
     * @param nombre    Es de tipo String que sera el nombre del producto.
     * @param descripcion   Es de tipo String que sera la descripcion del producto.
     * @param precio    Es de tipo Entero que sera el precio del producto.
     * @param id    Es de tipo Entero que sera el identificador del producto.  
     */
    
    public Producto(String nombre, String descripcion,Integer precio, Integer id) {             
        this.descripcion=descripcion;
        this.precio=precio;
        this.nombre=nombre;    
        this.id=id;    
    }

    /**
     * Establece un nombre nuevo para e producto.
     * @param nombre String que sera el nuevo nombre.
     */    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo id al producto
     * @param id Entero que identifica al producto
     */    
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Establece una nueva descripcion al producto.
     * @param descripcion String que representa la descripcion del producto.
     */    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece un nuevo precio al producto.
     * @param precio    Entero que representa el precio del producto. 
     */    
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * Retorna el nombre del nombre.
     * @return nombre String que representa el nombre del producto.
     */    
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el identificador del producto.
     * @return id Entero que identifica el producto.
     */    
    public Integer getId() {
        return id;
    }

    /**
     * Retorna la descripcion del producto.
     * @return descripcion String que representa la descipsion del producto.
     */    
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Retorna el precio del producto.
     * @return precio Entero que representa el precio del producto.
     */    
    public Integer getPrecio() {
        return precio;
    }
  
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + "descripcion=" + descripcion + "precio=" +precio +"id="+id +'}';
    }            
}
