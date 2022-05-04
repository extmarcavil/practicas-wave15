package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc/{day}/{month}/{year}")
    public String calcAgePath(@PathVariable Integer day,
                              @PathVariable Integer month,
                              @PathVariable Integer year){
        int edad;
        LocalDate fechaNac = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        /*edad = now.getYear() - fechaNac.getYear();
        if(now.getDayOfYear() < fechaNac.getDayOfYear()){
            edad--;
        }*/
        Period period = Period.between(fechaNac, now);
        edad = period.getYears();
        return "La edad de la persona es: " + edad;
    }
}
