package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.PlatoMuestraDTO;
import com.example.calculadoracalorias.service.ICalculadoraCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/platos")
public class CalculadoraCaloriasController {
    @Autowired
    ICalculadoraCaloriasService service;

    @GetMapping("/{nombre}/{peso}")
    public ResponseEntity<PlatoMuestraDTO> devolverInfoPlato(@PathVariable String nombre, @PathVariable Integer peso){
        return new ResponseEntity<>(service.getInfoPlato(nombre, peso), HttpStatus.OK);
    }
}
