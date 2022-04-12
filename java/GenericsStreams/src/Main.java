import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> listaGarage = new ArrayList<>();

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

        Garage garage = new Garage(1, listaGarage);
        //OPCION 1
        listaGarage.stream().sorted((a1, a2) ->a1.getCosto().compareTo(a2.getCosto())).forEach(System.out::println);
        System.out.println(" ");
        System.out.println(listaGarage);

        listaGarage.stream().sorted((a1, a2) ->a1.getCosto().compareTo(a2.getCosto())).sorted((a1, a2) ->a1.getMarca().compareTo(a2.getMarca())).forEach(System.out::println);
        System.out.println(" ");
        System.out.println(listaGarage);

        //OPCION 2
        //listaGarage.sort((v1, v2) ->v1.getCosto().compareTo(v2.getCosto()));
        //System.out.println(" ");
        //System.out.println(listaGarage);

        List<Vehiculo> vehiculosMenorA1000 = listaGarage.stream().filter(v -> v.getCosto() <1000).collect(Collectors.toList());
        System.out.println(" ");
        System.out.println(vehiculosMenorA1000);

        List<Vehiculo> vehiculosMayorA1000 = listaGarage.stream().filter(v -> v.getCosto() >1000).collect(Collectors.toList());
        System.out.println(" ");
        System.out.println(vehiculosMayorA1000);

        OptionalDouble prom = listaGarage
                .stream()
                .mapToDouble(a -> a.getCosto())
                .average();
        System.out.println(" ");
        System.out.println(prom.getAsDouble());
    }
}
