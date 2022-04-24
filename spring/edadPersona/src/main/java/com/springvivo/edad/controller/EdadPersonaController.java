package com.springvivo.edad.controller;

import com.springvivo.edad.dto.EdadDTO;
import com.springvivo.edad.dto.NacimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/edad")
public class EdadPersonaController {

    // Antes de ver DTO, usando PathVariable
    @GetMapping("/calc/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdadPath(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
            String fecha = dia + "/" + mes + "/" + anio;
            return new ResponseEntity<>(calcEdad(fecha), HttpStatus.OK);
    }

    // Antes de ver DTO, usando RequestParam
    @GetMapping("/calcParam/")
    public ResponseEntity<String> calcularEdadRequestP(@RequestParam String fechaNacimiento){
            return new ResponseEntity<>(calcEdad(fechaNacimiento), HttpStatus.OK);
    }

    // Despues de ver DTO y usando RequestBody
    @GetMapping("/calcDTO/")
    public ResponseEntity<EdadDTO> calcularEdadDTO(@RequestBody NacimientoDTO nacimiento){
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(nacimiento.getNacimiento(), now);
        return new ResponseEntity<>(new EdadDTO(periodo.getYears()), HttpStatus.OK);
    }



    private String calcEdad(String fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha, formato);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
         return "Edad: " + edad.getYears();
    }



}
