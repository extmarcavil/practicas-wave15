package ejercicioDistribuidora;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        Producto p1 = new Perecedero("Pan de viena", 60, 4);
        Producto p2 = new Perecedero("Leche", 100, 2);
        Producto p3 = new Perecedero("Queso", 400, 3);
        Producto p4 = new Perecedero("Dulce de leche", 200, 100);
        Producto p5 = new Perecedero("Carne", 1000, 1);

        Producto p6 = new NoPerecedero("Fideos", 60, "Pasta");
        Producto p7 = new NoPerecedero("Arroz", 100, "Arroz");
        Producto p8 = new NoPerecedero("Te", 50, "Desayuno");
        Producto p9 = new NoPerecedero("Yerba", 350, "Desayuno");
        Producto p10 = new NoPerecedero("Azucar", 110, "Endulzante");

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);
        listaProductos.add(p7);
        listaProductos.add(p8);
        listaProductos.add(p9);
        listaProductos.add(p10);

        double total = 0;

        for (Producto producto : listaProductos) {
            System.out.println("\n" + producto.toString());
            int cantidad = (int) Math.floor(Math.random() * 5 + 1);
            double subtotalProductos = producto.calcular(cantidad);
            System.out.println("Cantidad: " + cantidad + " Total producto $" + subtotalProductos);
            total += subtotalProductos;
        }

        System.out.println("\nTotal compra $" + total);
    }
}
