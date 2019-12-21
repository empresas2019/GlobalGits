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
            
    
    public Cliente(){}
    
    public Cliente(String nombre, Integer identificacion ){
        this.nombre=nombre;
        this.identificacion=identificacion;
        HistorialCompras=new ArrayList<Producto>();
        CarritoCompras=new ArrayList<Producto>();
    
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public List<Producto> getHistorialCompras() {
        return HistorialCompras;
    }

    public List<Producto> getCarritoCompras() {
        return CarritoCompras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public void setHistorialCompras(List<Producto> HistorialCompras) {
        this.HistorialCompras = HistorialCompras;
    }

    public void setCarritoCompras(List<Producto> CarritoCompras) {
        this.CarritoCompras = CarritoCompras;
    }
    



    
}
