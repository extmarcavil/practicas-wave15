package com.bootcamp.calculadoradecalorias.controller;

import com.bootcamp.calculadoradecalorias.dto.PlatoCaloriasDTO;
import com.bootcamp.calculadoradecalorias.service.CalculadoraService;
import com.bootcamp.calculadoradecalorias.service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    private ICalculadoraService calculadoraService;

    public CalculadoraController(ICalculadoraService calculadoraService){

        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/{name}/{peso}")
    public ResponseEntity<PlatoCaloriasDTO> getPlato(@PathVariable String name, @PathVariable Integer peso){

        return new ResponseEntity<>(calculadoraService.getPlato(name, peso), HttpStatus.OK);
    }


}
