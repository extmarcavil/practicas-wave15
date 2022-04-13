package herencia;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productoList = new ArrayList<Producto>();

        productoList.add(new NoPerecedero("Arroz" , 60, "Almidon"));
        productoList.add(new NoPerecedero("Fideos" , 30, "Almidon"));
        productoList.add(new NoPerecedero("Polenta" , 100, "Harina"));


        productoList.add(new Perecedero("Salchichas" , 80, 2));
        productoList.add(new Perecedero("Queso Crema" , 250, 3));
        productoList.add(new Perecedero("Leche Descremada" , 120, 1));

        for (Producto p: productoList) {
            System.out.println("El precio del producto " + p.getNombre() + " es: " + p.getPrecio());
        }

        Perecedero perecederoProducto = new Perecedero("Hamburguesa Congelada", 80, 2);
        NoPerecedero noPerecederoProducto = new NoPerecedero("Lentejas", 100, "almidon");
        System.out.println("-----------------------------------------------------------");
        System.out.println("El precio calculado del alimento perecedero " + perecederoProducto.getNombre() + " es: " + perecederoProducto.calcular(4));
        System.out.println("El precio calculado del alimento no perecerdo " + noPerecederoProducto.getNombre()+ " es: " + noPerecederoProducto.calcular(4));


    }
}
