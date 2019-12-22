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

    private static List<Cliente> Clientes = new ArrayList<Cliente>();

    private static List<Producto> productos = new ArrayList<Producto>();
    
    private static List<Venta> ventas=new ArrayList<Venta>();

    private Cliente cl;
    private static Tienda mi;

    /**
     *
     */
    public TiendaStub() throws TiendaException {
        
        addProducClient(987,4);
        addProducClient(987,10);
        addProducClient(987,5);  //      
        addProducClient(654,1);
        addProducClient(654,2);
        addProducClient(654,3);
        addProducClient(654,4);        
        addProducClient(321,6);    //    
        addProducClient(879,1);
        addProducClient(879,3);
        addProducClient(879,5);
        addProducClient(879,7);
        addProducClient(879,9);
        //Clientes Pagando
        clientPay(987);
        clientPay(654);
        clientPay(879);
        //Volviendo a comprar
        addProducClient(879,2);
        addProducClient(879,4);        

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
        try {
            productos.add(new Producto(nombre, descripcion, precio, productos.size() + 1));
        } catch (TiendaException ex) {
            Logger.getLogger(TiendaStub.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param id
     * @return
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
     *
     * @param nombre
     * @param descripcion
     * @param precio
     * @param id
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
     *
     * @param id
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
     *
     * @param nombre
     */
    @Override
    public void CreateClient(String nombre, Integer identificacion) {
        
        cl = new Cliente(nombre, identificacion);
        Clientes.add(cl);

    }

    /**
     *
     * @return
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
     *
     * @param nombre
     * @param identificacion
     * @param HistorialCompras
     * @param CarritoCompras
     */
    @Override
    public void changeCliente(String nombre, Integer identificacion) {
        for (Cliente to : Clientes) {
            if (to.getIdentificacion().equals( identificacion)) {
                to.setIdentificacion(identificacion);
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
        for (int i = 0; i < Clientes.size(); i++) {
            Cliente fr = Clientes.get(i);
            int temp = i;
            if (fr.getIdentificacion().equals(identificacion)) {
                Clientes.remove(temp);
            }
        }
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

    @Override
    public List<Producto> getAllProduct() {
        return productos;
    }

    @Override
    public List<Cliente> getAllClient() {
        return Clientes;
    }

    static {
        
        try {
            //String nombre, String descripcion,Integer precio, Integer id
            mi = TiendaServices.CreateTienda("Mi Iingrersos Hits");
            Producto p0 = new Producto("Comedor","Mesa de madera con 6 puestos",10000,1);
            Producto p1 = new Producto("Televisor led 40 pulgadas","Televisor marca lg ",10500,2);
            Producto p2 = new Producto("Microndas","Microondas marca Kalley",15000,3);
            Producto p3 = new Producto("Moto One","Celular motorola ONE 65gb memoria interna",20000,4);
            Producto p4 = new Producto("SetEscolar","Un kit completo para el inicio de año para el estudiante",25000,5);
            Producto p5 = new Producto("Cafetera","Cafetera electrica",300000,6);
            Producto p6 = new Producto("Arbol de navidad","Arbol en madera natural con 2 metros de altura",35000,7);
            Producto p7 = new Producto("Computador Asus ","Computador liviano para poca carga. ",400000,8);
            Producto p8 = new Producto("PlayStation1","Cosnola de video juegos retro ",50000,9);
            Producto p9 = new Producto("PlayStation 44","Consola de videoJuegos de uiltima generacion",2650000,10);
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
            Cliente c1=new Cliente("Ramiro",987);
            Cliente c2=new Cliente("Erick",654);
            Cliente c3=new Cliente("Andres",321);
            Cliente c4=new Cliente("Lincy",879);
            Clientes.add(c1);
            Clientes.add(c2);
            Clientes.add(c3);
            Clientes.add(c4);
            //Clientes Comprando Productos
            
            
            
        } catch (TiendaException ex) {
            Logger.getLogger(TiendaStub.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        

    }

    @Override
    public void addProducClient(Integer idClient, Integer idproduct) {
        Cliente client=new Cliente();
        Producto produc=new Producto();
        
        for(Producto po: productos){           
            if(po.getId().equals(idproduct)){
                produc=po;                            
            }
        }              
        for(Cliente cl: Clientes){            
            if(cl.getIdentificacion().equals(idClient)){            
                cl.addProudcto(produc);
            }        
        }        
        
    }

    @Override
    public void clientPay(Integer identificacion) {
        List<Producto>pro=new ArrayList<Producto>();
        
        for(Cliente cl: Clientes){
            if(cl.getIdentificacion().equals(identificacion)){
                pro=cl.getCarritoCompras();
                for(int i=0; i<pro.size();i++){
                    Producto d=pro.get(i);
                    cl.addHistorial(d);     
                    ventas.add(new Venta(d,cl));
                }
                cl.clearCarritoCompras();                
            }
        }
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventas;
    }
}
