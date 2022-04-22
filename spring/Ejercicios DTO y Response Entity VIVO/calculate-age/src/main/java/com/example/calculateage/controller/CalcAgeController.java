package com.example.calculateage.controller;

import com.example.calculateage.dto.AgeDTO;
import com.example.calculateage.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

        @PostMapping("/calc")
        public ResponseEntity<AgeDTO> CalcAgePath(@RequestBody BornDTO born) {
            LocalDate now = LocalDate.now();
            Period period = Period.between(born.getBorn(), now);

            return new ResponseEntity<AgeDTO>(new AgeDTO(period.getYears()), HttpStatus.OK);
        }

}
