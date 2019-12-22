/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.model;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author Cefar -- Dicomatico
 */
public class Venta {
        
    private Producto productoVendido;
    private Cliente clienteCompro;
    private Date fechaCompra;
    private Date d=new Date();
    private SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");

    /**
     * Constructor vacio para el parseo.
     */    
    public Venta(){}
    
    /**
     * Constructor con 2 atributos para crear una nueva venta
     * @param productoVendido  Producto vendido en una fecha especifica.
     * @param clienteCompro     Cliente que pago por el producto.
     */    
    public Venta(Producto productoVendido, Cliente clienteCompro){
        this.productoVendido=productoVendido;
        this.clienteCompro=clienteCompro;
        fechaCompra=new Date();        
    }

    /**
     * Cambia el producto vendido en el objeto venta
     * @param productoVendido   Producto que compro el cliente.
     */    
    public void setProductoVendido(Producto productoVendido) {
        this.productoVendido = productoVendido;
    }

    /**
     * Cambia el cl cliene que compro el producto.
     * @param clienteCompro     Cliente que compro el producto.
     */    
    public void setClienteCompro(Cliente clienteCompro) {
        this.clienteCompro = clienteCompro;
    }

    /**
     * Cambia la fecha en la que se realizo una venta.
     * @param fechaCompra   Date que indica cuando se realizo la venta.
     */    
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Retorna el producto vendido al cliente.
     * @return  productoVendido  Producto vendido al cliente.
     */    
    public Producto getProductoVendido() {
        return productoVendido;
    }

    /**
     * Retorna el cliente que compro el producto.
     * @return clienteCompro Tipo cliente que compro el producto.
     */
    public Cliente getClienteCompro() {
        return clienteCompro;
    }

    /**
     * Retoprna la fecha en que se realizo la venta.
     * @return  fechaCompra
     */
    
    public Date getFechaCompra() {
        return fechaCompra;
    }
        
    @Override
    public String toString() {
        String strDateFormat  =": ss a dd-MMM-aaaa";
        SimpleDateFormat  objSDF = new SimpleDateFormat(strDateFormat);       
        return "Venta{" + "Producto=" + productoVendido + "cliente=" + clienteCompro + "fechaCompra=" +objSDF.format(fechaCompra)+'}';
    }        
    
    
    
    
    
}
