package com.seriesNumericas;

import com.seriesNumericas.model.Prototipo;
import com.seriesNumericas.model.Prototipo1;

public class Main {

    public static void main(String[] args) {
        Prototipo prototipo = new Prototipo1();
        System.out.println("\nSerie de 2.\n");
        prototipo.setSerie(2);
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());

        System.out.println("\nReiniciando serie.");
        prototipo.reiniciarSerie();
        System.out.println("Cambiando valor inicial a 1.\n");
        prototipo.valorInicial(1);
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());
        System.out.println(prototipo.siguienteValor());

        Prototipo prototipo2 = new Prototipo1();
        System.out.println("\nReiniciando serie.");
        prototipo2.reiniciarSerie();
        System.out.println("Serie de 3 y valor inicial 1.\n");
        prototipo2.setSerie(2.5f);
        System.out.println(prototipo2.siguienteValor());
        System.out.println(prototipo2.siguienteValor());
        System.out.println(prototipo2.siguienteValor());
        System.out.println(prototipo2.siguienteValor());
    }
}
