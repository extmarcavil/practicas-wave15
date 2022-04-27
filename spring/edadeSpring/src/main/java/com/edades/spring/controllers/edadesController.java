package com.edades.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@RestController
public class edadesController {


    @GetMapping("{dia}/{mes}/{año}")
    public int calculaEdad(@PathVariable int dia , @PathVariable int mes, @PathVariable int año){

        Calendar fecha = Calendar.getInstance();

        fecha.set(año,mes,dia);

        Calendar fechaHoy =Calendar.getInstance();
        System.out.println(fecha.get(Calendar.YEAR));
        System.out.println(fechaHoy.get(Calendar.YEAR));


    }




}
