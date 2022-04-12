package generigcWrapperLambdaStreams;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main (String[] args) {
        Vehicle vehicle1 = new Vehicle("Fiesta", "Ford", 1000.0);
        Vehicle vehicle2 = new Vehicle("Focus", "Ford", 1200.0);
        Vehicle vehicle3 = new Vehicle("Explorer", "Ford", 2500.0);
        Vehicle vehicle4 = new Vehicle("Uno", "Fiat", 500.0);
        Vehicle vehicle5 = new Vehicle("Cronos", "Fiat", 1000.0);
        Vehicle vehicle6 = new Vehicle("Torino", "Fiat", 1250.0);
        Vehicle vehicle7 = new Vehicle("Aveo", "Chevrolet", 1250.0);
        Vehicle vehicle8 = new Vehicle("Spin", "Chevrolet", 2500.0);
        Vehicle vehicle9 = new Vehicle("Corola", "Toyota", 1200.0);
        Vehicle vehicle10 = new Vehicle("Fortuner", "Toyota", 3000.0);
        Vehicle vehicle11 = new Vehicle("Logan", "Renault", 950.0);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
        vehicles.add(vehicle6);
        vehicles.add(vehicle7);
        vehicles.add(vehicle8);
        vehicles.add(vehicle9);
        vehicles.add(vehicle10);
        vehicles.add(vehicle11);

        Garage garage = new Garage(1, vehicles);

        garage.getVehicles().stream().sorted(Comparator.comparing(Vehicle::getPrice)).forEach(System.out::println);

        System.out.println("");
        System.out.println("Punto 2 \n");

        garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getPrice)).forEach(System.out::println);

        System.out.println("");
        System.out.println("Punto 3 \n");

        ArrayList<Vehicle> menorMil = new ArrayList<>();
        ArrayList<Vehicle> mayorIgualMil = new ArrayList<>();
        Double promedio;

        garage.getVehicles().stream().filter(veh -> veh.getPrice() < 1000).forEach(veh -> {
            menorMil.add(veh);
            System.out.println(veh);
        });

        System.out.println("");

        garage.getVehicles().stream().filter(veh -> veh.getPrice() >= 1000).forEach(veh -> {
            mayorIgualMil.add(veh);
            System.out.println(veh);
        });

        promedio = garage.getVehicles().stream().mapToDouble(Vehicle::getPrice).sum()
                / (long) garage.getVehicles().size();

        System.out.println("");
        System.out.println(promedio);

    }
}
