package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Distribuidora prod = new Distribuidora();
        Perecedero leche = new Perecedero(1);
        leche.setNombre("Colanta");
        leche.setPrecio(12);
        System.out.println(leche.toString());
        prod.producto.add(1,leche);


    }
}
