package com.edadpersona.edaddeunapersona.controller;

import com.edadpersona.edaddeunapersona.dto.AgeDto;
import com.edadpersona.edaddeunapersona.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/age") //Esta java notation nos agrega /age en todas las urls dentro de la clase a utilizar.
public class EdadController {



    @GetMapping("/calc")
    public ResponseEntity<AgeDto> calcAgePath(@RequestBody BornDTO born){
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(),now);
        return new ResponseEntity<>(new AgeDto(period.getYears()), HttpStatus.I_AM_A_TEAPOT);
    }



    @GetMapping("/{dia}/{mes}/{ano}")
    private String calculaEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        //LocalDate fecha = LocalDate.of(ano,mes,dia);
        return  "age: " + ChronoUnit.YEARS.between(LocalDate.of(ano,mes,dia),LocalDate.now());
    }
}

/*
   private ResponseEntity<Long> calculaEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return new ResponseEntity<Long>(ChronoUnit.YEARS.between(LocalDate.of(ano,mes,dia),LocalDate.now()), HttpStatus.ACCEPTED);
 */
