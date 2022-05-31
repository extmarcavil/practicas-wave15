package com.mercadolibre.lmaciel_deportistas_test.controller;


import com.mercadolibre.lmaciel_deportistas_test.dtos.PersonaDTO;
import com.mercadolibre.lmaciel_deportistas_test.entity.Deporte;
import com.mercadolibre.lmaciel_deportistas_test.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Primera implementacion de capa de servicio, aun no se maneja capa de repositorio

@RestController
public class DeportistasController {


    private final DeporteService deporteService;

    public DeportistasController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(deporteService.getAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> findSport(@PathVariable String name){
        return new ResponseEntity<>("Nivel: " +deporteService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonaDTO>> findSportsPersons(){

        return new ResponseEntity<>(deporteService.getSportPeople(), HttpStatus.OK);
    }




}
