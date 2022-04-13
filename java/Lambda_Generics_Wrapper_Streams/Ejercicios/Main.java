package Lambda_Generics_Wrapper_Streams.Ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        vehiculos.add(new Vehiculo("Focus","Ford",1200));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500));
        vehiculos.add(new Vehiculo("Uno","Fiat",500));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        vehiculos.add(new Vehiculo("Corolla","Toyota",1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        vehiculos.add(new Vehiculo("Logan","Renault",950));
        Garaje garaje = new Garaje(1,vehiculos);
        System.out.println("----------------------------------");
        System.out.println("Vehiculos ordenados precio:");
        garaje.getListaVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        Collections.sort(garaje.getListaVehiculos());

        System.out.println("----------------------------------");
        System.out.println("Vehiculos ordenas por marca y precio:");
        /*for(Vehiculo v : garaje.getListaVehiculos()){
            System.out.println(v.toString());
        }*/
        garaje.getListaVehiculos().forEach(System.out::println);


        System.out.println("----------------------------------");
        System.out.println("Vehiculos con precio no mayor a 1000:");
        garaje.getListaVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        System.out.println("Vehiculos con precio mayor o igual a 1000:");
        garaje.getListaVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        System.out.println("Promedio: "+garaje.getListaVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().orElse(0.0));

    }
}
