package com.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.setId(1);

        //Lista de vehiculos
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("ford","fiesta",1000));
        vehiculos.add(new Vehiculo("ford","focus",1200));
        vehiculos.add(new Vehiculo("ford","explorer",2500));
        vehiculos.add(new Vehiculo("fiat","uno",500));
        vehiculos.add(new Vehiculo("fiat","cronos",1000));
        vehiculos.add(new Vehiculo("fiat","torino",1250));
        vehiculos.add(new Vehiculo("chevrolet","aveo",1250));
        vehiculos.add(new Vehiculo("chevrolet","spin",2500));
        vehiculos.add(new Vehiculo("toyota","corolla",1200));
        vehiculos.add(new Vehiculo("toyota","fortuner",3000));
        vehiculos.add(new Vehiculo("renault","logan",950));

        garage.setVehiculos(vehiculos);

        System.out.println("\n=====ORDENADOS POR PRECIO======\n");

        //Parte 3
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).forEach(System.out::println);

        System.out.println("\n====ORDENADOS POR PRECIO Y MARCA=======\n");

        //Parte 4
        Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio);
        garage.getVehiculos().stream().sorted(comparator).forEach(System.out::println);

        System.out.println("\n=====MENORES A 1000======\n");

        //Parte 5
        garage.getVehiculos().stream().filter(v -> v.getPrecio() < 1000).forEach(System.out::println);

        System.out.println("\n======MAYORES A 1000=====\n");

        garage.getVehiculos().stream().filter(v -> v.getPrecio() >= 1000).forEach(System.out::println);

        System.out.println("\n=====PROMEDIO======\n");

        garage.getVehiculos().stream()
                .mapToInt(v -> (int) v.getPrecio())
                .average()
                .ifPresent(avg -> System.out.println("El promedio es:  " + avg));
    }
}
