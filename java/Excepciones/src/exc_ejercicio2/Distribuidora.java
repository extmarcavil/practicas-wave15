package exc_ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto p1 = new Perecedero("Carne", 12.6,2);
        productos.add(p1);
        Producto p2 = new NoPerecedero("Kellows", 5.7, "Cereal");
        productos.add(p2);

        for (Producto p : productos) {
            System.out.println(p.calcular(5));
            System.out.println(p);
        }
    }
}
