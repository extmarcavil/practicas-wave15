package com.edadpersona.edadPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadPersonaController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public String calcularEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano){
        int edad = 0;
        String fechaNac = dia + "/" + mes + "/" + ano;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNac, formato);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        edad = periodo.getYears();

        String mensaje = "Tu edad es : " + edad;

        return mensaje;
    }
}
