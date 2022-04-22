package com.bootcamp.deportistas.controllers;

import com.bootcamp.deportistas.dtos.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {

    @GetMapping("/edadPersona/{day}/{month}/{year}")
    public int obtenerEdad (@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate fechaNacimiento = LocalDate.of(year, month,day);
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);
        return period.getYears();
    }
}
