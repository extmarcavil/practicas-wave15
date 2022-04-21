package com.vparula.edad.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadApplicationController {


    @GetMapping("/{day}/{month}/{year}")
    public int getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
       return getAge(day,month,year);
    }

    @GetMapping("/rqst")
    public int getEdadRqst(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year){
        return getAge(day,month,year);
    }

    public int getAge(Integer day, Integer month, Integer year){
        Period edad = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        return edad.getYears();
    }
}
