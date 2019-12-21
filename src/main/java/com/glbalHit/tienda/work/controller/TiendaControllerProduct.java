/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.controller;

import com.glbalHit.tienda.work.servicios.TiendaException;
import com.glbalHit.tienda.work.servicios.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cefar -- Dicomatico
 */


@RestController
@RequestMapping(value = "/poducto")
public class TiendaControllerProduct {
    
    
    @Autowired
    private TiendaServices td;
    
    /**
     * Este metodo retorna todos los productos que esten almacenados en la herramienta
     * @return List<Producto> Retorna una lista con todos los productos presentes en la herramienta.
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){        
        return new ResponseEntity<>(td.getAllProduct(), HttpStatus.ACCEPTED);
    
    }
    
    /**
     * 
     * @param nombre    Es el atributo para nombrar al nuevo producto.
     * @param descipcion    Es el atributo para establecer la descripsion al nuevo producto.
     * @param precio    Es el atributo para establecer el precio al nuevo producto.
     * @throws TiendaException 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/add/{nombre}/{descripcion}/{precio}")
    public void addProducto(@PathVariable String nombre, @PathVariable String descipcion, @PathVariable Integer precio)throws TiendaException{
        td.CreateProduct(nombre, descipcion,precio,td.getSiceProduct()+1);    
    }    
    
    /**
     * 
     * @param nombre    Es el atributo para actualizar el nombre del producto 
     * @param descipcion    Es el atributo para actualizar el descripcion del producto
     * @param precio    Es el atributo para actualizar el precio del producto
     * @param id    Es el atributo para identificar el producto a modificar.
     * @throws TiendaException 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/change/{nombre}/{descripcion}/{precio}/{id}")
    public void ChangeProducto(@PathVariable String nombre, @PathVariable String descipcion, @PathVariable Integer precio, @PathVariable Integer id)throws TiendaException{
        td.changeProduct(nombre, descipcion, precio, id);

    }
    
    /**
     * 
     * @param id Es el parametro para identificar el producto a eliminar
     * @throws TiendaException 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/eraser/{id}")
    public void EraseProducto( @PathVariable Integer id)throws TiendaException{
        td.EraseProduct(id);

    }
    
    
    
    
    
}
