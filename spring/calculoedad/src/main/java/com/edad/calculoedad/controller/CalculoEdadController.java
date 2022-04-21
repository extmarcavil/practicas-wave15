package com.edad.calculoedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class CalculoEdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public String calculoEdad(@PathVariable String dia,
                              @PathVariable String mes,
                              @PathVariable String año){

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String envioFechaNacimiento = dia + "/" + mes + "/" + año;
        LocalDate fechaNacimiento = LocalDate.parse(envioFechaNacimiento, format);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return "Tu edad es: " + periodo.getYears();
    }
}
