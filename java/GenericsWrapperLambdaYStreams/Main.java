package GenericsWrapperLambdaYStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> lista = new ArrayList<>();

        // Add some cars to the garage
        lista.add(new Vehiculo("Ford", "Fiesta", 1000));
        lista.add(new Vehiculo("Ford", "Focus", 1200));
        lista.add(new Vehiculo("Ford", "Explorer", 2500));
        lista.add(new Vehiculo("Fiat", "Uno", 500));
        lista.add(new Vehiculo("Fiat", "Cronos", 1000));
        lista.add(new Vehiculo("Fiat", "Torino", 1250));
        lista.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        lista.add(new Vehiculo("Chevrolet", "Spin", 2500));
        lista.add(new Vehiculo("Toyota", "Corola", 1200));
        lista.add(new Vehiculo("Toyota", "Fortuna", 3000));
        lista.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, lista);

        List<Vehiculo> listaOrdenada = garage.getVehiculos();

        System.out.println("Lista ordenada por precio");
        listaOrdenada.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("Lista ordenada por Marca y Precio");
        listaOrdenada.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("Vehiculos menor a 1000");
        List<Vehiculo> vehiculosBaratos = listaOrdenada.stream().filter(x-> x.getCosto()<1000).collect(Collectors.toList());
        vehiculosBaratos.forEach(System.out::println);

        System.out.println("Vehiculos mayor a 1000");
        List<Vehiculo> vehiculosCaros = listaOrdenada.stream().filter(x-> x.getCosto()>=1000).collect(Collectors.toList());
        vehiculosCaros.forEach(System.out::println);

        System.out.println("Promedio precio de Vehiculos");
        double promedio = listaOrdenada.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);
    }
}
