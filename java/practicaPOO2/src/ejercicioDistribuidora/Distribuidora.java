package ejercicioDistribuidora;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto perecederoMayorATres = new Perecedero("Leche", 160, 5);
        productos.add(perecederoMayorATres);

        Producto perecederoIgualATres = new Perecedero("Galletitas", 100, 3);
        productos.add(perecederoIgualATres);

        Producto perecederoIgualADos = new Perecedero("Azúcar", 110, 2);
        productos.add(perecederoIgualADos);

        Producto perecederoIgualAUno = new Perecedero("Yogurt", 135, 1);
        productos.add(perecederoIgualAUno);

        Producto noPeredero = new NoPerecedero("Arroz", 95, "Cereal");
        productos.add(perecederoIgualAUno);

        for (Producto producto : productos) {
            System.out.println(producto.toString());
            System.out.println("El precio del producto es $" + producto.calcular(5));
        }
    }
}
