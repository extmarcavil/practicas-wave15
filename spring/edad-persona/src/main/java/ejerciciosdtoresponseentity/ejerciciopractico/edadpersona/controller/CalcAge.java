package ejerciciosdtoresponseentity.ejerciciopractico.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

@RestController
public class CalcAge {

    @GetMapping("/{day}/{month}/{year}")
    public Map<String,Integer> calcAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        LocalDate fecha=LocalDate.of(year,month,day);
        LocalDate actual=LocalDate.now();
        return Map.of("años",Period.between(fecha,actual).getYears());
    }

}
