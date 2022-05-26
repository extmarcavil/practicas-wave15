package com.meli.seguro.controller;

import com.meli.seguro.entity.Vehicle;
import com.meli.seguro.api.dto.VehicleDto;
import com.meli.seguro.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    @GetMapping
    List<Vehicle> getAllvehiclesWhitAccident(){
        return service.getWithAccidents();
    }

    @GetMapping("/all")
    List<VehicleDto> getAll(){
        return service.getAll();
    }
}
