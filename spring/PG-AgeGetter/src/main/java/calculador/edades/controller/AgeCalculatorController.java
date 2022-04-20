package calculador.edades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@RestController
@RequestMapping("/convert")
public class AgeCalculatorController {

    @GetMapping("/latinAmerica/{day}/{month}/{year}")
    public int getBirthDay(@PathVariable int day,@PathVariable int month,@PathVariable int year){
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }
}
