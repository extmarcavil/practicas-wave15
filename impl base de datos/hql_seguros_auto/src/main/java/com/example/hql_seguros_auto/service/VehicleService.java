package com.example.hql_seguros_auto.service;

import com.example.hql_seguros_auto.dto.VehiclePlateBrandDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateDTO;
import com.example.hql_seguros_auto.entity.Sinister;
import com.example.hql_seguros_auto.entity.Vehicle;
import com.example.hql_seguros_auto.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper mapper;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<VehiclePlateDTO> getVehiclesPlate() {
        // Obtener la lista y mapear los datos.
        return vehicleRepository.findAll().stream()
                .map(v -> mapper.map(v, VehiclePlateDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePlateBrandDTO> getVehiclesPlateBrandOrderByFabricationYear() {
        // Obtener la lista y mapear los datos.
        return vehicleRepository.findAllByOrderByFabricationYearAsc().stream()
                .map(v -> mapper.map(v, VehiclePlateBrandDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePlateDTO> getVehiclesFourWheelsFabricatedThisYear() {
        // Obtener la lista y mapear los datos.
        LocalDate date = LocalDate.now();
        return vehicleRepository.findAllByWheelsGreaterThanEqualAndFabricationYearEquals(4, date.getYear()).stream()
                .map(v -> mapper.map(v, VehiclePlateDTO.class))
                .collect(Collectors.toList());
    }
}
