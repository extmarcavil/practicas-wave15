package ejercicio2;

import java.util.ArrayList;

public class Distribuidora {

    public static void main (String[] args) {
        Producto producto1 = new Producto("Producto 1", 15);
        Producto producto2 = new Perecedero("Producto 2", 20, 2);
        Producto producto3 = new NoPerecedero("Producto 3", 35, "Tipo 1");
        Producto producto4 = new Perecedero("Producto 4", 80, 3);
        Producto producto5 = new NoPerecedero("Producto 5", 40, "Tipo 2");

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        productos.forEach((pr) -> {
            double total = pr.calcular(5);
            System.out.println("Precio del producto " + pr.getNombre() + " es " + total);
        });
    }
}
