package com.bootcamp.ages.controller;

import com.bootcamp.ages.dto.AgeDTO;
import com.bootcamp.ages.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/age")
public class CalcAgeController {


    @GetMapping("/calc")
        public ResponseEntity<AgeDTO> calcularEdad(@RequestBody BornDTO bornDTO){
            LocalDate now = LocalDate.now();

            Period periodo = Period.between(bornDTO.getBorn(), now);

            return new ResponseEntity<>(new AgeDTO(periodo.getYears()), HttpStatus.ACCEPTED);
        }

        /*public String calcularEdad(@PathVariable Integer day, @PathVariable Integer month, @RequestParam Integer year){
            LocalDate born = LocalDate.of(year, month, day);
            LocalDate now = LocalDate.now();

            Period periodo = Period.between(born, now);

            return "age: " + periodo.getYears();
        }*/
}
