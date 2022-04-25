package com.spring.calculadoraCalorias.controller;

import com.spring.calculadoraCalorias.dto.PlatoDTO;
import com.spring.calculadoraCalorias.service.CalculadoraCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraCaloriasController {

    @Autowired
    private CalculadoraCaloriasService service;

    @GetMapping("/food/{name}/{peso}")
    public ResponseEntity<PlatoDTO> getFood(@PathVariable String name, @PathVariable double peso){
        PlatoDTO plato = service.getPlato(name, peso);

        return new ResponseEntity<>(plato, HttpStatus.OK);
    }
}
