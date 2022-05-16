import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        Garaje g1 = new Garaje(1,vehiculos);

        System.out.println("------Ej 3--------");
        g1.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        System.out.println(g1.getVehiculos());


        System.out.println("------Ej 4--------");
        g1.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println(g1.getVehiculos());

        System.out.println("------Ej 5--------");
        System.out.println("------ Precio menor a 1000--------");
        List<Vehiculo> menores= g1.getVehiculos()
                .stream()
                .filter(p -> p.getCosto()<1000)
                .collect(Collectors.toList());
        System.out.println(menores);


        System.out.println("------ Precio mayor a 1000--------");
        List<Vehiculo> meyores= g1.getVehiculos()
                .stream()
                .filter(p -> p.getCosto()>=1000)
                .collect(Collectors.toList());
        System.out.println(meyores);

    }
}
