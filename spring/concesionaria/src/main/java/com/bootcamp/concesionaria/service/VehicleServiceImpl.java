package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.entities.Car;
import com.bootcamp.concesionaria.repsitory.IVehicleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehiclesService {

    /**
     * Injection by Constructor
     */
    private IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Metodos
     *
     * @param car
     * @return
     */

    @Override
    public boolean addCar(Car car) {
        return vehicleRepository.addCar(car);
    }

    @Override
    public List<CarDto> getCars() {
        return vehicleRepository.getCars().entrySet().stream()
                .map(x -> getCarDTO(x.getValue())).
                collect(Collectors.toList());
    }


    @Override
    public List<Car> getCarsBetweenDates(Date since, Date to) {
        return vehicleRepository.getCars().entrySet()
                .stream()
                .map(x -> {
                    Car car = x.getValue();
                    if (car.getManufacturingDate().after(since) &&
                            car.getManufacturingDate().before(to)) {
                        return car;
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenPrices(Double since, Double to) {
        return vehicleRepository.getCars().entrySet()
                .stream()
                .map(x -> {
                    Car car = x.getValue();
                    if (car.getPrice() >= since && car.getPrice() <= to) {
                        return car;
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    @Override
    public Car getCar(Long id) {
        return vehicleRepository.gCar(id);
    }


    /**
     * Logica adicional en el service
     * Convert To Dto
     *
     * @param car
     * @return
     */
    private CarDto getCarDTO(Car car) {
        CarDto carDTO = new CarDto();

        carDTO.setBrand(car.getBrand());
        carDTO.setCurrency(car.getCurrency());
        carDTO.setDoors(car.getDoors());
        carDTO.setModel(car.getModel());
        carDTO.setCountOfOwners(car.getCountOfOwners());
        carDTO.setManufacturingDate(car.getManufacturingDate());
        carDTO.setNumberOfKilometers(car.getNumberOfKilometers());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }


}
