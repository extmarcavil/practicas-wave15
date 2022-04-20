package com.example.ejercicioEdadPersona.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
public class CalculoEdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public String calcularEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String año){
        try {
            var fechaNacimiento = año + "-" + mes + "-" + dia;

            var fechaNac = LocalDate.parse(fechaNacimiento);

            var actual = LocalDate.now();

            var edad = Math.abs(DAYS.between(actual, fechaNac) / 365);

            return "Tiene " + edad + " años";
        }
        catch (Exception ex){
            return "Ocurrio un error en el proceso";
        }
    }

}
