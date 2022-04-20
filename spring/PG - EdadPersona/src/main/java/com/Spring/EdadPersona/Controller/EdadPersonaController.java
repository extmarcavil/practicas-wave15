package com.Spring.EdadPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable String dia,
                          @PathVariable String mes,
                          @PathVariable String anio){
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(dia + "/" + mes + "/" + anio, formato);
        LocalDate fechaHoy = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaHoy);

        return "La edad de la persona es " + periodo.getYears() + "años.";

    }
}
