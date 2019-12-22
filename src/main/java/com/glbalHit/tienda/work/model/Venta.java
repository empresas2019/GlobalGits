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


    public Venta(){}
    
    public Venta(Producto productoVendido, Cliente clienteCompro){
        this.productoVendido=productoVendido;
        this.clienteCompro=clienteCompro;
        fechaCompra=new Date();
        //fechaCompra=new Date(d.getDay(),d.getMonth(),d.getDate());
    
    }

    public void setProductoVendido(Producto productoVendido) {
        this.productoVendido = productoVendido;
    }

    public void setClienteCompro(Cliente clienteCompro) {
        this.clienteCompro = clienteCompro;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Producto getProductoVendido() {
        return productoVendido;
    }

    public Cliente getClienteCompro() {
        return clienteCompro;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }
    

    
    @Override
    public String toString() {
        //return "Venta{" + "Producto=" + productoVendido + "cliente=" + clienteCompro + "fechaCompra=" +objSDF.format(fechaCompra) +'}';
        String strDateFormat  =": ss a dd-MMM-aaaa";
        SimpleDateFormat  objSDF = new SimpleDateFormat(strDateFormat);
       
        return "Venta{" + "Producto=" + productoVendido + "cliente=" + clienteCompro + "fechaCompra=" +objSDF.format(fechaCompra)+'}';
    }        
    
    
    
    
    
}
