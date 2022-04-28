package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    Garaje unGara = new Garaje(1);
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehicles = new ArrayList<>(){{
            add(v1);add(v2);add(v3);add(v4);add(v5);add(v6);add(v7);add(v8);add(v9);add(v10);add(v11);
        }};
        unGara.getVehiculos().addAll(vehicles);


        Comparator<Vehiculo> sortByPrice = Comparator.comparing(Vehiculo::getCosto);
        unGara.getVehiculos().sort(sortByPrice);

        vehicles.stream().forEach(System.out::println);

        Comparator<Vehiculo> sortByMarcaPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        unGara.getVehiculos().sort(sortByMarcaPrecio);

        vehicles.stream().forEach(vehiculo -> System.out.println(vehiculo));







    }
}
