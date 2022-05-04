package com.digitalhouse.calculator.Controller;

import com.digitalhouse.calculator.dto.AgeDTO;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeCalculatorRestController {
    @GetMapping("/{day}/{month}/{year}")
    public AgeDTO getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
      AgeDTO ageDTO = new AgeDTO();
      ageDTO.setDate(day + "/" + month + "/" + year);
      ageDTO.setAge(this.calculateAge(day,month,year));
      return ageDTO;
    }

    private Integer calculateAge(Integer day,Integer month, Integer year) {
        Period age;
        try {
            LocalDate date = LocalDate.of(year,month,day);
            age = Period.between(date, LocalDate.now());
            return age.getYears();
        } catch (Exception e){
            return 0;
        }
    }
}



