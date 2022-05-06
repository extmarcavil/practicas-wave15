package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.entities.Car;
import com.bootcamp.concesionaria.service.VehicleServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehicleController {

    /**
     * InjectionOf Dependency
     */
    VehicleServiceImpl vehiclesService;

    public VehicleController(VehicleServiceImpl vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    /**
     * Methods
     *
     * @param car
     * @return
     */
    @PostMapping
    public boolean addCar(@RequestBody Car car) {
        return vehiclesService.addCar(car);
    }

    @GetMapping
    public List<CarDto> getCars() {
        return vehiclesService.getCars();
    }

    @GetMapping("dates")
    public List<Car> getCarsBetweenDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return vehiclesService.getCarsBetweenDates(since, to);
    }

    @GetMapping("prices")
    public List<Car> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to) {
        return vehiclesService.getCarsBetweenPrices(since, to);
    }

    @GetMapping("{id}")
    public Car getCarsBetweenPrices(@PathVariable Long id) {
        return vehiclesService.getCar(id);
    }
}
