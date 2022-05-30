package com.meli.seguro.service;

import com.meli.seguro.api.dto.*;
import com.meli.seguro.api.mapper.VehicleMapper;
import com.meli.seguro.entity.Vehicle;
import com.meli.seguro.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public List<VehicleDto> getWithAccidents() {
        return repository.findByAccidents()
                .stream()
                .map(vehicle -> mapper.vehicleToVehicleDto(vehicle))
                .collect(Collectors.toList());
    }

    public List<VehicleOnlyDto> getAll() {
        List<Vehicle> list = repository.findAllVehicle();
        return list.stream()
                .map(
                    vehicle -> mapper.vehicleToVehicleOnlyDto(vehicle)
                ).collect(Collectors.toList());
    }

    public List<PatenteDto> getAllPatentes(Integer cant,Integer year) {
        Stream<Vehicle> v;
        if (cant == null && year == null) v =repository.findPatente().stream();
        else if (year==null) v = repository.findPatenteMasDe4Ruedas(cant).stream();
        else if (cant == null ) v = repository.findPatenteAnio(year).stream();
        else v= repository.findPatenteByAnioAndCantRuedasGreaterThan(cant, year).stream();
        return v.map(vehicle -> new PatenteDto(vehicle.getPatente())).collect(Collectors.toList());
    }

    public List<PatenteMarcaDto> getAllPatentesMarcas() {
        return repository.findPatenteMarca()
                .stream().map(
                        vehicle -> new PatenteMarcaDto(vehicle.getPatente(), vehicle.getMarca())
                ).collect(Collectors.toList());
    }

    public List<VehiclePatenteMarcaModeloDto> getAllPatenteMarcaModelo(BigDecimal perdida) {
        return repository.findByAccidentsPerdidaGreaterThan(perdida)
                .stream().map(
                        vehicle -> new VehiclePatenteMarcaModeloDto(vehicle.getPatente(), vehicle.getMarca(), vehicle.getModelo())
                ).collect(Collectors.toList());
    }
}
/*
mapeo a partir de Objects[] donde obj[0] es la primer entidad
                        Vehicle v;
                        VehicleDto vDto=new VehicleDto();
                        v = (Vehicle) objects[0];
                        vDto.setId(v.getId());
                        vDto.setAnioFabricacion(v.getAnioFabricacion());
                        vDto.setCantRuedas(v.getCantRuedas());
                        vDto.setMarca(v.getMarca());
                        vDto.setModelo(v.getModelo());
                        vDto.setPatente(v.getPatente());
                        return vDto;
 */