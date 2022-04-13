package com.company.clases;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new Perecedero(3, 12, "jabon");
        productos[1] = new NoPerecedero("comestible", 15, "papas");
        productos[2] = new Perecedero(2, 15, "manteca");
        productos[3] = new Producto("papas", 15);
        productos[4] = new Perecedero(1, 12, "detergente");
        for (Producto p : productos) {
            System.out.println(p.calcular(1));
        }
    }
}
