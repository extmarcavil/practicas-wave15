package com.bootcamp.ages.controller;

import com.bootcamp.ages.dto.AgeDTO;
import com.bootcamp.ages.dto.BornDTO;
import com.fasterxml.jackson.datatype.jsr310.deser.key.PeriodKeyDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.*;

@RestController
@RequestMapping("/age")
public class CalcAgeController {

    @GetMapping("/calc/")
    public ResponseEntity<AgeDTO> calcAgePath(@RequestBody BornDTO born){
//obtains the current date from the system clock
        LocalDate curDate = LocalDate.now();
//calculates the difference betwween two dates
        Period period = Period.between(born.getBorn(), curDate);

        return new ResponseEntity<>(new AgeDTO(period.getYears()), HttpStatus.OK);
    }

}
