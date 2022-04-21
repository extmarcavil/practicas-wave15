package com.example.calcularedad.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/calcular")
public class CalcularEdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable Integer dia,
                                  @PathVariable Integer mes,
                                  @PathVariable Integer anio){
        LocalDate fecha;

        try {
            fecha = LocalDate.of(anio,mes,dia);
        } catch (DateTimeException dateTimeException){
            return 0;
        }

        return Period.between(fecha, LocalDate.now()).getYears();
    }
}
