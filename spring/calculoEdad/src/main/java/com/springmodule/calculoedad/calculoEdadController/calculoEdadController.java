package com.springmodule.calculoedad.calculoEdadController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;


@RestController
public class calculoEdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public int calculadoraEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        LocalDate hoy = LocalDate.now();
        int diferencia = Period.between(fechaNac, hoy).getYears();
        return diferencia;
    }
}
