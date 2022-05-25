package com.example.hql_seguros_auto.controller;

import com.example.hql_seguros_auto.dto.VehiclePlateBrandDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateDTO;
import com.example.hql_seguros_auto.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehicleController {
    private final IVehicleService service;

    public VehicleController(IVehicleService service) {
        this.service = service;
    }

    /**
     * Listar las patentes de todos los vehículos registrados.
     *
     * @return ResponseEntity
     */
    @GetMapping("/patentes")
    public ResponseEntity<List<VehiclePlateDTO>> getVehiclesPlate(){
        return new ResponseEntity<>(service.getVehiclesPlate(), HttpStatus.OK);
    }

    /**
     * Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
     *
     * @return ResponseEntity
     */
    @GetMapping("/patentes_marcas")
    public ResponseEntity<List<VehiclePlateBrandDTO>> getVehiclesPlateBrandOrderByFabricationYear(){
        return new ResponseEntity<>(service.getVehiclesPlateBrandOrderByFabricationYear(), HttpStatus.OK);
    }

    /**
     * Listar la patente de todos los vehículos que tengan más de cuatro ruedas
     * y hayan sido fabricados en el corriente año.
     *
     * @return ResponseEntity
     */
    @GetMapping("/cuatro_ruedas_este_año")
    public ResponseEntity<List<VehiclePlateDTO>> getVehiclesFourWheelsFabricatedThisYear(){
        return new ResponseEntity<>(service.getVehiclesFourWheelsFabricatedThisYear(), HttpStatus.OK);
    }
}
