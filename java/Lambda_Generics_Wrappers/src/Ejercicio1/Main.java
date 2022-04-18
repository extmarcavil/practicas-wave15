package Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Vehiculo> vehiculoList = new ArrayList<>();

        Vehiculo vehiculo;
        Vehiculo vehiculo1;
        Vehiculo vehiculo2;
        Vehiculo vehiculo3;
        Vehiculo vehiculo4;
        Vehiculo vehiculo5;
        Vehiculo vehiculo6;
        Vehiculo vehiculo7;

        vehiculo= new Vehiculo("Ford", "Fiesta", 1000);
        vehiculo1 = new Vehiculo("Fiat", "Torino", 2500);
        vehiculo2= new Vehiculo("Fiat", "Cronos", 1000);
        vehiculo3 = new Vehiculo("Chevrolet", "Aveo", 1250);
        vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        vehiculo5 = new Vehiculo("Renault", "Logan", 950);
        vehiculo6 = new Vehiculo("Toyota", "Fortuner", 3000);
        vehiculo7 = new Vehiculo("Ford", "Focus", 1200);

        Garage garage1 = new Garage(1, vehiculoList);


        garage1.incluirVehiculos(vehiculo);
        garage1.incluirVehiculos(vehiculo1);
        garage1.incluirVehiculos(vehiculo2);
        garage1.incluirVehiculos(vehiculo3);
        garage1.incluirVehiculos(vehiculo4);
        garage1.incluirVehiculos(vehiculo5);
        garage1.incluirVehiculos(vehiculo6);
        garage1.incluirVehiculos(vehiculo7);

        // ordenar la lista por costo
        garage1.obtenerVehiculos().sort((Vehiculo v1, Vehiculo v2) -> v1.getCosto().compareTo(v2.getCosto()));

        //muestro la lista
        System.out.println("Muestro la lista por costo");
        System.out.println(garage1.obtenerVehiculos());

        // stream toma de a dos objetos de la lista, el comparador llama
        System.out.println("Muestro la lista ordenada por marca ");
        garage1.obtenerVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingInt(Vehiculo::getCosto)).forEach(System.out::println);

       //Referencias a metodos :: = Vehiculo::getMarca == ((vehiculo v1) -> v1.getMarca();

        System.out.println("Lista ordenada menor a 1000");
        garage1.obtenerVehiculos().stream().filter((Vehiculo ve1)-> ve1.getCosto()< 1000).collect(Collectors.toList());
        System.out.println(garage1.obtenerVehiculos());


        System.out.println("Lista ordenada mayor igual a 1000");
        garage1.obtenerVehiculos().stream().filter((Vehiculo ve1)-> ve1.getCosto()>= 1000).collect(Collectors.toList());


        System.out.println("Ordenada por promedio");
        var total = garage1.obtenerVehiculos().stream().mapToInt((Vehiculo v1)->v1.getCosto()).average();
        System.out.println(total);
















    }
}
