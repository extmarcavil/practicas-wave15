package distribuidoraProductos;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Queso", 300, 2));
        productos.add(new Perecedero("Salamin", 200, 3));
        productos.add(new Perecedero("Yoghurt", 150, 7));
        productos.add(new Perecedero("Leche", 140, 1));
        productos.add(new Perecedero("Pan", 280, 2));

        productos.add(new NoPerecedero("Arroz", 130, "Cereal"));
        productos.add(new NoPerecedero("Arvejas", 180, "Enlatado"));
        productos.add(new NoPerecedero("Fideos", 80, "Pasta Seca"));
        productos.add(new NoPerecedero("Garbanzos", 140, "Enlatado"));
        productos.add(new NoPerecedero("Pure Chef", 150, "Deshidratado"));

        double precioTotal = 0;

        for (Producto p : productos) {
            precioTotal += p.calcular(5);
        }

        System.out.println("El precio final es de $" + precioTotal);
    }
}
