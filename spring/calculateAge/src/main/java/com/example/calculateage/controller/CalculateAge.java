package com.example.calculateage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculateAge {

    @GetMapping("/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate birthDate = LocalDate.of(year,month, day);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
}
