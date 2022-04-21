package com.spring.ages.controller;

import com.spring.ages.dto.AgeDTO;
import com.spring.ages.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class AgesController {


    @GetMapping("/calculate/{day}/{month}")
    public String calculareAgePath(@PathVariable Integer day, @PathVariable Integer month, @RequestParam Integer year) {
        LocalDate born = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(born, now);
        return "age: " + period.getYears();

    }


    @GetMapping("/calculate")
    public ResponseEntity<AgeDTO> calculareAgePath(@RequestBody BornDTO born) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

}
