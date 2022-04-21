package ar.com.alehenestroza.apiedadpersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {
    @GetMapping("/{day}/{month}/{year}")
    public int getEdad(@PathVariable int day,
                          @PathVariable int month,
                          @PathVariable int year) {
        LocalDate nacido = LocalDate.of(year, month, day);
        int edad = Period.between(nacido, LocalDate.now()).getYears();
        return Math.abs(edad);
    }
}
