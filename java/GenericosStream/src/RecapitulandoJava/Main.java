package RecapitulandoJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Renault", 950);

        Garage garage = new Garage(1, new ArrayList<Vehiculo>());

        garage.addAuto(v1);
        garage.addAuto(v2);
        garage.addAuto(v3);
        garage.addAuto(v4);
        garage.addAuto(v5);
        garage.addAuto(v6);
        garage.addAuto(v7);
        garage.addAuto(v8);
        garage.addAuto(v9);
        garage.addAuto(v10);
        garage.addAuto(v11);

        //Ejercicio 3
        List<Vehiculo> listaOrdenada = garage.getAutos();
        listaOrdenada.stream()
                .sorted((x,y)-> Integer.valueOf(x.getCosto()).compareTo(y.getCosto()))
                .forEach(System.out::println);

        //Ejercicio 4
        System.out.println("\nLista por marca:");
        List<Vehiculo> listaOrdenadaPorMarca = garage.getAutos();
        listaOrdenadaPorMarca.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        //Ejercicio 5
        System.out.println("\nLista por precio menor que 1000:");
        listaOrdenada.stream()
                .filter(x -> x.getCosto() <= 1000)
                .forEach(System.out::println);

        System.out.println("\nLista por precio mayor que 1000:");
        listaOrdenada.stream()
                .filter(x -> x.getCosto() > 1000)
                .forEach(System.out::println);

        OptionalDouble prom = listaOrdenada.stream()
                .mapToDouble(x -> x.getCosto())
                .average();
        System.out.println("El promedio del costo es: " + prom.getAsDouble());
    }

}
