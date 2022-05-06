package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Mis Prendas.
         */
        Prenda camisa = new Prenda("nike", "camisa");
        Prenda pantalon = new Prenda("nike", "pantalon");
        Prenda gorra = new Prenda("nike", "gorra");

        Prenda camisa2 = new Prenda("nike", "camisa2");
        Prenda pantalon2 = new Prenda("nike", "pantalon2");
        Prenda gorra2 = new Prenda("nike", "gorra2");

        /**
         * Agregando Prendas a Mi lista de Prendas.
         */
        List<Prenda> miLista1 = new ArrayList<>();
        miLista1.add(camisa);
        miLista1.add(pantalon);
        miLista1.add(gorra);

        List<Prenda> miLista2 = new ArrayList<>();
        miLista2.add(camisa2);
        miLista2.add(pantalon2);
        miLista2.add(gorra2);

        GuardaRopa miGuardaRopa1 = new GuardaRopa();
        /**
         * Guardando mi lista de Prendas en mi GuardaRopa.
         */
        miGuardaRopa1.guardarPrendas(miLista1);
        miGuardaRopa1.guardarPrendas(miLista2);

        /**
         * Mostrando mi GuardaRopa.
         */
        miGuardaRopa1.mostrarPrenda();

        /**
         * Buscando mi lista de prendas.
         */
        System.out.println(miGuardaRopa1.devolverPrendas(2));
        //System.out.println(miGuardaRopa1.devolverPrendas(1));
    }
}
