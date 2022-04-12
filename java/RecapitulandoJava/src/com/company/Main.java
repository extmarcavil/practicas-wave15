package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> listV = new ArrayList<Vehiculo>();
        Garaje garaje = new Garaje(1, listV);

        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Renault", 950);

        garaje.addVehiculo(v1);
        garaje.addVehiculo(v2);
        garaje.addVehiculo(v3);
        garaje.addVehiculo(v4);
        garaje.addVehiculo(v5);
        garaje.addVehiculo(v6);
        garaje.addVehiculo(v7);
        garaje.addVehiculo(v8);
        garaje.addVehiculo(v9);
        garaje.addVehiculo(v10);
        garaje.addVehiculo(v11);

        List<Vehiculo> listOrdenarCosto = garaje.getVehiculoList();

        System.out.println();
        listOrdenarCosto.stream()
                .sorted((x, y)->Integer.valueOf(x.getCosto()).compareTo(y.getCosto()))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("\nLista por marca:");
        List<Vehiculo> listaOrdenadaPorMarca = garaje.getVehiculoList();
        listaOrdenadaPorMarca.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

       // Lista ordenadas por cortoss
        System.out.println("Lista Ordenadas por costos menor a 1000");
        listOrdenarCosto.stream()
                .filter(x -> x.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Lista Ordenadas por costos mayor o igual a 1000");
        listOrdenarCosto.stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println();

        OptionalDouble prom = listOrdenarCosto.stream()
                .mapToDouble(x -> x.getCosto())
                .average();
        System.out.println("El promedio del costo es: " + prom.getAsDouble());
    }
}
