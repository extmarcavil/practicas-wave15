package com.edadpersona.CalculadoraEdades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraEdadesController {
    @GetMapping("{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio){
        LocalDate fechaCumple= LocalDate.of(anio,mes,dia);
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaCumple,fechaActual);
        return period.getYears();
    }
}
