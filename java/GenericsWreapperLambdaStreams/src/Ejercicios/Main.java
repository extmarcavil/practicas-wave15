package Ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int id;
        int idSig = 0;

        List <Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        listaVehiculos.add(new Vehiculo("Ford","Focus",1200));
        listaVehiculos.add(new Vehiculo("Ford","Explorer",2500));
        listaVehiculos.add(new Vehiculo("Fiat","Uno",500));
        listaVehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        listaVehiculos.add(new Vehiculo("Fiat","Torino",1250));
        listaVehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        listaVehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        listaVehiculos.add(new Vehiculo("Toyota","Corola",1200));
        listaVehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        listaVehiculos.add(new Vehiculo("Renaul","Logan",950));

        Garaje garaje1 = new Garaje(listaVehiculos);
        listaVehiculos.sort((v1,v2)-> (int) (v1.getCosto() - v2.getCosto()));

        listaVehiculos.forEach(vehiculo -> {
            System.out.println(vehiculo);
        });

        listaVehiculos.sort((v1,v2)-> (v1.getMarca().compareTo(v2.getMarca())));

        System.out.println("---------------------------");
        listaVehiculos.forEach(vehiculo -> {
            System.out.println(vehiculo);
        });

        System.out.println("---------------------------");

        List< Vehiculo> listaMenor1000 =  listaVehiculos.stream().filter(v -> v.getCosto()<1000).collect(Collectors.toList());
        List< Vehiculo> listaMayorIgual1000 = listaVehiculos.stream().filter(v -> v.getCosto()>=1000).collect(Collectors.toList());

        listaMenor1000.forEach(vehiculo -> {
            System.out.println(vehiculo);
        });

        System.out.println("---------------------------");

        listaMayorIgual1000.forEach(vehiculo -> {
            System.out.println(vehiculo);;
        });


    }
}
