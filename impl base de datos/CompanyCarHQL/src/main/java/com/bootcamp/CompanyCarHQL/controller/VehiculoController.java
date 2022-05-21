package com.bootcamp.CompanyCarHQL.controller;

import com.bootcamp.CompanyCarHQL.DTO.SiniestroDto;
import com.bootcamp.CompanyCarHQL.DTO.VehiculoDto;
import com.bootcamp.CompanyCarHQL.service.IVehiculoService;
import com.bootcamp.CompanyCarHQL.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {

    public IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/create_vehiculo")
    public ResponseEntity<VehiculoDto> createVehiculo(@RequestBody VehiculoDto vehiculo){
        return new ResponseEntity<>(vehiculoService.crearVehiculo(vehiculo), HttpStatus.OK);
    }

    @GetMapping("/obtener_lista/vehiculos")
    public ResponseEntity<List<VehiculoDto>> getAllVehiculos(){
        return new ResponseEntity<>(vehiculoService.getAllVehiculos(), HttpStatus.OK);
    }


}
