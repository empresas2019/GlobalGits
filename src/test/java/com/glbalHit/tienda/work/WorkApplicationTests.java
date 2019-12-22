package com.glbalHit.tienda.work;

import com.glbalHit.tienda.work.model.Cliente;
import com.glbalHit.tienda.work.model.Producto;
import com.glbalHit.tienda.work.servicios.TiendaException;
import com.glbalHit.tienda.work.servicios.TiendaServices;
//import org.assertj.core.api.Assert;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkApplicationTests {

    @Autowired
    private TiendaServices td;
    
    
    @Test
    public void addClientTest() throws TiendaException{    
        td.CreateClient("pepe", 1234569);
        td.CreateClient("pepa", 12);
        td.CreateClient("maria", 99);
        td.CreateClient("maria", 99);
        Assert.assertEquals(8,td.getAllClient().size());
    
    }
           
    @Test
    public void addProductTest() {
        td.CreateProduct("Pistola de agua", "Para una tarde en la playa", 11123, 11133);
        td.CreateProduct("arma de fuego", "Para protegere su vida", 11124, 11134);
        td.CreateProduct("Picina Inflable", "Para disfrutar de una psicina en la comodidad de su casa", 11125, 11135);
        td.CreateProduct("Silla", "Para sentarse", 11126, 11136);
        Assert.assertEquals(14,td.getAllProduct().size());
    }

    @Test
    public void changeProductTest(){        
        Producto t=new Producto();
        t=td.getProduct(3);
        t.setNombre("nuevo");
        t.setDescripcion("nuevadesc");
        t.setPrecio(1111);
        td.changeProduct(t.getNombre(),t.getDescripcion(), t.getPrecio(), t.getId());        
         Assert.assertEquals(t,td.getProduct(3));       
    }
    
    @Test
    public void changeClientTest(){        
        Cliente t= td.getClient(879);                
        t.setNombre("nuevoqqq");
        td.changeCliente(t.getNombre(), t.getIdentificacion());      
        Assert.assertEquals(t,td.getClient(879));      
    }
    
}
