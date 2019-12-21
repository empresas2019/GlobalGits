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
public class TiendaStub implements TiendaServices{

    private List<Cliente> Clientes=new ArrayList<Cliente>();
    
    private List<Producto> productos=new ArrayList<Producto>();
    
    private Cliente cl;
    
    public TiendaStub(){
        
    
    
    }
            
    @Override
    public Tienda CreateTienda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto CreateProduct(String nombre, String descripcion, Integer precio, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto getProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeProduct(String nombre, String descripcion, Integer precio, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EraseProduct(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CreateClient(String nombre) {
        System.out.println("Si LLEegamos");
        cl= new Cliente(nombre,Clientes.size()+1);
        Clientes.add(cl);
        
    }

    @Override
    public Cliente getClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeCliente(String nombre, Integer identificacion, List<Producto> HistorialCompras, List<Producto> CarritoCompras) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eraseClient(Integer identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static {
        Tienda mi=Tienda.getTienda("nombre");
        
        /**
        
        try{
            
        
        }catch (TiendaException ex){
            Logger.getLogger(TiendaStub.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        */
    
    
    
    
    }

    @Override
    public String GeneratorReporter(String fechaIn, String fechaFin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getSiceProduct() {
        return productos.size();
    }
    
}
