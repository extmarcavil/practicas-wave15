package com.bootcamp.edad.controller;

import com.bootcamp.edad.dto.AgeDTO;
import com.bootcamp.edad.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc")
    public ResponseEntity<AgeDTO> calcAgePath(@RequestBody BornDTO born ){
        LocalDate now = LocalDate.now();
        Period period = Period.between(born.getBorn(), now);
        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.I_AM_A_TEAPOT);
    }

}
