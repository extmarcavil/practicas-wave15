package com.meli.seguro.service;

import com.meli.seguro.entity.Vehicle;
import com.meli.seguro.api.dto.VehicleDto;
import com.meli.seguro.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository repository;

    public List<Vehicle> getWithAccidents() {
        return repository.findByAccidents();
    }

    public List<VehicleDto> getAll() {
        List<Object[]> list = repository.findAllVehicle();

        return list.stream()
                .map(
                    objects ->{
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
                }).collect(Collectors.toList());
    }

}
