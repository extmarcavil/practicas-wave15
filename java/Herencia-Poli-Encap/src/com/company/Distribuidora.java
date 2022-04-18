package com.company;

public class Distribuidora {

    public static void main(String[] args) {
        // write your code here



        Producto producto = new Perecedero("Manzana", 2000.0, 2);
        //Producto producto1 = new Producto("Pera", 2000.0);
        Producto producto3 = new NoPerecedero("Manzana", 2000.0, "No Perecedero");
        //  Producto producto4 = new Perecedero("wdq", 3000.3, 3);
        //Producto producto5 = new NoPerecedero("Maqwenzana", 5500.0, "No Perecedero");

        Producto[] listaProductos = new Producto[2];

        listaProductos[0] = producto3;
        listaProductos[1] = producto;
        //listaProductos[2] = producto3;
        //listaProductos[3] = producto4;
        //listaProductos[4] = producto5;


        //System.out.println(producto1.calcular(5));

        System.out.println(producto.calcular(5));

        System.out.println(producto3.calcular(5));

        System.out.println(precioTotal(listaProductos));
    }

    public static double precioTotal(Producto[] listProducto) {
        double total = 0;
        for (int i=0; i < listProducto.length; i++) {
            total += listProducto[i].calcular(5);
        }
        return total;
    }
}
