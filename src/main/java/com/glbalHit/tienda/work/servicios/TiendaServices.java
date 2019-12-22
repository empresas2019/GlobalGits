/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glbalHit.tienda.work.servicios;

import com.glbalHit.tienda.work.model.Cliente;
import com.glbalHit.tienda.work.model.Producto;
import com.glbalHit.tienda.work.model.Tienda;
import com.glbalHit.tienda.work.model.Venta;
import java.util.List;

/**
 *
 * @author Cefar -- Dicomatico
 */
public interface TiendaServices {
    
    /**
     * Este metodo estatico crea una instancia unica de la tienda
     * @param nombre    Objeto String que indica el  nombre de la tienda.
     * @return tienda   Retorna un objeto tienda que representa la tienda creada.
     */    
    public static Tienda CreateTienda(String nombre){
        return Tienda.getTienda(nombre);
    }
    
    /**
     * Este metodo crea un producto en la tienda.
     * @param nombre    Un objeto String que indica el nombre del producto.
     * @param descripcion   Un objeto String que indica la descripcion deel producto.
     * @param precio    Un objeto Integer que indica el precio del producto.
     * @param id    Un objeto Integer que indica el identificador del producro.
     */
    public void CreateProduct(String nombre, String descripcion,Integer precio, Integer id);
    
    /**
     * Este metodo devuielve un producto con el identificador pasado como parametro.
     * @param id    Objeto Integer que representa el identificador del producto que sera entregado.
     * @return producto Objeto producto con el identificador pasado como parametro.
     */
    public Producto getProduct(Integer id);
    
    /**
     * Retorna una lista con todos los productos del almacen.
     * @return productos Lista de productos en el almacen.
     */    
    public List<Producto> getAllProduct();
    
    /**
     * Este metodo cambia los parametros del producto.
     * @param nombre    String que representa el nueuvo nombre del producto.
     * @param descripcion   String que representa la nueuva descripcion del producto. 
     * @param precio    Integer que representa el nuevo precio deel producto.
     * @param id    Integer que indica el identificador del producto.
     */    
    public void changeProduct(String nombre, String descripcion,Integer precio, Integer id);
    
    /**
     * Este metodo elimina el producto.
     * @param id    Integer Es el identificador del objeto a eliminar.
     */    
    public void EraseProduct( Integer id);
    
    /**
     * Este metodo retorna el tamaño de la lista de productos
     * @return  Integer Retorna un entero con el valor de la lista de productos.
     */    
    public Integer getSiceProduct();        
    //public Cliente CreateClient(String nombre, Integer identificacion);
    
    /**
     * Este metodo crea un nuevo cliente en el almacen.
     * @param nombre    String que representa el nombre del nueuvo cliente.
     * @param identificacion    Integer que representa el identifcador del nuevo cliente.
     */    
    public void CreateClient(String nombre, Integer identificacion);
    
    /**
     * Este metodo retorna un objeto cliente con el identificador pasado como parametro.
     * @param id    Integer Representa el identificador del cliente a buscar
     * @return  cliente Objeto que tiene como identificador el parametro pasado. 
     */    
    public Cliente getClient(Integer id);
    
    /**
     * Retorna todos los clientes del almacen.
     * @return clientes Lista de clientes que almacena todos los clientes del almacen.
     */    
    public List<Cliente> getAllClient();
    
    /**
     * Este metodo adiciona un producto con un id a un cliente determinado
     * @param idClient    Integer Un entero que representa el cliente al que se le adicionara el(los) productos.
     * @param idproduct     Integer Un entero que representa el identificador del producto a adicionar. 
     */    
    public  void addProducClient(Integer idClient, Integer idproduct);
    //public void changeCliente(String nombre, Integer identificacion,List<Producto> HistorialCompras,List<Producto> CarritoCompras);
    
    /**
     * Este metodo cambia el estado del cliente identificada con el identificador.
     * @param nombre    String Representa el nuevo nombre cliente.
     * @param identificacion    Integer Representa el identificador deel cliente.
     */    
    public void changeCliente(String nombre, Integer identificacion);
    
    /**
     * Este metodo elimina el cliente con el id de identificacion.
     * @param identificacion    Integer Entero que representa el identificador del cliente a eliminar. 
     */    
    public void eraseClient(Integer identificacion);
    
    /**
     * Este metodo indica que el cliente con el id de identificacion ha pagado su carrito de compras.
     * @param identificacion    Integer El identificador del cliente que ha pagado el carrito de compras.
     */    
    public void clientPay(Integer identificacion);
    
    /**
     * Este metodo genera un reporte donde el administrador puede revisar las ventas del almacen.
     * @param fechaIn   String Fecha de inicio de la busqueda.
     * @param fechaFin  String Fecha de fin de la busqueda.
     * @return reporter String Representa el informe del almacen.
     */    
    public String GeneratorReporter(String fechaIn,String fechaFin);
    //ventas
    
    /**
     * Retorna todas las ventas del almacen.
     * @return ventas Objeto de Lista de tipo de ventas que contiene todas las ventas del alamcen.
     */    
    public List<Venta> getAllVentas();
       
}
