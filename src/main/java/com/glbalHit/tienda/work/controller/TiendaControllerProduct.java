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
@RequestMapping(value = "/producto")
public class TiendaControllerProduct {
        
    @Autowired
    private TiendaServices td;
    
    /**
     * Este metodo retorna todos los productos que esten almacenados en la herramienta
     * @return List Retorna una lista con todos los productos presentes en la herramienta.
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){        
        return new ResponseEntity<>(td.getAllProduct(), HttpStatus.ACCEPTED);    
    }
    /**
     * Este metodo permite traer toda la informacion relacionada a un producto.
     * @param idproducto    El identificador del producto a buscar
     * @return producto El objeto que se desea consultae
     */
    @GetMapping("/one/{idproducto}")
    public ResponseEntity<?> getOneProduct(@PathVariable Integer idproducto){        
        return new ResponseEntity<>(td.getProduct(idproducto), HttpStatus.ACCEPTED);    
    }
    
    /**
     * Este metodo adiciona un producto al almacen.
     * @param nombre    Es el atributo para nombrar al nuevo producto.
     * @param descripcion    Es el atributo para establecer la descripsion al nuevo producto.
     * @param precio    Es el atributo para establecer el precio al nuevo producto.
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */
    @RequestMapping(method=RequestMethod.POST, path ="/add/{nombre}/{descripcion}/{precio}/{identificacion}")
    public void addProducto(@PathVariable String nombre, @PathVariable String descripcion, @PathVariable Integer precio,@PathVariable Integer identificacion)throws TiendaException{
        td.CreateProduct(nombre, descripcion,precio,identificacion);    
    }    
    
    /**
     * Este metodo cambia los atributios del producto
     * @param nombre    Es el atributo para actualizar el nombre del producto 
     * @param descripcion    Es el atributo para actualizar el descripcion del producto
     * @param precio    Es el atributo para actualizar el precio del producto
     * @param id    Es el atributo para identificar el producto a modificar.
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */
    @RequestMapping(method=RequestMethod.POST, path ="/change/{nombre}/{descripcion}/{precio}/{id}")
    public void ChangeProducto(@PathVariable String nombre, @PathVariable String descripcion, @PathVariable Integer precio, @PathVariable Integer id)throws TiendaException{
        td.changeProduct(nombre, descripcion, precio, id);
    }
    
    /**
     * Este metodo elimina un prdocto.
     * @param id     Es el parametro para identificar el producto a eliminar
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */ 
    @RequestMapping(method=RequestMethod.POST, path ="/eraser/{id}")
    public void EraseProducto( @PathVariable Integer id)throws TiendaException{
        td.EraseProduct(id);
    }
}
