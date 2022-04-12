package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje g = new Garaje(1, vehiculos);

        // Ejercicio 3
        vehiculos.sort((x,y) -> x.getCosto().compareTo(y.getCosto()));
        vehiculos.forEach(System.out::println);

        // Ejercicio 4
        Map<String,List<Vehiculo>> vehiclesByBrands = vehiculos.stream().collect(Collectors.groupingBy(Vehiculo::getMarca));
        vehiclesByBrands.keySet().stream().sorted().forEach(k -> System.out.println(k + '\n' + vehiclesByBrands.get(k)));

        // Ejercicio 5
        vehiculos.stream().filter(x -> x.getCosto() < 1000).forEach(System.out::println);
        vehiculos.stream().filter(x -> x.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("Precio promedio: " + vehiculos.stream().mapToDouble(x -> x.getCosto()).sum() / vehiculos.size());
    }
}
