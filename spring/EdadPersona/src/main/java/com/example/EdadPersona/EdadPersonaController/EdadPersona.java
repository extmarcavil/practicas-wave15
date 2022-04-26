package com.example.EdadPersona.EdadPersonaController;

import com.example.EdadPersona.dto.AgeDTO;
import com.example.EdadPersona.dto.BornDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

@RestController
public class EdadPersona {

    @GetMapping("/calculadora")
    public ResponseEntity<AgeDTO> calcularEdad(@RequestBody BornDTO nacimiento) {
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(nacimiento.getNacimiento(), hoy);
        return new ResponseEntity<>(new AgeDTO(edad.getYears()), HttpStatus.OK) ;
    }

   /*
    @GetMapping("/calculadora/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable Integer day,
                            @PathVariable Integer month,
                            @PathVariable Integer year) {
        LocalDate nacimiento = LocalDate.of(year,month,day);
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento, hoy).getYears();
    }
    */

    @GetMapping("/ping")
    public String ping(){
        return "pong";}
}
