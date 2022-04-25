package com.car.concessionaire.controller;

import com.car.concessionaire.dto.CarDto;
import com.car.concessionaire.model.Car;
import com.car.concessionaire.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Car> save(@Valid @RequestBody Car car) {
        return new ResponseEntity<>(service.create(car), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<CarDto> getCarsDto() {
        return service.getAll();
    }

    @GetMapping("dates")
    public List<Car> getCarsByDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        return service.filterByDates(since, to);
    }

    @GetMapping("prices")
    public List<Car> getCarsByPrices(@RequestParam BigDecimal since, @RequestParam  BigDecimal to) {

        return service.filterByPrices(since, to);
    }

    @GetMapping("{id}")
    public Car getCarById(@PathVariable Long id) {
        return service.findById(id);
    }
}
