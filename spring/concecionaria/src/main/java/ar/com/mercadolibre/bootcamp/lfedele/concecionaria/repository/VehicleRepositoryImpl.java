package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.repository;

import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles;

    public  VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicles
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (!existsById(vehicle.getId())) {
            vehicles.add(vehicle);
        }
        return vehicle;
    }

    @Override
    public void remove(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    private boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
