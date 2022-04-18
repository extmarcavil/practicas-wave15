package ejercicioVehiculosGaraje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo v2 = new Vehiculo("Ford","Focus",1200);
        Vehiculo v3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo v4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo v5 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo v6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo v7 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo v8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo v9 = new Vehiculo("Toyota","Corola",1200);
        Vehiculo v10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo v11 = new Vehiculo("Renault","Logan",950);

        Garaje garaje = new Garaje(1);
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);
        listaVehiculos.add(v5);
        listaVehiculos.add(v6);
        listaVehiculos.add(v7);
        listaVehiculos.add(v8);
        listaVehiculos.add(v9);
        listaVehiculos.add(v10);
        listaVehiculos.add(v11);

        garaje.setListaVehiculos(listaVehiculos);

        //Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una
        //lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.

        System.out.println("\n --- LISTA ORDENADA POR COSTO --- ");
        Comparator<Vehiculo> comparador = Comparator.comparing(Vehiculo::getCosto);
        garaje.getListaVehiculos().stream()
                .sorted(comparador)
                .forEach(System.out::println);

        System.out.println("\n --- LISTA ORDENADA POR COSTO 2 --- ");
        listaVehiculos.sort((c1, c2) -> ((Integer)c1.getCosto()).compareTo(c2.getCosto()));
        listaVehiculos.forEach(System.out::println);

        //listaVehiculos.sort(comparador);

        System.out.println("\n --- LISTA ORDENADA POR MARCA Y COSTO --- ");
        //De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        garaje.getListaVehiculos().stream()
                .sorted(comparador)
                .sorted((x,y)->x.getMarca().compareToIgnoreCase(y.getMarca()))
                .forEach(System.out::println);


        //Se desea extraer una lista de vehículos con precio no mayor a 1000,
        // luego otra con precios mayor o igual 1000 y por último,
        // obtén el promedio total de precios de toda la lista de vehículos.

        System.out.println("\n --- LISTA FILTRADA POR COSTO MENOR A 1000 --- ");
        garaje.getListaVehiculos().stream()
                .filter(costo -> costo.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("\n --- LISTA FILTRADA POR COSTO MAYOR IGUAL A 1000 --- ");
        garaje.getListaVehiculos().stream()
                .filter(costo -> costo.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("\n --- PROMEDIO DE COSTO --- ");
        double promedio = garaje.getListaVehiculos().stream()
                .mapToDouble(x -> x.getCosto()).average().getAsDouble();
        System.out.println(promedio);
    }
}
