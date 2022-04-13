package HerenciaPolimorfismoYEncapsulamiento;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Coca-Cola", 100));
        productos.add(new Perecedero("Pepsi", 100, 2));
        productos.add(new NoPrecedero("Fanta", 100, "Bebida"));

        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println(producto.calcular(5));
        }
    }
}
