package com.company.santiagopinzondev;

public class Distribuidora {

    public static void main(String[] args) {
        Producto productos[] = new Producto[5];

        productos[0] = new Perecedero("Salamin", 150.75, 2);
        productos[1] = new NoPerecedero("Arroz", 100.25, "Carbohidrato");
        productos[2] = new Perecedero("Queso", 300.15, 3);
        productos[3] = new NoPerecedero("Fideos", 150.75, "Spaghetti");
        productos[4] = new Perecedero("Yoghurt", 150.75, 1);

        double total = 0;

        for (Producto producto : productos) {
            total += producto.calcular(1);
        }

        System.out.println("Total de la compra: $" + total);
    }
}
