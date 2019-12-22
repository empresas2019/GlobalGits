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
     * @return List<Cliente> Retorna una lista con todos los clientes presentes en la herramienta.
     */
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllClient(){        
        return new ResponseEntity<>(td.getAllClient(), HttpStatus.ACCEPTED);
    
    }

    @GetMapping("/one/{identificacion}")
    public ResponseEntity<?> getClient(@PathVariable Integer identificacion){        
        td.clientPay(identificacion);
        return new ResponseEntity<>(td.getClient(identificacion), HttpStatus.ACCEPTED);
    
    }
    

    @RequestMapping(method=RequestMethod.POST, path ="/pay/{identificacion}")
    public ResponseEntity<?> clientPay(@PathVariable Integer identificacion)throws TiendaException{
        System.out.println("que entra pagar: "+identificacion);
        td.clientPay(identificacion);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    
    /**
     * @param nombre Es el atributo para adicionar un nuevo cliente a la herramienta.
     * @return ResponseEntity<?> Retorna un objeto de tipo de ResponseEntity.
     * @throws TiendaException 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/add/{nombre}/{identificacion}")
    public ResponseEntity<?> addClient(@PathVariable String nombre, @PathVariable Integer identificacion)throws TiendaException{
        td.CreateClient(nombre,identificacion);  
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }    
    
    /**
     * @param nombre  Es el parametro para modificar el valor del cliente.
     * @param identificacion Es el parametro para poder identificar el cliente a modificar.
     * @param HistorialCompras Es el parametro para listar todas las compras que ha realizado en una fecha determinada
     * @param CarritoCompras Es el parametro para listar todos los productos que el cliente va a querer comprar.
     * @throws TiendaException 
     */
    
    @RequestMapping(method=RequestMethod.POST, path ="/change/{nombre}/{identificacion}/{HistorialCompras}/{CarritoCompras}")
    public void ChangeClient(@PathVariable String nombre,@PathVariable Integer identificacion, @PathVariable List<Producto> HistorialCompras,@PathVariable List<Producto> CarritoCompras)throws TiendaException{
        td.changeCliente(nombre, identificacion, HistorialCompras, CarritoCompras);

    }
    /**
     * @param id Es el parametro para identidicar el producto a borrar.
     * @throws TiendaException 
     */
    @RequestMapping(method=RequestMethod.POST, path ="/eraser/{identificacion}")
    public void EraseClient( @PathVariable Integer id)throws TiendaException{
        td.eraseClient(id);

    }
    
    @RequestMapping(method=RequestMethod.POST, path ="/addprod/{identificacion}/{idprod}")
    public void addProductClient( @PathVariable Integer identificacion,@PathVariable Integer idprod)throws TiendaException{
        td.addProducClient(identificacion, idprod);

    }    
    
}
