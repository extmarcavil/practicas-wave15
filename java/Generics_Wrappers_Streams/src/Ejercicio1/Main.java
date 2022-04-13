package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo Fiesta = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo Focus = new Vehiculo("Focus","Ford",1200);
        Vehiculo Explorer = new Vehiculo("Explorer","Ford",2500);
        Vehiculo Uno = new Vehiculo("Uno","Fiat",500);
        Vehiculo Cronos = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo Torino = new Vehiculo("Torino","Fiat",1250);
        Vehiculo Aveo = new Vehiculo("Aveo","Chevrolet",1250);

        List<Vehiculo> vehiculoList = new ArrayList();

        Garage garage1 = new Garage(1,vehiculoList);
        garage1.IncluirVehiculos(Focus);
        garage1.IncluirVehiculos(Explorer);
        garage1.IncluirVehiculos(Uno);
        garage1.IncluirVehiculos(Cronos);
        garage1.IncluirVehiculos(Torino);
        garage1.IncluirVehiculos(Aveo);

        //Muestro los todos los vehiculos sin ordenar
        System.out.println(garage1.obtenerVehiculos());
        //Ordeno los vehiculos por costo
        garage1.obtenerVehiculos().sort((Vehiculo v1, Vehiculo v2) -> v1.getCosto().compareTo(v2.getCosto()));
        //Muestro los vehiculos ordenados por costo
        System.out.println("\nORDENADOS POR COSTO");
        System.out.println(garage1.obtenerVehiculos());

        System.out.println("\nORDENADOS POR COSTO Y MARCA");
        garage1.obtenerVehiculos().stream().sorted(Comparator.comparingInt((Vehiculo v1)->v1.getCosto()).thenComparing(Vehiculo::getMarca)).forEach(System.out::println);

        System.out.println("\nPRECIO NO MAYOR A 1000");
        garage1.obtenerVehiculos().stream().filter((Vehiculo v1)->v1.getCosto()<1000).forEach(System.out::println);

        System.out.println("\nPRECIO MAYOR O IGUAL A 1000");
        garage1.obtenerVehiculos().stream().filter((Vehiculo v1)->v1.getCosto()>=1000).forEach(System.out::println);


        var totalCosto = garage1.obtenerVehiculos().stream().mapToInt((Vehiculo v1)->v1.getCosto()).average();
        System.out.println(totalCosto);


    }
}
