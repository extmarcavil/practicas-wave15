package com.bootcamp.concesionaria.repsitory;

import com.bootcamp.concesionaria.entities.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    /**
     * BD Mpa
     */
    private Map<Long, Car> cars = new HashMap<>();
    private Long id;


    /**
     * Metodos
     *
     * @param car
     * @return
     */
    @Override
    public boolean addCar(Car car) {
        this.cars.put(id, car);
        this.id += 1;
        return true;
    }

    @Override
    public Map<Long, Car> getCars() {
        return cars;
    }

    @Override
    public Car gCar(Long id) {
        return cars.get(id);
    }

}
