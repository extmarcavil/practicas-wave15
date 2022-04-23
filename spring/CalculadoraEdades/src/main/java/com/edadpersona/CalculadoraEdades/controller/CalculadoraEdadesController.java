package com.edadpersona.CalculadoraEdades.controller;

import com.edadpersona.CalculadoraEdades.dto.BornDTO;
import com.edadpersona.CalculadoraEdades.dto.EdadDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraEdadesController {
    @GetMapping("/")
    public EdadDTO calcularEdad(@RequestBody BornDTO born){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(born.getFecha(),fechaActual);
        return new EdadDTO(period.getYears());
    }
}
