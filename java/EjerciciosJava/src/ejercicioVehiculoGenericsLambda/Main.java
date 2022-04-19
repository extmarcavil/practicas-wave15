package ejercicioVehiculoGenericsLambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaGarage=  new ArrayList<Vehiculo>();
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

        Garage garage1 = new Garage(1, listaGarage);

        System.out.println("Lista de vehiculos ordenada por precio de menor a mayor");
        listaGarage.stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).forEach(System.out::println);
        System.out.println("\nLista de vehiculos ordenada por precio y marca de menor a mayor");
        listaGarage.stream().sorted((v1,v2) -> v1.getPrecio().compareTo(v2.getPrecio())).sorted((m1,m2) -> m1.getModelo().compareToIgnoreCase(m2.getModelo())).forEach(System.out::println);

        List<Vehiculo> listaMenorMil = listaGarage.stream().filter(vehiculo -> vehiculo.getPrecio() < Integer.valueOf(1000)).collect(Collectors.toList());

        List<Vehiculo> listaMayorMil = listaGarage.stream().filter(vehiculo -> vehiculo.getPrecio() >= Integer.valueOf(1000)).collect(Collectors.toList());
        double promedio = listaGarage.stream().mapToDouble(vehiculo -> vehiculo.getPrecio()).average().getAsDouble();
        System.out.println("\nLista de vehiculos menores a 1000");
        System.out.println(listaMenorMil);
        System.out.println("\nLista de vehiculos mayores o iguales a 1000");
        System.out.println(listaMayorMil);
        System.out.println("\nPrecio promedio");
        System.out.println(promedio);
    }
}
