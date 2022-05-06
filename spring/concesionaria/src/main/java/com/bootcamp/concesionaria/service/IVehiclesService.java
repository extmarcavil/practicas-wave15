package com.bootcamp.concesionaria.service;


import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.entities.Car;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVehiclesService {


    boolean addCar(Car car);

    List<CarDto> getCars();

    List<Car> getCarsBetweenDates(Date since, Date to);

    List<Car> getCarsBetweenPrices(Double since, Double to);

    Car getCar(Long id);

}
