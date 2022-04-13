package com.muchut.savetheropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas", "modeloAdidas");
        Prenda prenda2 = new Prenda("Adidas", "modeloAdidas2");
        Prenda prenda3 = new Prenda("Adidas", "modeloAdidas3");
        Prenda prenda4 = new Prenda("Adidas", "modeloAdidas4");

        List<Prenda> prendas = new ArrayList<Prenda>();

        prendas.add(prenda1);
        prendas.add(prenda2);

        GuardaRopa gropa = new GuardaRopa();
        int clave = gropa.guardarPrendas(prendas);
        gropa.mostrarPrendas();

        System.out.println("La prenda solicitada: " + gropa.devolverPrendas(clave));

    }
}
