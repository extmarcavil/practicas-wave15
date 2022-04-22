package com.bootcamp.age.controller;

import com.bootcamp.age.dto.AgeDTO;
import com.bootcamp.age.dto.BornDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc/{day}/{month}/{year}")
    public ResponseEntity<AgeDTO> calcAgePath(@RequestBody BornDTO born){
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

    /*@GetMapping("/calc/{day}/{month}/{year}")
    public String calcAgePath(@PathVariable Integer day, @PathVariable Integer month, @RequestParam(required = false) Integer year){
        LocalDate born = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(born, now);
        return "age: " + period.getYears();
    }*/


}
