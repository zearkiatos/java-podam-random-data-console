package com.example.podam;

import static org.junit.Assert.*;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class IntegrationTest {

    @Test
    public void test() {
        // Simplest scenario. Will delegate to Podam all decisions
        PodamFactory factory = new PodamFactoryImpl();

        // This will use constructor with minimum arguments and
        // then setters to populate POJO
        Cliente myPojo = factory.manufacturePojo(Cliente.class);
        Vendedor v = factory.manufacturePojo(Vendedor.class);
        ArticuloUnitario art = factory.manufacturePojo(ArticuloUnitario.class);

        System.out.println("-----------Entidades iniciales---------------");
        System.out.println(myPojo.toString());
        System.out.println(v.toString());
        System.out.println(art.toString());

        System.out.println("-----------Menu hipotético de la app---------------");
        System.out.println("ESTADO INICIAL:-----------------------------------");
        v.imprimirDisponibles();
        int longInicial = v.getDisponibles().size();
        v.ofrecer(art);

        myPojo.comprar(v.getDisponibles().get(0));
        v.vender(0);

        int longFinal = v.getDisponibles().size();

        System.out.println("ESTADO TRAS COMPRA/VENTA DE PRODUCTO:---------------------------");
        assertEquals(longInicial, longFinal);
        v.imprimirDisponibles();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Artículo en lista de vendidos del vendedor:");
        System.out.println(v.getVendidos());
        System.out.println("Artículo comprado por el cliente");
        System.out.println(myPojo.getCompras());

        assertEquals(v.getVendidos().get(0).toString(), myPojo.getCompras().get(0).getArticulos().get(0).toString());
    }
}