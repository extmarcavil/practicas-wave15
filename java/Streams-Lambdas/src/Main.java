import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(12);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        vehiculos.add(new Vehiculo("Focus","Ford",1200));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500));
        vehiculos.add(new Vehiculo("Uno","Fiat",500));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        vehiculos.add(new Vehiculo("Corola","Toyota",1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        vehiculos.add(new Vehiculo("Logan","Renault",950));
        garage.setVehiculos(vehiculos);


        //Arreglar para usar sort en ambos
        List<Vehiculo> vehiculos1 = garage.getVehiculos();
        vehiculos1.sort(Comparator.comparing(Vehiculo::getCosto));

        System.out.println("*** Ordenado por costo ***");
        for (Vehiculo v1 : vehiculos1)
        {
            System.out.println(v1);
        }
        System.out.println();
        System.out.println("*** Ordenado por costo y marca ***");
        vehiculos1.sort(Comparator.comparing(Vehiculo::getMarca));
        for (Vehiculo v1 : vehiculos1)
        {
            System.out.println(v1);
        }
        System.out.println();
        System.out.println("*** Menor a  1000 ***");
        garage.getVehiculos().stream().filter(a -> a.getCosto()<1000).forEach(System.out::println);
        System.out.println();
        System.out.println("*** Mayor o igual a 1000 ***");
        garage.getVehiculos().stream().filter(a -> a.getCosto()>=1000).forEach(System.out::println);
        System.out.println();
        double sum = garage.getVehiculos().stream().map(a -> a.getCosto()).reduce(0.0, (a,b) -> a+b);
        System.out.println("El promedio es: " + sum / garage.getVehiculos().stream().count());










    }
}
