package com.example.edadpersonaapi.controller;

import com.example.edadpersonaapi.dto.AgeDTO;
import com.example.edadpersonaapi.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping()
    public ResponseEntity<AgeDTO> calcAge (@RequestBody BornDTO born) {
        Period age = Period.between(born.getBorn(), LocalDate.now());

        return new ResponseEntity<>(new AgeDTO(age.getYears()), HttpStatus.OK);
    }

    @GetMapping("/{day}/{month}/{year}")
    public int calcAge (@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        Period age = Period.between(LocalDate.of(year, month, day), LocalDate.now());

        return age.getYears();
    }
}
