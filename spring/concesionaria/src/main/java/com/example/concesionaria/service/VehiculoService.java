package com.example.concesionaria.service;

import com.example.concesionaria.dto.CarDTO;
import com.example.concesionaria.dto.CarWithoutServicesDTO;
import com.example.concesionaria.model.Car;
import com.example.concesionaria.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    private IVehiculoRepository vehiculoRepository;
    private ModelMapper mapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public CarDTO crear(Car car) {
        Car newCar = vehiculoRepository.crear(car);
        CarDTO carDTO = new CarDTO();
        mapper.map(newCar, carDTO);
        return carDTO;
    }

    @Override
    public List<CarWithoutServicesDTO> findAll() {
        return vehiculoRepository.findAll()
                .stream()
                .map(c ->
                {
                    CarWithoutServicesDTO carDTO = new CarWithoutServicesDTO();
                    mapper.map(c, carDTO);
                    return carDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO findById(Integer id) {
        Car newCar = vehiculoRepository.findById(id);
        CarDTO carDTO = new CarDTO();
        mapper.map(newCar, carDTO);
        return carDTO;
    }

    @Override
    public List<CarWithoutServicesDTO> findBetweenAndOrderedByDate(LocalDate since, LocalDate to) {
        return vehiculoRepository.findBetweenAndOrderedByDate(since, to)
                                    .stream()
                                    .map(c ->
                                    {
                                        CarWithoutServicesDTO carDTO = new CarWithoutServicesDTO();
                                        mapper.map(c, carDTO);
                                        return carDTO;
                                    })
                                    .collect(Collectors.toList());
    }

    @Override
    public List<CarWithoutServicesDTO> findBetweenAndOrderedByPrice(LocalDate since, LocalDate to) {
        return vehiculoRepository.findBetweenAndOrderedByPrice(since, to)
                                    .stream()
                                    .map(c ->
                                    {
                                        CarWithoutServicesDTO carDTO = new CarWithoutServicesDTO();
                                        mapper.map(c, carDTO);
                                        return carDTO;
                                    })
                                    .collect(Collectors.toList());
    }
}
