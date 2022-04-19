package com.muchut.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> tabla = new ArrayList<Vehiculo>();
        tabla.add(new Vehiculo("Ford", "Fiesta", 1000));
        tabla.add(new Vehiculo("Ford", "Focus", 1200));
        tabla.add(new Vehiculo("Ford", "Explorer", 2500));
        tabla.add(new Vehiculo("Fiat", "Uno", 500));
        tabla.add(new Vehiculo("Fiat", "Cronos", 1000));
        tabla.add(new Vehiculo("Fiat", "Torino", 1250));
        tabla.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        tabla.add(new Vehiculo("Chevrolet", "Spin", 2500));
        tabla.add(new Vehiculo("Toyota", "Corolla", 1200));
        tabla.add(new Vehiculo("Toyota", "Fortuner", 3000));
        tabla.add(new Vehiculo("Renault", "Logan", 950));

        tabla.sort(Comparator.comparingInt(p -> p.getCosto()));
        System.out.println("Orden por Precio: " + tabla.toString());
        tabla.sort(Comparator.comparing((x,y) -> x.getMarca().compareToIgnoreCase(x.getMarca()))



    }

}
