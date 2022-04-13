package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculosList = new ArrayList<>();
        vehiculosList.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculosList.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculosList.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculosList.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculosList.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculosList.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculosList.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculosList.add(new Vehiculo("Toyota", "Fortuner", 3500));
        vehiculosList.add(new Vehiculo("Renault", "Logan", 950));
        Garage newGarage = new Garage(1L, vehiculosList);

        //ToDo: metodo para ordenar los costos de forma ascendente
        vehiculosList.sort(Comparator.comparing(Vehiculo::getCosto));


        //ToDo: metodo para ordenar marca  y costo de forma ascendente.
        vehiculosList.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));



        vehiculosList.stream()
                    .mapToDouble(Vehiculo::getCosto)
                    .average()
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Lista vacia"));

        System.out.println(vehiculosList);
    }

    }


