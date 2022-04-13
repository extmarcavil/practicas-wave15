package Main;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Vehiculo v1 = new Vehiculo("Ford","Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford","Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford","Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat","Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat","Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat","Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet","Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Ford","Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota","Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota","Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault","Logan", 950);

        List<Vehiculo> list = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);

        vehiculos.addAll(list);

        vehiculos.sort((p1, p2) -> p1.costo.compareTo(p2.costo));

        vehiculos.forEach( vehiculo -> System.out.println(vehiculo));
        System.out.println("-------------------------------------------------");
        Comparator<Vehiculo> compararMarcaCosto = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto);

        List<Vehiculo> sortedVehicles = vehiculos.stream()
                .sorted(compararMarcaCosto)
                .collect(Collectors.toList());

        sortedVehicles.forEach(vehiculo -> System.out.println(vehiculo));
        System.out.println("-------------------------------------------------");

        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .forEach(vehiculo -> System.out.println(vehiculo));
        System.out.println("-------------------------------------------------");

        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("-------------------------------------------------");

        OptionalDouble average = vehiculos.stream()
                .mapToInt(vehiculo -> vehiculo.costo)
                .average();

        System.out.println("-------------------------------------------------");
        System.out.println(average.getAsDouble());


    }
}
