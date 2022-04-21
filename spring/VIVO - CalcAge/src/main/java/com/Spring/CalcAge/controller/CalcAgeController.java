package com.Spring.CalcAge.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;


@RestController
@RequestMapping("/age")
public class CalcAgeController {
    
   @GetMapping("/calc/{day}/{month}")
    public String calcAgePath(@PathVariable Integer day, @PathVariable Integer month, @RequestParam Integer year){

       LocalDate born = LocalDate.of(year, month, day);
       LocalDate now = LocalDate.now();
       Period period = Period.between(born, now);

       return "Age: " + period.getYears();
   }
    
    
}
