import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args){

        Vehiculo fiesta = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo focus = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo explorer = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo uno = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo cronos = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo torino = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo aveo = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo spin = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo corola = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo fortuner = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo logan = new Vehiculo("Renault", "Logan", 950);


        Garage garage = new Garage(123);

        List<Vehiculo> vehicles = new ArrayList<>(){{
            add(fiesta);add(focus);add(explorer);add(uno);add(cronos);add(torino);add(aveo);add(spin);add(corola);add(fortuner);add(logan);
        }};
        garage.getVehiculos().addAll(vehicles);

        Comparator<Vehiculo> sortByPrice = Comparator.comparing(Vehiculo::getCosto);
        garage.getVehiculos().sort(sortByPrice);

//        for(Vehiculo v: garage.getVehiculos()){
//            System.out.println(v.toString());
//        }
        System.out.println("Lista de vehiculos por precio:");
        System.out.println(" ");

        garage.getVehiculos().stream().forEach((vehiculo -> System.out.println(vehiculo)));


        System.out.println(" ");

        Comparator<Vehiculo> sortByMarcaYPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getMarca);
        garage.getVehiculos().sort(sortByMarcaYPrecio);

//        for(Vehiculo v: garage.getVehiculos()){
//            System.out.println(v.toString());
//        }
        System.out.println("Lista de vehiculos por marca y precio:");
        System.out.println(" ");

        garage.getVehiculos().stream().forEach((vehiculo -> System.out.println(vehiculo)));

        System.out.println(" ");
        System.out.println("Lista de vehiculos menores a $1000:");
        System.out.println(" ");

        List<Vehiculo> vehiculosBaratos = garage.getVehiculos().stream().filter(x -> x.getCosto()<=1000).collect(Collectors.toList());
        vehiculosBaratos.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("Lista de vehiculos mayores a $1000:");
        System.out.println(" ");

        List<Vehiculo> vehiculosCaros = garage.getVehiculos().stream().filter(x -> x.getCosto()>1000).collect(Collectors.toList());
        vehiculosCaros.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("Promedio de precios: ");
        System.out.println(" ");

        double media = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(media);

    }
}
