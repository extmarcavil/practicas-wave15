package com.example.calculateage.controller;

import com.example.calculateage.dto.AgeDTO;
import com.example.calculateage.dto.bornDataDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalculateAge {

    // Ejemplo usando DTO, ResponseBody y ResponseEntity
    @GetMapping("/calculate")
    public ResponseEntity<AgeDTO> calculateAgePath(@RequestBody bornDataDTO bornData){
        LocalDate now = LocalDate.now();
        Period period = Period.between(bornData.getBirthDate(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

    // Ejemplo base.

    // @GetMapping("/calculate/{day}/{month}/{year}")
    // public int calculateAgePath(@PathVariable Integer day,
    //                             @PathVariable Integer month,
    //                             @PathVariable Integer year){
    //     return calculateAge(day, month, year);
    // }
    //
    // @GetMapping("/calculate")
    // public int calculateAgeRequest(@RequestParam Integer day,
    //                                @RequestParam Integer month,
    //                                @RequestParam Integer year){
    //     return calculateAge(day, month, year);
    // }
    //
    // private int calculateAge(Integer day, Integer month, Integer year){
    //     LocalDate birthDate = LocalDate.of(year, month, day);
    //     LocalDate today = LocalDate.now();
    //     if (birthDate.isAfter(today)){
    //         return 0;
    //     }
    //     return Period.between(birthDate, today).getYears();
    // }
}
