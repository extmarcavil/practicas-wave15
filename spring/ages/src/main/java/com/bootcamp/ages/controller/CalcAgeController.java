package com.bootcamp.ages.controller;

import com.fasterxml.jackson.datatype.jsr310.deser.key.PeriodKeyDeserializer;
import org.springframework.web.bind.annotation.*;
import java.time.*;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc/{day}/{month}/{year}")
    public String calcAgePath(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){

        LocalDate dob = LocalDate.of(year, month, day);
//obtains the current date from the system clock
        LocalDate curDate = LocalDate.now();
//calculates the difference betwween two dates
        Period period = Period.between(dob, curDate);

        int ano = period.getYears();
        return "age: " + ano;
    }
    
}
