package Clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listado = new ArrayList<>();

        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        listado.add(fiesta);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        listado.add(focus);
        Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
        listado.add(explorer);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
        listado.add(uno);
        Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
        listado.add(cronos);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        listado.add(torino);
        Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        listado.add(aveo);
        Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
        listado.add(spin);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        listado.add(corola);
        Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        listado.add(fortuner);
        Vehiculo logan = new Vehiculo("Logan", "Renault", 950);
        listado.add(logan);

        Garaje garaje = new Garaje(5,listado);

        //Punto 3 | Listar los vehiculos de menor a mayor por precio.
        System.out.println("-------------Listar los vehiculos de menor a mayor por precio.------------------");
        //garaje.getListado().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        garaje.getListado().sort((c1, c2)->((Integer)c1.getCosto()).compareTo(c2.getCosto()));
        garaje.getListado().stream().forEach(vehiculo -> System.out.println(vehiculo));
        System.out.println("-------------Listar los vehiculos por marca y por precio.------------------");

        //Punto 4 | Listar los vehiculos por marca y por precio.
        garaje.getListado().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("-------------Listar vehiculos con precio no mayor a 1000.------------------");

        //Punto 5 | 1).Listar vehiculos con precio no mayor a 1000.
        garaje.getListado().stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        System.out.println("-------------Listar vehiculos con precio mayor o igual a 1000.------------------");
        // 2) Listar vehiculos con precio >= 1000.
        garaje.getListado().stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);
        System.out.println("-------------Promedio de los precios de los vehiculos.------------------");
        // 3)Avg de los precios.
        System.out.println("Promedio: $" + garaje.getListado().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());

    }
}
