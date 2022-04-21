package com.example.demo.controller;

import com.example.demo.dto.AgeDTO;
import com.example.demo.dto.BornDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class controller {

    //    @GetMapping("/edad/{year}")
    //    public int edad (@PathVariable int year,@RequestParam int month, @RequestParam int day ){
    //
    //        return Period.between(LocalDate.of(year,month,day), LocalDate.now()).getYears();
    //    }

    @GetMapping("/calc")
    public ResponseEntity<AgeDTO> edad (@RequestBody BornDTO born){
        Period  period = Period.between(LocalDate.of(born.getYear(),born.getMonth(),born.getDay()), LocalDate.now());
        return new ResponseEntity<AgeDTO>(new AgeDTO(period.getYears()),HttpStatus.OK);
    }

}
