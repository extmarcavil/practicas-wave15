import model.Garage;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.addAll(List.of(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11));
        Garage garage = new Garage(1, vehiculos);

        //Ejercicio 3
        System.out.println("Vehiculos ordenados por precio, de mayor a menor");
        garage.getVehiculos()
                .sort(Comparator.comparing(Vehiculo::getCosto));
        System.out.println(garage.getVehiculos());

        System.out.println("-----");

        //Ejercicio 4
        System.out.println("Vehiculos ordenados por precio y por marca");
        garage.getVehiculos()
                .sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println(garage.getVehiculos());

        System.out.println("-----");

        //Ejercicio 5
        List<Vehiculo> vNoMayorA1000 = garage.getVehiculos()
                                                .stream()
                                                .filter(v -> v.getCosto()<=1000)
                                                .collect(Collectors.toList());
        System.out.println("Lista de vehiculos con costo menor a 1000");
        System.out.println(vNoMayorA1000);
        List<Vehiculo> vMayorA1000 = garage.getVehiculos()
                                            .stream()
                                            .filter(v -> v.getCosto()>1000)
                                            .collect(Collectors.toList());
        System.out.println("Lista de vehiculos con costo mayor o igual a 1000");
        System.out.println(vMayorA1000);
        System.out.println("Promedio de precios: " + garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());
    }
}