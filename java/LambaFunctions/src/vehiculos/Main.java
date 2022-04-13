package vehiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaGarage=  new ArrayList<Vehiculo>();
        listaGarage.add(new Vehiculo("Ford","Fiesta", 1000));
        listaGarage.add(new Vehiculo("Ford","Focus", 1200));
        listaGarage.add(new Vehiculo("Ford","Explorer", 2500));
        listaGarage.add(new Vehiculo("Fiat","Uno", 500));
        listaGarage.add(new Vehiculo("Fiat","Cronos", 1000));
        listaGarage.add(new Vehiculo("Fiat","Torino", 1250));
        listaGarage.add(new Vehiculo("Chevrolet","Aveo", 1250));

        listaGarage.add(new Vehiculo("Chevrolet","Spin", 2500));
        listaGarage.add(new Vehiculo("Toyota","Corola", 1200));
        listaGarage.add(new Vehiculo("Toyota","Fortuner", 3000));
        listaGarage.add(new Vehiculo("Renault","Logan", 950));

        Garage g = new Garage(1,listaGarage);


        Comparator<Vehiculo> ordenPorPrecio = Comparator.comparing(Vehiculo::getCosto);
        g.getListaVehiculos().sort(ordenPorPrecio);
        System.out.println("Lista ordenada por precio");
        g.getListaVehiculos().stream().forEach(System.out::println);

        Comparator<Vehiculo> ordenPorMarcaPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        System.out.println("Lista ordenada por Marca y Precio");
        g.getListaVehiculos().sort(ordenPorMarcaPrecio);
        g.getListaVehiculos().stream().forEach(System.out::println);

        System.out.println("Vehiculos con precio no mayor a 1000");
        List<Vehiculo> l1 = g.getListaVehiculos().stream().filter(x -> x.getCosto()<1000).collect(Collectors.toList());
        l1.forEach(System.out::println);

        System.out.println("Vehiculos con precios mayor a 1000");
        List<Vehiculo> vehiculosCaros = g.getListaVehiculos().stream().filter(x -> x.getCosto()>=1000).collect(Collectors.toList());
        vehiculosCaros.forEach(System.out::println);

        System.out.println("Promedio de precios");
        double promedio = g.getListaVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);
    }
}
