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

    private static List<Cliente> Clientes = new ArrayList<Cliente>();

    private static List<Producto> productos = new ArrayList<Producto>();

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
        productos.add(new Producto(nombre, descripcion, precio, productos.size() + 1));

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
        System.out.println("Si LLEegamos");

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
                System.out.println("usuario confirmado identificacion e id : "+fg.getIdentificacion()+"y"+id);
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
        for (int i = 0; i < Clientes.size(); i++) {
            Cliente fr = Clientes.get(i);
            int temp = i;
            if (fr.getIdentificacion() == identificacion) {
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
        
        
        
        

    }

    @Override
    public void addProducClient(Integer idClient, Integer idproduct) {
        System.out.println("agregando productos");
        Cliente client=new Cliente();
        Producto produc=new Producto();
        
        for(Producto po: productos){           
            if(po.getId().equals(idproduct)){
                produc=po;                            
            }
        }              
        System.out.println("El productoe es: "+produc.getNombre());
        for(Cliente cl: Clientes){
            System.out.println("entrado en clientes");
            System.out.println("QUe compraramos "+cl.getIdentificacion());
            System.out.println("con "+idClient);
            
            if(cl.getIdentificacion().equals(idClient)){            
                cl.addProudcto(produc);
                System.out.println("El cliente es: "+cl.getNombre());
            }        
        }        
        
    }

    @Override
    public void clientPay(Integer identificacion) {
        System.out.println("imprimimos identificacion: "+identificacion);
        List<Producto>pro=new ArrayList<Producto>();
        
        for(Cliente cl: Clientes){
            if(cl.getIdentificacion().equals(identificacion)){
                pro=cl.getCarritoCompras();
                for(int i=0; i<pro.size();i++){
                    Producto d=pro.get(i);
                    cl.addHistorial(d);                                
                }
                cl.clearCarritoCompras();                
            }
        }
    }
}
