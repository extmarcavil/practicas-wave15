package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        Vehiculo vehiculo = new Vehiculo("Ford", "Fiesta", 1000F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Ford", "Focus", 1200F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Ford", "Explorer", 2500F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Fiat", "Uno", 500F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Fiat", "Cronos", 1000F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Fiat", "Torino", 1250F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Chevrolet", "Aveo", 1250F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Chevrolet", "Spin", 2500F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Toyota", "Corola", 1200F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Toyota", "Fortuner", 3000F);
        listaVehiculos.add(vehiculo);
        vehiculo = new Vehiculo("Renault", "Logan", 950F);
        listaVehiculos.add(vehiculo);

        Garaje garaje = new Garaje(1, listaVehiculos);

        System.out.println("Garaje ID: " + garaje.getId());
        System.out.println("Marca\tModelo\tPrecio");

        garaje.getVehiculosPorMarcayPrecioMenorAMayor();
        System.out.println("------");
        garaje.getVehiculosPorPrecioMenorAMayor();
        System.out.println("------");
        garaje.getVehiculosMenor1000();
        System.out.println("------");
        garaje.getVehiculos1000oMas();

        System.out.println("El promedio de la lista es: " + garaje.getPromedioCosto());

    }
}
