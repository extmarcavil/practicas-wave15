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
    public ResponseEntity<AgeDTO> calcAgePath( @RequestBody BornDTO born ){
        this.hola();
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.I_AM_A_TEAPOT);
    }

/*    @GetMapping("/calc/{day}/{month}")
    public String calcAgePath( @PathVariable Integer day, @PathVariable Integer month, @RequestParam(required = false) Integer year){
        LocalDate born = LocalDate.of(year, month,day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(born, now);
        return "age: " + Math.abs(period.getYears());
    }*/

    public String hola(){
        return "askld";
    }
}
