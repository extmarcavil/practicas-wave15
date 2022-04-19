package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Prenda prenda1;
        Prenda prenda2;
        Prenda prenda3;

        List<Prenda> listaprenda = new ArrayList<Prenda>();
        listaprenda.add(new Prenda("a", "o"));
        listaprenda.add(new Prenda("b", "p"));

        GuardaRopa g = new GuardaRopa();

        System.out.println();
        System.out.println("GUARDA ROPAS");
        System.out.println();

        Integer prendasGuardada = g.guardarPrendas(listaprenda);
        System.out.println("----- Mostrar las prendas del guarda ropa -----");
        g.mostrarPrendas();
        System.out.println();
        System.out.println("----- Devolver prendas del guarda ropa -----");
        List<Prenda> prendas = g.devolverPrendas(prendasGuardada);
        System.out.println();
        System.out.println("----- Mostrar las prendas del guarda ropa -----");
        g.mostrarPrendas();
        System.out.println("Se devolvieron todas las prendas");
        listaprenda.clear();
        System.out.println();
        System.out.println("----- Agregar prenda ----");
        listaprenda.add(new Prenda("c", "m"));
        g.guardarPrendas(listaprenda);
        System.out.println();
        System.out.println("----- Mostrar nuevamente las prendas del guarda ropa -----");
        g.mostrarPrendas();
    }
}
