package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.service;

import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.dto.VehicleDto;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<VehicleDto> findAll();
    VehicleDto save(VehicleDto vehicleDto);
    Optional<VehicleDto> findById(Long id);
    List<VehicleDto> findByPrice(Integer since, Integer to);
}
