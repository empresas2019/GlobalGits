/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.model;

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
    
    
    public Producto(){}
    
    public Producto(String nombre, String descripcion,Integer precio, Integer id){
        this.descripcion=descripcion;
        this.precio=precio;
        this.nombre=nombre;    
        this.id=id;
    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }
            
            
    
}
