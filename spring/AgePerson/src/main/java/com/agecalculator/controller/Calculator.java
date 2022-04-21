package com.agecalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class Calculator {

    @GetMapping(path = "/{day}/{month}/{year}")
    public Integer getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {

        LocalDate localDate = LocalDate.now();
        int actYear = localDate.getYear();
        int actMonth = localDate.getMonthValue();
        int actDay = localDate.getDayOfMonth();

        int age = actYear - year;

        if (actMonth <= month && actDay < day)
            age -= 1;

        return age;
    }
}
