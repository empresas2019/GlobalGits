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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private static List<Cliente> Clientes = new ArrayList<Cliente>();

    private static List<Producto> productos = new ArrayList<Producto>();

    private static List<Venta> ventas = new ArrayList<Venta>();
    private static List<Date> fechas = new ArrayList<Date>();

    private Cliente cl;
    private static Tienda mi;
    private SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");

    public TiendaStub() throws TiendaException, ParseException {
        List<Date> prueba = new ArrayList<Date>();
        addProducClient(987, 4);
        addProducClient(987, 10);
        addProducClient(987, 5);  //      
        addProducClient(654, 1);
        addProducClient(654, 2);
        addProducClient(654, 3);
        addProducClient(654, 4);
        addProducClient(321, 6);    //    
        addProducClient(879, 1);
        addProducClient(879, 3);
        addProducClient(879, 5);
        addProducClient(879, 7);
        addProducClient(879, 9);
        //Clientes Pagando
        clientPay(987);
        clientPay(654);
        clientPay(879);
        //Volviendo a comprar
        addProducClient(879, 2);
        addProducClient(879, 4);
        //Cambiando fechas
        Date f1 = objSDF.parse("10-12-2010");
        Date f2 = objSDF.parse("11-01-2011");
        Date f3 = objSDF.parse("12-02-2013");
        Date f4 = objSDF.parse("13-03-2014");
        Date f5 = objSDF.parse("14-04-2015");
        Date f6 = objSDF.parse("15-05-2016");
        Date f7 = objSDF.parse("16-06-2017");
        Date f8 = objSDF.parse("17-07-2018");
        Date f9 = objSDF.parse("18-08-2019");
        prueba.add(f1);
        prueba.add(f2);
        prueba.add(f3);
        prueba.add(f4);
        prueba.add(f5);
        prueba.add(f6);
        prueba.add(f7);
        prueba.add(f8);
        prueba.add(f9);        
        fechas.clear();
        fechas.add(f1);
        fechas.add(f2);
        fechas.add(f3);
        fechas.add(f4);
        fechas.add(f5);
        fechas.add(f6);
        fechas.add(f7);
        fechas.add(f8);
        fechas.add(f9);
        System.out.println("el tamaño redes :" + fechas.size());
        for (int i = 0; i < prueba.size(); i++) {

            Venta ve = ventas.get(i);
            ve.setFechaCompra(prueba.get(i));
        }
    }

    /**
     * Este metodo crea un producto en la tienda.
     *
     * @param nombre Un objeto String que indica el nombre del producto.
     * @param descripcion Un objeto String que indica la descripcion deel
     * producto.
     * @param precio Un objeto Integer que indica el precio del producto.
     * @param id Un objeto Integer que indica el identificador del producro.
     *
     */
    @Override
    public void CreateProduct(String nombre, String descripcion, Integer precio, Integer id) {
        try {
            productos.add(new Producto(nombre, descripcion, precio, productos.size() + 1));
        } catch (TiendaException ex) {
            Logger.getLogger(TiendaStub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo devuielve un producto con el identificador pasado como
     * parametro.
     * @param id Objeto Integer que representa el identificador del producto que
     * sera entregado.
     * @return producto Objeto producto con el identificador pasado como
     * parametro.
     */
    @Override
    public Producto getProduct(Integer id) {
        Producto pro = new Producto();
        for (Producto pr : productos) {
            if (pr.getId().equals(id)) {
                pro = pr;
            }
        }
        return pro;
    }

    /**
     * Este metodo cambia los parametros del producto.
     * @param nombre String que representa el nueuvo nombre del producto.
     * @param descripcion String que representa la nueuva descripcion del
     * producto.
     * @param precio Integer que representa el nuevo precio deel producto.
     * @param id Integer que indica el identificador del producto.
     */
    @Override
    public void changeProduct(String nombre, String descripcion, Integer precio, Integer id) {
        for (Producto pr : productos) {
            if (pr.getId().equals(id)) {
                pr.setDescripcion(descripcion);
                pr.setNombre(nombre);
                pr.setPrecio(precio);
            }
        }
    }

    /**
     * Este metodo elimina el producto.
     * @param id Integer Es el identificador del objeto a eliminar.
     */
    @Override
    public void EraseProduct(Integer id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto temp = productos.get(i);
            int te = i;
            if (temp.getId() == id) {
                productos.remove(i);
            }
        }
    }

    /**
     * Este metodo crea un nuevo cliente en el almacen.
     *
     * @param nombre String que representa el nombre del nueuvo cliente.
     * @param identificacion Integer que representa el identifcador del nuevo
     * cliente.
     */
    @Override
    public void CreateClient(String nombre, Integer identificacion) {

        cl = new Cliente(nombre, identificacion);
        Clientes.add(cl);

    }

    /**
     * Este metodo retorna un objeto cliente con el identificador pasado como
     * parametro.
     *
     * @param id Integer Representa el identificador del cliente a buscar
     * @return cliente Objeto que tiene como identificador el parametro pasado.
     */
    @Override
    public Cliente getClient(Integer id) {
        Cliente ci = new Cliente();
        for (Cliente fg : Clientes) {
            if (fg.getIdentificacion().equals(id)) {
                ci = fg;
            }
        }
        return ci;
    }

    /**
     * Este metodo cambia el estado del cliente identificada con el
     * identificador.
     *
     * @param nombre String Representa el nuevo nombre cliente.
     * @param identificacion Integer Representa el identificador deel cliente.
     */
    @Override
    public void changeCliente(String nombre, Integer identificacion) {
        for (Cliente to : Clientes) {
            if (to.getIdentificacion().equals(identificacion)) {
                to.setIdentificacion(identificacion);
                to.setNombre(nombre);
            }
        }
    }

    /**
     * Este metodo elimina el cliente con el id de identificacion.
     *
     * @param identificacion Integer Entero que representa el identificador del
     * cliente a eliminar.
     */
    @Override
    public void eraseClient(Integer identificacion) {
        for (int i = 0; i < Clientes.size(); i++) {
            Cliente fr = Clientes.get(i);
            int temp = i;
            if (fr.getIdentificacion().equals(identificacion)) {
                Clientes.remove(temp);
            }
        }
    }

    /**
     * Este metodo retorna el tamaño de la lista de productos
     *
     * @return Integer Retorna un entero con el valor de la lista de productos.
     */
    @Override
    public Integer getSiceProduct() {
        return productos.size();
    }

    /**
     * Retorna una lista con todos los productos del almacen.
     *
     * @return productos Lista de productos en el almacen.
     */
    @Override
    public List<Producto> getAllProduct() {
        return productos;
    }

    /**
     * Retorna todos los clientes del almacen.
     *
     * @return clientes Lista de clientes que almacena todos los clientes del
     * almacen.
     */
    @Override
    public List<Cliente> getAllClient() {
        return Clientes;
    }

        /**
     * Este metodo indica que el cliente con el id de identificacion ha pagado
     * su carrito de compras.
     *
     * @param identificacion Integer El identificador del cliente que ha pagado
     * el carrito de compras.
     */
    @Override
    public void clientPay(Integer identificacion) {
        List<Producto> pro = new ArrayList<Producto>();
        Date de = new Date();
        for (Cliente cl : Clientes) {
            if (cl.getIdentificacion().equals(identificacion)) {
                pro = cl.getCarritoCompras();
                for (int i = 0; i < pro.size(); i++) {
                    Producto d = pro.get(i);
                    cl.addHistorial(d);
                    ventas.add(new Venta(d, cl));
                    fechas.add(new Date());
                    //fechas.add(new Date(de.getDay(),de.getMonth(),de.getDate()));
                }
                cl.clearCarritoCompras();
            }
        }
    }

    /**
     * Retorna todas las ventas del almacen.
     *
     * @return ventas Objeto de Lista de tipo de ventas que contiene todas las
     * ventas del alamcen.
     */
    @Override
    public List<Venta> getAllVentas() {
        return ventas;
    }

    /**
     * Retorna todas las fechas en que se realizaron ventas
     *
     * @return fechas
     */
    @Override
    public List<Date> getAllFechas() {
        return fechas;
    }
    
    /**
     * Este metodo adiciona un producto con un id a un cliente determinado
     *
     * @param idClient Integer Un entero que representa el cliente al que se le
     * adicionara el(los) productos.
     * @param idproduct Integer Un entero que representa el identificador del
     * producto a adicionar.
     */
    @Override
    public void addProducClient(Integer idClient, Integer idproduct) {
        Cliente client = new Cliente();
        Producto produc = new Producto();
        for (Producto po : productos) {
            if (po.getId().equals(idproduct)) {
                produc = po;
            }
        }
        for (Cliente cl : Clientes) {
            if (cl.getIdentificacion().equals(idClient)) {
                cl.addProudcto(produc);
            }
        }
    }
    static {
        try {
            //String nombre, String descripcion,Integer precio, Integer id
            mi = TiendaServices.CreateTienda("Mi Iingrersos Hits");
            Cliente c1 = new Cliente("Ramiro", 987);
            Cliente c2 = new Cliente("Erick", 654);
            Cliente c3 = new Cliente("Andres", 321);
            Cliente c4 = new Cliente("Lincy", 879);
            Clientes.add(c1);
            Clientes.add(c2);
            Clientes.add(c3);
            Clientes.add(c4);
            Producto p0 = new Producto("Comedor", "Mesa de madera con 6 puestos", 10000, 1);
            Producto p1 = new Producto("Televisor led 40 pulgadas", "Televisor marca lg ", 10500, 2);
            Producto p2 = new Producto("Microndas", "Microondas marca Kalley", 15000, 3);
            Producto p3 = new Producto("Moto One", "Celular motorola ONE 65gb memoria interna", 20000, 4);
            Producto p4 = new Producto("SetEscolar", "Un kit completo para el inicio de año para el estudiante", 25000, 5);
            Producto p5 = new Producto("Cafetera", "Cafetera electrica", 300000, 6);
            Producto p6 = new Producto("Arbol de navidad", "Arbol en madera natural con 2 metros de altura", 35000, 7);
            Producto p7 = new Producto("Computador Asus ", "Computador liviano para poca carga. ", 400000, 8);
            Producto p8 = new Producto("PlayStation1", "Cosnola de video juegos retro ", 50000, 9);
            Producto p9 = new Producto("PlayStation 44", "Consola de videoJuegos de uiltima generacion", 2650000, 10);
            productos.add(p0);
            productos.add(p1);
            productos.add(p2);
            productos.add(p3);
            productos.add(p4);
            productos.add(p5);
            productos.add(p6);
            productos.add(p7);
            productos.add(p8);
            productos.add(p9);
            //Clientes
            //Clientes Comprando Productos
        } catch (TiendaException ex) {
            Logger.getLogger(TiendaStub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
