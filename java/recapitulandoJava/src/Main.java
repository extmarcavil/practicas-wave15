import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos=List.of(
                new Vehiculo("Ford","Fiesta",1000.),
                new Vehiculo("Ford","Focus",1200.),
                new Vehiculo("Ford","Explorer",2500.),
                new Vehiculo("Fiat","Uno",500.),
                new Vehiculo("Fiat","Cronos",1000.),
                new Vehiculo("Fiat","Torino",1250.),
                new Vehiculo("Chevrolet","Aveo",1250.),
                new Vehiculo("Chevrolet","Spin",2500.),
                new Vehiculo("Toyota","Corolla",1200.0),
                new Vehiculo("Toyota","Fortuner",3000.0),
                new Vehiculo("Renault","Logan",950.0)

        );

        Garage garage=new Garage(1,vehiculos);

        System.out.println("-----------------");
        System.out.println("Ejercicio 3");
        System.out.println("-----------------");

        garage.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("Ejercicio 4");
        System.out.println("-----------------");

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);


        System.out.println("-----------------");
        System.out.println("Ejercicio 5");
        System.out.println("-----------------");

        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000.)
                .forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("-----------------");

        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000.)
                .forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("-----------------");

        Double avg= garage.getVehiculos().stream()
                        .mapToDouble(Vehiculo::getCosto)
                        .average()
                        .getAsDouble();

        System.out.println("Promedio Total de los precios: "+avg);



    }
}
