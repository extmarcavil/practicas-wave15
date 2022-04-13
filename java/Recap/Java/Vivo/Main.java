package Recap.Java.Vivo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiculos);

        System.out.println("Vehículos ordenados por precio de menor a mayor");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(veh -> System.out.println(veh.getMarca() + " " + veh.getModelo() + " $" + veh.getCosto()));

        System.out.println("\nVehículos ordenados por marca y precio de menor a mayor");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(veh -> System.out.println(veh.getMarca() + " " + veh.getModelo() + " $" + veh.getCosto()));

        System.out.println("\nVehículos con precio no mayor a $1000");
        List<Vehiculo> vehiculos_menor_1000 = garage.getVehiculos().stream()
                .filter(veh -> veh.getCosto() <= 1000)
                .collect(Collectors.toList());
        vehiculos_menor_1000.forEach(veh -> System.out.println(veh.getMarca() + " " + veh.getModelo() + " $" + veh.getCosto()));

        System.out.println("\nVehículos con precio mayor o igual a $1000");
        List<Vehiculo> vehiculos_mayor_1000 = garage.getVehiculos().stream()
                .filter(veh -> veh.getCosto() >= 1000)
                .collect(Collectors.toList());
        vehiculos_mayor_1000.forEach(veh -> System.out.println(veh.getMarca() + " " + veh.getModelo() + " $" + veh.getCosto()));

        System.out.println("\nPromedio total de costos");
        System.out.println(garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());


    }
}
