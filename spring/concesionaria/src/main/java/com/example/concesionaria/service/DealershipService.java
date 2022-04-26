package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;
import com.example.concesionaria.repository.IDealershipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealershipService implements IDealershipService {
    private final IDealershipRepository repository;
    ModelMapper mapper = new ModelMapper();

    public DealershipService(IDealershipRepository repository) {
        this.repository = repository;
    }


    @Override
    public int createVehicle(VehicleDTO vehicle) {
        return repository.createVehicle(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        return repository.getVehicles().stream()
                .map(v -> mapper.map(v, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        return repository.getVehiclesByManufacturingDate(since, to).stream()
                .map(v -> mapper.map(v, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByPrice(double since, double to) {
        return repository.getVehiclesByPrice(since, to).stream()
                .map(v -> mapper.map(v, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleInformation(int id) {
        return mapper.map(repository.getVehicleInformation(id), VehicleDTO.class);
    }
}
