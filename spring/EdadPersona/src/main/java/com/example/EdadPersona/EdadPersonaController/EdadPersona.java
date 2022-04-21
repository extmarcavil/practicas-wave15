package com.example.EdadPersona.EdadPersonaController;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

@RestController
public class EdadPersona {

    @GetMapping("/calculadora/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable Integer day,
                            @PathVariable Integer month,
                            @PathVariable Integer year) {
        LocalDate nacimiento = LocalDate.of(year,month,day);
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento, hoy).getYears();
    }


    @GetMapping("/ping")
    public String ping(){
        return "pong";}
}
