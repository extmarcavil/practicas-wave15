package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /**
         * Mi lista de Vehiculos
         */
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("ford", "fiesta", 1000));
        vehiculos.add(new Vehiculo("ford", "focus", 1200));
        vehiculos.add(new Vehiculo("ford", "explorer", 2500));
        vehiculos.add(new Vehiculo("fiat", "uno", 500));
        vehiculos.add(new Vehiculo("fiat", "cronos", 1000));
        vehiculos.add(new Vehiculo("fiat", "torino", 1250));
        vehiculos.add(new Vehiculo("chevrolet", "aveo", 1250));
        vehiculos.add(new Vehiculo("chevrolet", "spin", 2500));
        vehiculos.add(new Vehiculo("toyota", "corolla", 1200));
        vehiculos.add(new Vehiculo("toyota", "fortuner", 3000));
        vehiculos.add(new Vehiculo("renault", "logan", 950));


        /**
         * Mi Garaje con vehiculos
         */
        Garaje miGaraje = new Garaje(1, vehiculos);

        /**
         * Ejercicio 3.
         * Ordenando mi lista de vehiculos por precio de menor a mayor utilizando el metodo SORT().
         * Utilizando la lista de vehiculos que estan en mi Graje
         */
        miGaraje.getListaDeVehiculos().sort(Vehiculo::compareTo);
        //miGaraje.getListaDeVehiculos().sort((vehiculoX, vehiculoY) -> vehiculoX.compareTo(vehiculoY));
        miGaraje.getListaDeVehiculos().forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("\n=========================================================\n");

        miGaraje.getListaDeVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        /**
         * Ejercicio 4
         * Imprimiendo una lista ordenada por modelo y por precio.
         */
        //miGaraje.getListaDeVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        miGaraje.getListaDeVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing((vehiculo1, vehiculo2) -> vehiculo1.compareTo(vehiculo2)));
        miGaraje.getListaDeVehiculos().forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("\n=========================================================\n");

        /**
         * Ejercicio 5
         * 1. Extraer lista de vehiculos con precio <1000
         * 2. Extraer lista con precios >=1000
         * 3. Obtener el promedio total de precios de la lista.
         */
        //1.
        miGaraje.getListaDeVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("\n=========================================================\n");

        //2.
        miGaraje.getListaDeVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("\n=========================================================\n");

        //3.
        miGaraje.getListaDeVehiculos().stream().mapToInt(x -> (int) x.getCosto()).average().stream().forEach(x -> System.out.println(x));

        System.out.println("\n=========================================================\n");

        miGaraje.getListaDeVehiculos().stream().mapToDouble(x -> x.getCosto()).average().stream().forEach(x -> System.out.println(x));

        System.out.println("\n=========================================================\n");

        double valor = miGaraje.getListaDeVehiculos().stream().mapToDouble(x -> x.getCosto()).sum();
        System.out.println(valor / miGaraje.getListaDeVehiculos().size());
    }
}
