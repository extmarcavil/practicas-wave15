package com.company;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Perecedero perecedero1 = new Perecedero("Leche", 100, 1);
        Perecedero perecedero2 = new Perecedero("Queso", 300, 2);
        Perecedero perecedero3 = new Perecedero("Crema", 240.4, 3);
        Perecedero perecedero4 = new Perecedero("Yogur", 70.5, 4);

        NoPerecedero noPerecedero1 = new NoPerecedero("Fideos moño", 40, "fideos");

        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(noPerecedero1);

        double precioTotal = 0;

        for (Producto p : productos) {
            System.out.println("Agregando el monto de 5 " + p);
            precioTotal += p.calcular(5);
        }

        System.out.println("Precio total de la venta: " + precioTotal);
    }
}
