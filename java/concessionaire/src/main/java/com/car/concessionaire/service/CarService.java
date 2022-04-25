package com.car.concessionaire.service;

import com.car.concessionaire.dto.CarDto;
import com.car.concessionaire.exceptions.CarAlreadyExistsException;
import com.car.concessionaire.exceptions.CarDoesNotExistException;
import com.car.concessionaire.model.Car;
import com.car.concessionaire.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements QueryFilter<Car> {

    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Car create(Car car) {
        if (repository.exists(car)) {
            throw new CarAlreadyExistsException(car);
        }
        return repository.save(car);
    }

    public List<CarDto> getAll() {
        return repository.findAll().stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> filterByDates(LocalDate since, LocalDate to) {
        return repository.findAll().stream()
                .filter(car -> car.compareDateOf(since, to))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> filterByPrices(BigDecimal since, BigDecimal to) {
        return repository.findAll().stream()
                .filter(car -> car.comparePriceOf(since, to))
                .collect(Collectors.toList());
    }

    public Car findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarDoesNotExistException(id));
    }

}
