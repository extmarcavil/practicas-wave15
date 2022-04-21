package com.modulo6.ages.controller;

import com.modulo6.ages.dto.AgeDTO;
import com.modulo6.ages.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc")
    public ResponseEntity<AgeDTO> calAgePath(@RequestBody BornDTO born){

        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);

        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }


    //Ejercicio parte 1 sin DTO
//    @GetMapping("/calc/{day}/{month}")
//    public String calAgePath(@PathVariable Integer day, @PathVariable Integer month, @RequestParam Integer year){
//
//        LocalDate born = LocalDate.of(year, month, day);
//        LocalDate now = LocalDate.now();
//        Period period = Period.between(born, now);
//
//        return "age: " + period.getYears();
//    }


}
