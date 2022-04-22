package com.example.calculadoraCalorias.controller;


import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.services.IService;
import com.example.calculadoraCalorias.services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller{

    //Inyeccion de dependencias
    IService service;
    public Controller( IService service){
        this.service = service;
    }

    @GetMapping(path = "/{plato}")
    public ResponseEntity<DtoIngrediente> getCalorias(@PathVariable String plato){
        return new ResponseEntity<>(service.getCantidadCalorias(), HttpStatus.OK);

    }
}

