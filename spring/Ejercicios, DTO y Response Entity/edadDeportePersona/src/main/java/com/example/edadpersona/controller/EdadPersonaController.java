package com.example.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.*;

@RestController
public class EdadPersonaController {

    @GetMapping("/{day}/{month}/{year}")
    public Long getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);
        return YEARS.between(fechaNacimiento, hoy);
    }

}
