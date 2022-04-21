package com.EdadPersona.EdadPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class EdadController {

    @GetMapping("/number/{diaNacido}/{mesNacido}/{añoNacido}")
    public int getEdad(@PathVariable int diaNacido, @PathVariable int mesNacido, @PathVariable int añoNacido ) {
        return findAge(diaNacido, mesNacido, añoNacido);
    }

    int findAge( int diaNacido, int mesNacido, int añoNacido){

        Calendar obj = Calendar.getInstance();

        int dia = obj.get(Calendar.DAY_OF_MONTH);
        int mes = obj.get(Calendar.MONTH);
        int año = obj.get(Calendar.YEAR);

        if (diaNacido > dia) {
            mes = mes - 1;
        }

        if (mesNacido > mes) {
            año = año - 1;
        }

        int calculated_year = año - añoNacido;
        System.out.println(calculated_year);
        return calculated_year;

    }
}
