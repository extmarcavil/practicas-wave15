package com.muchut.dakar;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaAutosParaCorrer = new ArrayList<Vehiculo>();

        Carrera carrera1 = new Carrera(1000, 50000,4, "Formula1", listaAutosParaCorrer);

        carrera1.darDeAltaAuto(180, 100, 2, "123");
        carrera1.darDeAltaAuto(105, 100, 2, "1234");
        carrera1.darDeAltaAuto(120, 100, 2, "12345");
        carrera1.darDeAltaAuto(120, 100, 2, "123456");
        carrera1.darDeAltaAuto(100, 100, 2, "1234567");

        System.out.println(carrera1.ganadorDeCarrera());

    }
}
