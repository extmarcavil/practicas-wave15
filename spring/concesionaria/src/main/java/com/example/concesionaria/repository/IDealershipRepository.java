package com.example.concesionaria.repository;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IDealershipRepository {
    int createVehicle(VehicleDTO vehicle);

    List<Vehicle> getVehicles();

    List<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to);

    List<Vehicle> getVehiclesByPrice(double since, double to);

    Vehicle getVehicleInformation(int id);
}