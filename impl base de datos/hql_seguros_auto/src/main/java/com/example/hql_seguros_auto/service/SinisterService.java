package com.example.hql_seguros_auto.service;

import com.example.hql_seguros_auto.dto.SinisterDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehicleSinisterDTO;
import com.example.hql_seguros_auto.entity.Sinister;
import com.example.hql_seguros_auto.entity.Vehicle;
import com.example.hql_seguros_auto.repository.SinisterRepository;
import com.example.hql_seguros_auto.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SinisterService implements ISinisterService {
    private final SinisterRepository sinisterRepository;
    private final VehicleRepository vehicleRepository;
    private final ModelMapper mapper;

    public SinisterService(SinisterRepository sinisterRepository, VehicleRepository vehicleRepository) {
        this.sinisterRepository = sinisterRepository;
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Sinister saveSinister(SinisterDTO sinisterDTO) {
        // Mapear los datos del dto a la entidad.
        Sinister sinister = mapper.map(sinisterDTO, Sinister.class);

        // Guardar vehículo si no existe.
        Long vehicleId = sinister.getVehicle().getId();
        if (vehicleId == null || vehicleRepository.findById(vehicleId).isEmpty()) {
            vehicleRepository.save(sinister.getVehicle());
        }

        // Guardar siniestro
        return sinisterRepository.save(sinister);
    }

    @Override
    public List<SinisterDTO> getSinisters() {
        // Obtener la lista y mapear los datos.
        return sinisterRepository.findAll().stream()
                .map(v -> mapper.map(v, SinisterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePlateBrandModelDTO> getVehiclesWithEconomicLossGreaterThan10000() {
        // Encontrar todos los siniestros con pérdida mayor a 10000.
        List<Sinister> sinisters = sinisterRepository.findAllByEconomicLossGreaterThanEqual(10000D);

        // Obtener los vehiculos.
        List<Vehicle> vehicles = new ArrayList<>();
        sinisters.forEach(v -> vehicles.add(v.getVehicle()));

        return vehicles.stream()
                .map(v -> mapper.map(v, VehiclePlateBrandModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleSinisterDTO getVehiclesWithEconomicLossGreaterThan10000AndTotal() {
        // Encontrar todos los siniestros con pérdida mayor a 10000.
        List<Sinister> sinisters = sinisterRepository.findAllByEconomicLossGreaterThanEqual(10000D);

        // Obtener los vehiculos.
        List<Vehicle> vehicles = new ArrayList<>();
        sinisters.forEach(v -> vehicles.add(v.getVehicle()));

        List<VehiclePlateBrandModelDTO> vehiclesDTO = vehicles.stream()
                .map(v -> mapper.map(v, VehiclePlateBrandModelDTO.class))
                .collect(Collectors.toList());

        Double totalCost = sinisters.stream().map(Sinister::getEconomicLoss).reduce(0D, Double::sum);

        return new VehicleSinisterDTO(vehiclesDTO, totalCost);
    }
}
