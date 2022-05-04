package com.spring.ejercicioedadpersona.controllers;

import com.spring.ejercicioedadpersona.dto.AgeDTO;
import com.spring.ejercicioedadpersona.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

@RestController
public class ObtenerEdadController {

    @GetMapping("/calc")
    public ResponseEntity<AgeDTO> calcAgePath(@RequestBody BornDTO born) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

    /*
    @GetMapping("{dia}/{mes}/{anio}")
    public int obtenerEdad(@PathVariable int dia,
                           @PathVariable int mes,
                           @PathVariable int anio) {
        int edad = 0;

        int diaActual = Calendar.getInstance().get(Calendar.DATE);
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);

        if (mes > mesActual || (mes == mesActual && dia < diaActual)) {
            edad = anioActual - anio -1;
        } else {
            edad = anioActual - anio;
        }

        return edad;
    }

     */
}
