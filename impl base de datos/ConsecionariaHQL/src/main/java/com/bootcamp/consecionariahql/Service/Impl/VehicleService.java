package com.bootcamp.consecionariahql.Service.Impl;

import com.bootcamp.consecionariahql.Model.DTO.Vehicle.VehicleDTO;
import com.bootcamp.consecionariahql.Model.Vehicle;
import com.bootcamp.consecionariahql.Service.interfaces.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    @Override
    public ResponseEntity<?> create(VehicleDTO vehicle) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Vehicle vehicle) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Vehicle vehicle) {
        return null;
    }

    @Override
    public Optional<VehicleDTO> findById(Long id) {
        return Optional.empty();
    }
}
