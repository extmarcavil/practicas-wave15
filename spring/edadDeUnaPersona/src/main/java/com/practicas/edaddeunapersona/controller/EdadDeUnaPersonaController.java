package com.practicas.edaddeunapersona.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadDeUnaPersonaController {
    @GetMapping("{day}/{month}/{year}")
    public String getEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        try {
            LocalDate fecha = LocalDate.of(year, month, day);
            return ChronoUnit.YEARS.between(fecha, LocalDate.now()) + " años";
        }
        catch (DateTimeException e){
            return e.getMessage();
        }
    }
}
