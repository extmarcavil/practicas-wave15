package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Ford", "Fiesta", 1000));
        vehicles.add(new Vehicle("Ford", "Focus", 1200));
        vehicles.add(new Vehicle("Ford", "Explorer", 2500));
        vehicles.add(new Vehicle("Ford", "Explorer", 500));

        vehicles.add(new Vehicle("Fiat", "Uno", 500));
        vehicles.add(new Vehicle("Fiat", "Chronos", 1000));
        vehicles.add(new Vehicle("Fiat", "Torino", 1250));

        vehicles.add(new Vehicle("Chevrolet", "Aveo", 1250));
        vehicles.add(new Vehicle("Chevrolet", "Spin", 2500));

        vehicles.add(new Vehicle("Toyota", "Corola", 1200));
        vehicles.add(new Vehicle("Toyota", "Fortuner", 3000));

        vehicles.add(new Vehicle("Renault", "Logan", 950));

        Garage garage = new Garage("1", vehicles);

        List<Vehicle> vehicles1 = vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .toList();

        List<Vehicle> vehicles2 = vehicles.stream()
                .sorted(
                        Comparator
                                .comparing(Vehicle::getBrand)
                                .thenComparing(Vehicle::getPrice)
                ).toList();

        List<Vehicle> vehicles3 = vehicles.stream()
                .filter((vehicle) -> vehicle.getPrice() < 1000).toList();

        List<Vehicle> vehicles4 = vehicles.stream()
                .filter((vehicle) -> vehicle.getPrice() >= 1000).toList();

        Double vehicles5 = vehicles.stream()
                .mapToDouble(Vehicle::getPrice).sum()/vehicles.size();
    }

}
