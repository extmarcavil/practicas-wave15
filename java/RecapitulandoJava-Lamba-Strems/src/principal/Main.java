package principal;
import java.util.*;
import java.util.stream.*;

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

        Garage garage = new Garage(lista);
        System.out.println("Lista ordenada por precio de mayor a menor");
        lista.sort( (c1, c2) -> (c1.getCosto()).compareTo(c2.getCosto()));
        lista.forEach(System.out::println);

        List<Vehiculo> listaOrdenada = garage.getVehiculos();
       // listaOrdenada.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);


        List<Vehiculo> vehiculosBaratos = listaOrdenada.stream().filter(x-> x.getCosto()<1000).collect(Collectors.toList());
        List<Vehiculo> vehiculosCaros = listaOrdenada.stream().filter(x-> x.getCosto()>=1000).collect(Collectors.toList());

        System.out.println("Vehiculos menor a 1000");
        vehiculosBaratos.forEach(System.out::println);

        System.out.println("Vehiculos mayor a 1000");
        vehiculosCaros.forEach(System.out::println);

        System.out.println("Promedio precio de Vehiculos");
        double promedio = listaOrdenada.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);

        List lista1 = new HasMap<String,String>();
    }




}
