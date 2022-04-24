package com.meli.cumple;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CumpleController {
    @GetMapping("/cumple")
    public ResponseEntity<AgeDTO> calculoEdad (@RequestBody CumpleDTO cumple) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(cumple.getNacimiento(), fechaActual);
        return new ResponseEntity<>(new AgeDTO(periodo.getYears()), HttpStatus.OK);
    }

    @GetMapping("/informacion")
    ResponseEntity<String> hello () {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
