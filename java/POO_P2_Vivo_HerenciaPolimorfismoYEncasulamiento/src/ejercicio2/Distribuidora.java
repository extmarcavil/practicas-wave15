package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Perecedero producto1 = new Perecedero("Tomate", 1500, 3);
        NoPerecedero producto2 = new NoPerecedero("Tv", 1000000, "Entretenimiento");
        productos.add(producto1);
        productos.add(producto2);
        productos.add(new Perecedero("Atun",4000,1));
        productos.add(new Perecedero("Arroz",3500,2));
        productos.add(new NoPerecedero("Silla",300000,"Mueble"));

        for (Producto p: productos) {
            System.out.println("Producto: "+ p.getNombre()+ " " +p.calcular(2));
        }

    }
}
