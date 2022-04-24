package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.repository;

import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    Vehicle save(Vehicle vehicle);
    void remove(Vehicle vehicle);
}
