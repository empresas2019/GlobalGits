/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.controller;

import com.glbalHit.tienda.work.servicios.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cefar -- Dicomatico
 */

@RestController
@RequestMapping(value = "/venta")
public class TiendaControllerVenta {
    
    
    @Autowired
    private TiendaServices td;
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllVenta(){        
        return new ResponseEntity<>(td.getAllVentas(), HttpStatus.ACCEPTED);
    
    }
    @GetMapping("/allf")
    public ResponseEntity<?> getAllFechas(){        
        return new ResponseEntity<>(td.getAllFechas(), HttpStatus.ACCEPTED);
    
    }
    
}
