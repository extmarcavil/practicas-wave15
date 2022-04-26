package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IDealershipService {
    int createVehicle(VehicleDTO vehicle);

    List<VehicleResponseDTO> getVehicles();

    List<VehicleResponseDTO> getVehiclesByManufacturingDate(LocalDate since, LocalDate to);

    List<VehicleResponseDTO> getVehiclesByPrice(double since, double to);

    VehicleDTO getVehicleInformation(int id);
}
