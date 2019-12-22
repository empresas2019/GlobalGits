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
    
    /**
     * Este metodo retorna todos los clientes que esten almacenados en la herramienta
     * @return List Retorna una lista con todos los clientes presentes en la herramienta.
     */    
    @GetMapping("/all")
    public ResponseEntity<?> getAllClient(){        
        return new ResponseEntity<>(td.getAllClient(), HttpStatus.ACCEPTED);    
    }
    
    /**
     * Este metodo retorna un cliente con una identificacion determinada
     * @param identificacion    Integer Que es el identificador del cliente buscado.
     * @return clieinte El cliente identificado con esa identificacion.(de no estar un cliente vacio)
     */    
    @GetMapping("/one/{identificacion}")
    public ResponseEntity<?> getClient(@PathVariable Integer identificacion){        
        td.clientPay(identificacion);
        return new ResponseEntity<>(td.getClient(identificacion), HttpStatus.ACCEPTED);    
    }
    
    /**
     * Este metodo informa que el cliente ha pagado su carrito de compras.
     * @param identificacion    Integer Que es el identificador del cliente buscado.
     * @return null Retorna valor nulo
     * @throws TiendaException Si ocurre un error esta execpcion saltara. 
     */    
    @RequestMapping(method=RequestMethod.POST, path ="/pay/{identificacion}")
    public ResponseEntity<?> clientPay(@PathVariable Integer identificacion)throws TiendaException{        
        td.clientPay(identificacion);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
    
    /**
     * @param nombre Es el atributo para adicionar un nuevo cliente a la herramienta.
     * @param identificacion Es el identificador del cliente.
     * @return ResponseEntity Retorna un objeto de tipo de ResponseEntity.
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */
    @RequestMapping(method=RequestMethod.POST, path ="/add/{nombre}/{identificacion}")
    public ResponseEntity<?> addClient(@PathVariable String nombre, @PathVariable Integer identificacion)throws TiendaException{
        td.CreateClient(nombre,identificacion);  
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }    
    
    /**
     * @param nombre  Es el parametro para modificar el valor del cliente.
     * @param identificacion Es el parametro para poder identificar el cliente a modificar.
     * @return null Retorna valor nulo
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */    
    @RequestMapping(method=RequestMethod.POST, path ="/change/{nombre}/{identificacion}")
    public ResponseEntity<?> ChangeClient(@PathVariable String nombre,@PathVariable Integer identificacion )throws TiendaException{
        td.changeCliente(nombre, identificacion);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
    
    /**
     * @param identificacion Es el parametro para identidicar el producto a borrar.
     * @return null Retorna valor nulo
     * @throws TiendaException Si ocurre un error esta execpcion saltara. 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/eraser/{identificacion}")
    public ResponseEntity<?> EraseClient( @PathVariable Integer identificacion)throws TiendaException{
        td.eraseClient(identificacion);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
    
    /**
     * Este metodo adiciona un producto a un cliente determinado.
     * @param identificacion    Integer Que es el identificador del cliente buscado.
     * @param idprod    Integer Que es el identificador del producto a añadir.
     * @return  null Retorna nulo
     * @throws TiendaException  Si ocurre un error esta execpcion saltara.
     */
    @RequestMapping(method=RequestMethod.POST, path ="/addprod/{identificacion}/{idprod}")
    public ResponseEntity<?> addProductClient( @PathVariable Integer identificacion,@PathVariable Integer idprod)throws TiendaException{
        td.addProducClient(identificacion, idprod);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }    
}