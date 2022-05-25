package com.example.hql_seguros_auto.controller;

import com.example.hql_seguros_auto.dto.SinisterDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehicleSinisterDTO;
import com.example.hql_seguros_auto.entity.Sinister;
import com.example.hql_seguros_auto.service.ISinisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SinisterController {
    private final ISinisterService service;

    public SinisterController(ISinisterService service) {
        this.service = service;
    }

    /**
     * Guardar un siniestro.
     * Si no se envía un id de vehículo, se crea uno.
     *
     * @param sinisterDTO Datos del siniestro
     * @return ResponseEntity
     */
    @PostMapping("")
    public ResponseEntity<Sinister> saveSinister(@RequestBody SinisterDTO sinisterDTO){
        return new ResponseEntity<>(service.saveSinister(sinisterDTO), HttpStatus.OK);
    }

    /**
     * Obtener todos los siniestros.
     *
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<List<SinisterDTO>> getSinisters(){
        return new ResponseEntity<>(service.getSinisters(), HttpStatus.OK);
    }

    /**
     * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
     * con pérdida mayor de 10000 pesos.
     *
     * @return ResponseEntity
     */
    @GetMapping("/mayor_perdida")
    public ResponseEntity<List<VehiclePlateBrandModelDTO>> getVehiclesWithEconomicLossGreaterThan10000(){
        return new ResponseEntity<>(service.getVehiclesWithEconomicLossGreaterThan10000(), HttpStatus.OK);
    }

    /**
     * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
     * mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
     *
     * @return ResponseEntity
     */
    @GetMapping("/mayor_perdida_total")
    public ResponseEntity<VehicleSinisterDTO> getVehiclesWithEconomicLossGreaterThan10000AndTotal(){
        return new ResponseEntity<>(service.getVehiclesWithEconomicLossGreaterThan10000AndTotal(), HttpStatus.OK);
    }
}
