package com.example.concesionaria.repository;

import com.example.concesionaria.exceptions.NotFoundException;
import com.example.concesionaria.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VehiculoRepository implements IVehiculoRepository{
    Map<Integer, Car> repository;
    public VehiculoRepository(){
        repository = new HashMap<>();
    }

    @Override
    public Car crear(Car car) {
        int id = repository.size()+1;
        car.setId(id);
        repository.put(id, car);
        return repository.get(id);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Car findById(Integer id) {
        if(!repository.containsKey(id)){
            throw new NotFoundException("No existe vehiculo con id: " + id);
        }
        return repository.get(id);
    }

    @Override
    public List<Car> findBetweenAndOrderedByDate(LocalDate since, LocalDate to) {
        List<Car> carsFiltered = repository.values().stream().filter(c -> c.getManufacturingDate().isAfter(since) && c.getManufacturingDate().isBefore(to)).collect(Collectors.toList());
        return carsFiltered.stream().sorted(Comparator.comparing(Car::getManufacturingDate)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findBetweenAndOrderedByPrice(LocalDate since, LocalDate to) {
        List<Car> carsFiltered = repository.values().stream().filter(c -> c.getManufacturingDate().isAfter(since) && c.getManufacturingDate().isBefore(to)).collect(Collectors.toList());
        return carsFiltered.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
    }
}
