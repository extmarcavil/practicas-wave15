import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Automovil> listaAutomoviles = new ArrayList<>();

        Automovil automovil = new Automovil("Ford", "Fiesta", 1000);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Ford","Focus",1200);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Ford","Explorer",2500);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Fiat","Uno",500);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Fiat","Cronos",1000);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Fiat","Torino",1250);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Chevrolet","Aveo",1250);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Chevrolet","Spin",2500);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Toyota","Corola",1200);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Toyota","Fortune",3000);
        listaAutomoviles.add(automovil);
        automovil = new Automovil("Renault","Logan",950);
        listaAutomoviles.add(automovil);

        Garage garage = new Garage(listaAutomoviles);

        System.out.println("Ejercicio 3 - Orden de precio de Menor a Mayor \n");

        ordenarPorPrecio(garage);

        System.out.println("Ejercicio 4 - Orden por Marca y Precio de Menor a Mayor \n");

        ordenarPorMarcaYPrecio(garage);

        System.out.println("Ejercicio 5 - Precio mayor a 1000 \n");

        ordenarPorPrecioMayorMil(garage);

        System.out.println("Ejercicio 5 - Precio menor a 1000 \n");

        ordenarPorPrecioMenorMil(garage);

        System.out.println("Ejercicio 5 - Promedio \n");

        promedio(garage);
    }

    private static void ordenarPorPrecio(Garage garage) {
        Comparator<Automovil> sortByPrecio = Comparator.comparing(Automovil::getCosto);
        garage.getListaAutomoviles().sort(sortByPrecio);

        garage.getListaAutomoviles().stream()
                                    .forEach(vehiculo -> System.out.println(vehiculo));
    }

    public static void ordenarPorMarcaYPrecio(Garage garage){
        Comparator<Automovil> sortByMarcaPrecio = Comparator.comparing(Automovil::getMarca).thenComparing(Automovil::getCosto).reversed();
        garage.getListaAutomoviles().sort(sortByMarcaPrecio);

        garage.getListaAutomoviles().stream()
                                    .forEach(vehiculo -> System.out.println(vehiculo));
    }

    private static void ordenarPorPrecioMayorMil(Garage garage) {
        Comparator<Automovil> sortByPrecioMayorMil = Comparator.comparing(Automovil::getCosto);
        garage.getListaAutomoviles().stream()
                                    .filter(automovil -> automovil.getCosto() >= 1000)
                                    .sorted(sortByPrecioMayorMil)
                                    .forEach(System.out::println);
    }

    private static void ordenarPorPrecioMenorMil(Garage garage) {
        Comparator<Automovil> sortByPrecioMenorMil = Comparator.comparing(Automovil::getCosto);
        garage.getListaAutomoviles().stream()
                                    .filter(automovil -> automovil.getCosto() < 1000)
                                    .sorted(sortByPrecioMenorMil)
                                    .forEach(System.out::println);
    }

    private static void promedio(Garage garage) {
        Comparator<Automovil> sortByPrecioMenorMil = Comparator.comparing(Automovil::getCosto);
        double resultado = garage.getListaAutomoviles().stream()
                                                       .mapToDouble(vehiculo -> vehiculo.getCosto())
                                                       .sum();
                resultado = resultado / garage.getListaAutomoviles().size();
        System.out.println("El promedio es : " + resultado);
    }
}
