package com.example.edadDeUnaPersona.controller;

import com.example.edadDeUnaPersona.dto.BornDTO;
import com.example.edadDeUnaPersona.dto.PersonAgeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;


@RestController
public class PersonAgeController {

    @GetMapping("/calc")
    public ResponseEntity<PersonAgeDTO> calcularAge (@RequestBody BornDTO born) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        PersonAgeDTO body = new PersonAgeDTO(period.getYears());
        ResponseEntity<PersonAgeDTO> resultado = ResponseEntity.status(200).body(body);

        return resultado;
    }

    /*@GetMapping(value="/{day}/{month}/{year}")
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
    }*/
}
