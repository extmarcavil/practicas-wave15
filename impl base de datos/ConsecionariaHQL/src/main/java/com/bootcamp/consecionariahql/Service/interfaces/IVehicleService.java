package com.bootcamp.consecionariahql.Service.interfaces;

import com.bootcamp.consecionariahql.Model.DTO.Vehicle.VehicleDTO;
import com.bootcamp.consecionariahql.Model.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IVehicleService {

    public ResponseEntity<?> create(Vehicle vehicle);
    public ResponseEntity<?> update(Vehicle vehicle);
    public ResponseEntity<?> delete(Vehicle vehicle);
    public Optional<VehicleDTO> findById(Long id);

}
