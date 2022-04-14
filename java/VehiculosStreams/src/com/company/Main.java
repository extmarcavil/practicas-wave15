package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void clasificadorMenorAMayor(Garaje vehiculos){

        List<Vehiculo> clasificacion = vehiculos.getVehiculos()
                .stream()
                .sorted((a,b) -> a.getCosto().compareTo(b.getCosto()))
                .collect(Collectors.toList());

        System.out.println(clasificacion);
    }

    public static void ordenadorMarcaCosto(Garaje garaje){

        Comparator<Vehiculo> comparator = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto);

         List<Vehiculo> clasificacion = garaje.getVehiculos().stream()
              .sorted(comparator).collect(Collectors.toList());

        System.out.println(clasificacion);

    }

    public static void menorPrecio(Garaje garaje){

        Predicate<Vehiculo> isMinorthan1000 = v ->  v.getCosto() < 1000;

        List<Vehiculo> menores = garaje.getVehiculos().stream()
                .filter(isMinorthan1000).collect(Collectors.toList());

        System.out.println(menores);
    }

    public static void mayorPrecio(Garaje garaje){

        Predicate<Vehiculo> isAbovethan1000 = v ->  v.getCosto() >= 1000;

        List<Vehiculo> mayores = garaje.getVehiculos().stream()
                .filter(isAbovethan1000).collect(Collectors.toList());

        System.out.println(mayores);
    }

    public static void promedio(Garaje garaje){

        garaje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average().ifPresent(System.out::println);
    }

    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("fiesta", "ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("focus", "ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("explorer", "ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("uno", "fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("aveo", "chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("spin", "chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("corola", "toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("fortuner", "toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("logan", "renault", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("De menores a mayores");
        clasificadorMenorAMayor(garaje);

        System.out.println("Ordenador Marca costo");
        ordenadorMarcaCosto(garaje);

        System.out.println("Menores a mil");
        menorPrecio(garaje);

        System.out.println("mayores o iguales a mil");
        mayorPrecio(garaje);

        System.out.println("Promedio");
        promedio(garaje);


    }
}
