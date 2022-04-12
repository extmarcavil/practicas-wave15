package Vehiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Add some cars to the garage
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuna", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiculos);

        List<Vehiculo> listaOrdenada = garage.getVehiculos();

        System.out.println("-------------------------");
        System.out.println("Lista ordenada por precio");
        System.out.println("-------------------------");
        listaOrdenada.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Lista ordenada por marca y precio");
        System.out.println("----------------------------------");
        listaOrdenada.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println();
        System.out.println("----------------------");
        System.out.println("Vehículos menor a 1000");
        System.out.println("----------------------");
        listaOrdenada.stream().filter(x-> x.getCosto()<1000).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("Vehículos mayor a 1000");
        System.out.println("-----------------------");
        listaOrdenada.stream().filter(x-> x.getCosto()>=1000).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Promedio precio de vehículos ");
        System.out.println("----------------------------");
        double promedio = listaOrdenada.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);
    }
}
