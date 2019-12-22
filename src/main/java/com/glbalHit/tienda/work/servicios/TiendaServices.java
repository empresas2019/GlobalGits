/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.servicios;

import com.glbalHit.tienda.work.model.Cliente;
import com.glbalHit.tienda.work.model.Producto;
import com.glbalHit.tienda.work.model.Tienda;
import java.util.List;

/**
 *
 * @author Cefar -- Dicomatico
 */
public interface TiendaServices {
    
    public static Tienda CreateTienda(String nombre){
        return Tienda.getTienda(nombre);
    }
    
    public void CreateProduct(String nombre, String descripcion,Integer precio, Integer id);
    public Producto getProduct(Integer id);
    public List<Producto> getAllProduct();
    public void changeProduct(String nombre, String descripcion,Integer precio, Integer id);
    public void EraseProduct( Integer id);
    public Integer getSiceProduct();
    
    
    
    
    //public Cliente CreateClient(String nombre, Integer identificacion);
    public void CreateClient(String nombre, Integer identificacion);
    public Cliente getClient(Integer id);
    public List<Cliente> getAllClient();
    public void addProducClient(Integer idClient, Integer idproduct);
    public void changeCliente(String nombre, Integer identificacion,List<Producto> HistorialCompras,List<Producto> CarritoCompras);
    public void eraseClient(Integer identificacion);
    public void clientPay(Integer identificacion);
    
    
    public String GeneratorReporter(String fechaIn,String fechaFin);
    
    
    
    
    
    
    
    
    
    
    
    
}
