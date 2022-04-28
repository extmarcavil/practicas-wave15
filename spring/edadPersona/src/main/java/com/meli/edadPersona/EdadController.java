package com.meli.edadPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{year}")
    public ResponseEntity<AgeDTO> calculoEdad (@PathVariable int dia,@PathVariable int mes,@PathVariable int year) {
        LocalDate fecha = LocalDate.of(year, mes, dia);
        LocalDate ahora = LocalDate.now();

        Period period = Period.between(fecha, ahora);

        System.out.println("La diferencia de años es " + period.getYears());

        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);

    }
}
