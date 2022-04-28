package com.example.concesionaria.service;

import com.example.concesionaria.dto.CarDTO;
import com.example.concesionaria.dto.CarWithoutServicesDTO;
import com.example.concesionaria.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoService {
    CarDTO crear(Car car);
    List<CarWithoutServicesDTO> findAll();
    CarDTO findById(Integer id);
    List<CarWithoutServicesDTO> findBetweenAndOrderedByDate(LocalDate since, LocalDate to);
    List<CarWithoutServicesDTO> findBetweenAndOrderedByPrice(LocalDate since, LocalDate to);
}
