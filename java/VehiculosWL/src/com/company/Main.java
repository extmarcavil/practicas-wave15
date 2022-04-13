package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new List<>();

        vehiculoList.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculoList.add(new Vehiculo("Ford","Focus",1200));
        vehiculoList.add(new Vehiculo("Ford","Explorer",2500));

        vehiculoList.add(new Vehiculo("Fiat","Uno",500));
        vehiculoList.add(new Vehiculo("Fiat","Chronos",2500));
        vehiculoList.add(new Vehiculo("Fiat","Torino",2500));

        Garage nuestroGarage = new Garage("1",vehiculoList);

        List<Vehiculo> lista1 = vehiculoList.stream().sorted((vehiculo1,vehiculo2) -> {
            if (vehiculo1.getPrecio() > vehiculo2.getPrecio()) return 1;
            if (vehiculo2.getPrecio() > vehiculo1.getPrecio()) return -1;

                    return 0;
                }
                ).collect(Collectors.toList());

        System.out.println("ORDENADOS POR PRECIO");
        lista1.forEach(vehiculo -> System.out.println(vehiculo));




    }
}
