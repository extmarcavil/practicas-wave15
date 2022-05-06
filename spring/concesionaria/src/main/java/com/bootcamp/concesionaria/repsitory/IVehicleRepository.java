package com.bootcamp.concesionaria.repsitory;

import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.entities.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IVehicleRepository {

    boolean addCar(Car car);

    Map<Long, Car> getCars();

    Car gCar(Long id);
}
