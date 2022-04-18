package principal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Supermercado supermercado= new Supermercado("Super Paz");

        supermercado.agregarCliente("Valeria","Andino",11);
        supermercado.agregarCliente("Fabian","Quito",12);
        supermercado.agregarCliente("Noelia","Vera",13);
        System.out.println();

        System.out.println("Lista de tus clientes:");
        supermercado.listaClientes().forEach(System.out::println);
        supermercado.eliminarCliente(11);
        supermercado.listaClientes().forEach(System.out::println);
        System.out.println();

        supermercado.datosCliente(12);

        //--------Generar Factura--------
        Producto prod= new Producto(1,"galletitas oreo",3,250);
        Producto prod2= new Producto(2,"leche",2,150);
        List<Producto> productos= new ArrayList<>();
        productos.add(prod);
        productos.add(prod2);

        supermercado.agregarFactura(13,productos);






    }
}
