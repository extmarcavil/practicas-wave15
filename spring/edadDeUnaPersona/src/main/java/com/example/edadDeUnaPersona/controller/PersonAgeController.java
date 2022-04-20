package com.example.edadDeUnaPersona.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@RestController
public class PersonAgeController {

    @GetMapping(value="/{day}/{month}/{year}")
    public String calcularEdad (@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        StringBuilder fechaDeUser = new StringBuilder();
        fechaDeUser.append(day).append("/").append(month).append("/").append(year);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacParseada = LocalDate.parse(fechaDeUser, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNacParseada, ahora);

        if (periodo.getDays() < 1) {
            return "Tu no has nacido todavía!";
        } else {
            return "Tu edad es: " + periodo.getYears() +  " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " días";
        }
    }
}
