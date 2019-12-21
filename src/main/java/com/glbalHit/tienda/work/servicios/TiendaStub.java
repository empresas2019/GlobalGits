/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.servicios;

import com.glbalHit.tienda.work.model.Cliente;
import com.glbalHit.tienda.work.model.Producto;
import com.glbalHit.tienda.work.model.Tienda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cefar -- Dicomatico
 */
@Service
public class TiendaStub implements TiendaServices {

    private List<Cliente> Clientes = new ArrayList<Cliente>();

    private List<Producto> productos = new ArrayList<Producto>();

    private Cliente cl;
    private static Tienda mi;

    /**
     * 
     */
    
    public TiendaStub() {

    }

    /**
     * 
     * @param nombre
     * @param descripcion
     * @param precio
     * @param id 
     */
    @Override
    public void CreateProduct(String nombre, String descripcion, Integer precio, Integer id) {
        productos.add(new Producto(nombre,descripcion,precio,productos.size()+1));
        
    }

    /**
     * 
     * @param id
     * @return 
     */
    
    @Override
    public Producto getProduct(Integer id) {
        Producto pro=new Producto();
        for(Producto pr: productos){
            if(pr.getId()==id){
                pro=pr;            
            }
        }       
        return pro;
    }

    /**
     * 
     * @param nombre
     * @param descripcion
     * @param precio
     * @param id 
     */
    
    @Override
    public void changeProduct(String nombre, String descripcion, Integer precio, Integer id) {
        for(Producto pr: productos){
            if(pr.getId()==id){
                pr.setDescripcion(descripcion);
                pr.setNombre(nombre);
                pr.setPrecio(precio);
            }
        }
    }

    /**
     * 
     * @param id 
     */
    
    @Override
    public void EraseProduct(Integer id) {
        for(int i=0; i<productos.size() ; i++){
            Producto temp=productos.get(i);
            int te=i;
            if(temp.getId()==id){
                productos.remove(i);            
            }        
        }        
    }

    /**
     * 
     * @param nombre 
     */
    
    @Override
    public void CreateClient(String nombre) {
        System.out.println("Si LLEegamos");
        cl = new Cliente(nombre, Clientes.size() + 1);
        Clientes.add(cl);

    }

    /**
     * 
     * @return 
     */
    @Override
    public Cliente getClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param nombre
     * @param identificacion
     * @param HistorialCompras
     * @param CarritoCompras 
     */
    
    @Override
    public void changeCliente(String nombre, Integer identificacion, List<Producto> HistorialCompras, List<Producto> CarritoCompras) {
        for (Cliente to : Clientes) {
            if (to.getIdentificacion() == identificacion) {
                to.setCarritoCompras(CarritoCompras);
                to.setHistorialCompras(HistorialCompras);
                to.setNombre(nombre);                
            }            
        }
    }

    /**
     * 
     * @param identificacion 
     */
    
    @Override
    public void eraseClient(Integer identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * 
 * @param fechaIn
 * @param fechaFin
 * @return 
 */
    
    @Override
    public String GeneratorReporter(String fechaIn, String fechaFin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @return 
     */
    @Override
    public Integer getSiceProduct() {
        return productos.size();
    }

    static {
        mi = TiendaServices.CreateTienda("Mi Iingrersos Hits");

    }

    @Override
    public List<Producto> getAllProduct() {
        return productos;
    }

}
