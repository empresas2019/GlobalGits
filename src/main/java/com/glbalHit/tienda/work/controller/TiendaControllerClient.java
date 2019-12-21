/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.controller;

import com.glbalHit.tienda.work.model.Producto;
import com.glbalHit.tienda.work.servicios.TiendaException;
import com.glbalHit.tienda.work.servicios.TiendaServices;
import java.util.List;
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
@RequestMapping(value = "/cliente")
public class TiendaControllerClient {
    
    @Autowired
    private TiendaServices td;
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllClient(){        
        return new ResponseEntity<>(td.getClient(), HttpStatus.ACCEPTED);
    
    }
    
    
    @RequestMapping(method=RequestMethod.POST, path ="/add/{nombre}")
    public ResponseEntity<?> addClient(@PathVariable String nombre)throws TiendaException{
        td.CreateClient(nombre);  
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }    
    
    @RequestMapping(method=RequestMethod.POST, path ="/change/{nombre}/{identificacion}/{HistorialCompras}/{CarritoCompras}")
    public void ChangeClient(@PathVariable String nombre,@PathVariable Integer identificacion, @PathVariable List<Producto> HistorialCompras,@PathVariable List<Producto> CarritoCompras)throws TiendaException{
        td.changeCliente(nombre, identificacion, HistorialCompras, CarritoCompras);

    }
    
    @RequestMapping(method=RequestMethod.POST, path ="/eraser/{identificacion}")
    public void EraseClient( @PathVariable Integer id)throws TiendaException{
        td.eraseClient(id);

    }
    
    
    
}
