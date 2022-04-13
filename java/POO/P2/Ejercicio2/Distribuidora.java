package POO.P2.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();
        double precioTotal = 0;

        productos.add(new Perecedero("tomate", 200, 3));
        productos.add(new Perecedero("carne", 2000, 4));
        productos.add(new NoPerecedero("gaseosa", 300, "Bebida"));
        productos.add(new NoPerecedero("pollo", 1500, "Alimento"));
        productos.add(new NoPerecedero("banana", 200, "Alimento"));

        for (Producto producto : productos) {
            precioTotal += producto.calcular(1);
        }

        System.out.println("El precio total es $" + precioTotal);
    }
}
