package com.example.concesionaria.repository;

import com.example.concesionaria.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoRepository {
    Car crear(Car car);
    List<Car> findAll();
    Car findById(Integer id);
    List<Car> findBetweenAndOrderedByDate(LocalDate since, LocalDate to);
    List<Car> findBetweenAndOrderedByPrice(LocalDate since, LocalDate to);
}
