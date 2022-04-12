import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage(1234);
        garage.getVehiculos().add(new Vehiculo("Ford", "Fiesta", 1000));
        garage.getVehiculos().add(new Vehiculo("Ford", "Focus", 1200));
        garage.getVehiculos().add(new Vehiculo("Ford", "Explorer", 2500));
        garage.getVehiculos().add(new Vehiculo("Fiat", "Uno", 500));
        garage.getVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000));
        garage.getVehiculos().add(new Vehiculo("Fiat", "Torino", 1250));
        garage.getVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.getVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.getVehiculos().add(new Vehiculo("Toyota", "Corola", 1200));
        garage.getVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.getVehiculos().add(new Vehiculo("Renault", "Logan", 950));

        garage.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------\n");

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------\n");

        garage.getVehiculos().stream()
                .filter(p -> p.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------\n");

        garage.getVehiculos().stream()
                .filter(p -> p.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------\n");

        double average = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("El promedio de costo es de $" + average);
    }
}
