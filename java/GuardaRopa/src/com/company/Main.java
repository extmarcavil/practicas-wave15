package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Prenda> prendas = new ArrayList<>(List.of(new Prenda("a", "b"), new Prenda("c", "d")));

        GuardaRopa gr = new GuardaRopa();
        int ticket = gr.guardarPrendas(prendas);

        System.out.println(ticket);

        gr.mostrarPrendas();
    }
}
