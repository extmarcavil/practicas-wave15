package vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("----ORDENANDO POR PRECIO----");

        vehiculos.sort((vehiculo1, vehiculo2) -> Double.compare(vehiculo1.getCosto(), vehiculo2.getCosto()));
        vehiculos.forEach(System.out::println);

        System.out.println("-------------------");

        System.out.println("----ORDENANDO POR MARCA Y LUEGO PRECIO----");

        List<Vehiculo> vehiculos1 = new ArrayList<>();
        vehiculos1 = vehiculos.stream()
                .sorted((vehiculo1, vehiculo2) -> {
                    int compareMarca = vehiculo1.getMarca().compareTo(vehiculo2.getMarca());
                    if(compareMarca == 0) return Double.compare(vehiculo1.getCosto(), vehiculo2.getCosto());
                    else return compareMarca;
                }).collect(Collectors.toList());

        vehiculos1.forEach(System.out::println);

        System.out.println("-------------------");

        List<Vehiculo> vNoMayor = new ArrayList<>();
        vNoMayor = vehiculos.stream().filter((vehiculo1) -> vehiculo1.getCosto() < 1000).collect(Collectors.toList());

        List<Vehiculo> vMayorIgual = new ArrayList<>();
        vMayorIgual = vehiculos.stream().filter((vehiculo1) -> (vehiculo1.getCosto() >= 1000)).collect(Collectors.toList());

        Double suma = vehiculos.stream().mapToDouble(vehiculo1->vehiculo1.getCosto()).sum();
        Double promedio = suma / vehiculos.size();

        System.out.println("\n----MOSTRANDO LISTAS---");
        System.out.println("No mayor a 1000");
        vNoMayor.forEach(System.out::println);
        System.out.println("\nMayor igual a 1000");
        vMayorIgual.forEach(System.out::println);
        System.out.println("\nPromedio: " + promedio);
    }
}
