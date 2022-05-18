import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Añadiendo vehiculos al garaje
        //Ejercicio 2
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuna", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        vehiculos = garaje.getVehiculos();

        //Ejercicio 3
        //Ordenando los vehiculos por precio menor a mayor.
        System.out.println("----------------------------------");
        System.out.println("Lista de vehiculos ordenada por precio");
        System.out.println("----------------------------------");
        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.stream().forEach(System.out::println);

        //Ejercicio 4
        //Ordenando los vehiculos por marca y precio de menor a mayor
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Vehiculos ordenada por marca y precio");
        System.out.println("----------------------------------");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculos.stream().forEach(System.out::println);

        //Ejercicio 5
        //Vehiculos con precio MENOR a $1000
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Vehículos con precio MENOR a 1000");
        System.out.println("----------------------------------");
        vehiculos.stream().filter(x-> x.getCosto()<1000).collect(Collectors.toList()).forEach(System.out::println);

        //Vehiculos con precio MAYOR a $1000
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Vehículos con precio MAYOR a 1000");
        System.out.println("----------------------------------");
        vehiculos.stream().filter(x-> x.getCosto()>=1000).collect(Collectors.toList()).forEach(System.out::println);

        //Precio promedio de todos los vehiculos
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Precio promedio de vehículos ");
        System.out.println("----------------------------------");
        double promedio = vehiculos.stream().mapToInt(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);
    }
}
