package com.meli.seguro.controller;

import com.meli.seguro.api.dto.*;
import com.meli.seguro.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    @GetMapping
    List<VehicleDto> getAllvehiclesWhitAccident(){
        return service.getWithAccidents();
    }

    @GetMapping("/all")
    List<VehicleOnlyDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/patentes")
    List<PatenteDto> getAllPatentes(@RequestParam(required = false) Integer cant,
                                    @RequestParam(required = false) Integer year){
        return service.getAllPatentes(cant,year );
    }

    @GetMapping("/patentesmarcas")
    List<PatenteMarcaDto> getAllPatentesMarcas(){
        return service.getAllPatentesMarcas();
    }

    @GetMapping("/patentesmarcasmodelo")
    List<VehiclePatenteMarcaModeloDto> getAllPatenteMarcaModelo(@RequestParam BigDecimal perdida){
        return service.getAllPatenteMarcaModelo(perdida);
    }





}
