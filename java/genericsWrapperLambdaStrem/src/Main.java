import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, listaVehiculos);

        List<Vehiculo> listaVehiculosOrdenadaPrecio = garage.getVehiculos().stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .collect(Collectors.toList());

        System.out.println("Vehiculos ordenados por precio:" + listaVehiculosOrdenadaPrecio);

        List<Vehiculo> listaVehiculosOrdenadaMarcayPrecio = listaVehiculos.stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .sorted((x,y) -> x.getMarca().compareTo(y.getMarca()))
                .collect(Collectors.toList());

        // Otra Opcion
        // listaVehiculosOrdenadaMarcayPrecio = listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).collect(Collectors.toList());

        System.out.println("Vehiculos ordenados por marca y precio: " + listaVehiculosOrdenadaMarcayPrecio);

        List<Vehiculo> vehiculosMenorMil = listaVehiculos.stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo> vehiculosMayorIgualMil = listaVehiculos.stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());

        System.out.println("Vehiculos con precio menor a mil: " + vehiculosMenorMil);
        System.out.println("Vehiculos con precio mayor o igual a mil: " + vehiculosMayorIgualMil);

        double promedioPrecios = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("Promedio de precios: " + Math.round(promedioPrecios));

    }
}
