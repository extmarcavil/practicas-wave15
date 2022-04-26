package com.example.concesionaria.controller;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;
import com.example.concesionaria.service.IDealershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class DealershipController {

    private final IDealershipService service;

    public DealershipController(IDealershipService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Integer> createVehicle(@RequestBody VehicleDTO vehicle){
        return new ResponseEntity<>(service.createVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleResponseDTO>> getVehicles(){
        return new ResponseEntity<>(service.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesByManufacturingDate(@RequestParam String since,
                                                                                   @RequestParam String to){
        return new ResponseEntity<>(service.getVehiclesByManufacturingDate(LocalDate.parse(since),
                LocalDate.parse(to)), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesByPrice(@RequestParam double since,
                                                                       @RequestParam double to){
        return new ResponseEntity<>(service.getVehiclesByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleInformation(@PathVariable int id){
        return new ResponseEntity<>(service.getVehicleInformation(id), HttpStatus.OK);
    }

}

