package com.example.concesionaria.repository;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.model.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DealershipRepository implements IDealershipRepository {
    private List<Vehicle> vehicles;
    private ModelMapper mapper = new ModelMapper();
    private int nextId;

    public DealershipRepository() {
        this.vehicles = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public int createVehicle(VehicleDTO vehicle) {
        Vehicle newVehicle = mapper.map(vehicle, Vehicle.class);
        newVehicle.setId(nextId++);
        vehicles.add(newVehicle);
        return newVehicle.getId();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        return vehicles.stream()
                .filter(v -> v.isBetweenDates(since, to))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getVehiclesByPrice(double since, double to) {
        return vehicles.stream()
                .filter(v -> v.isBetweenPrices(since, to))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getVehicleInformation(int id) {
        return vehicles.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .get();
    }
}
