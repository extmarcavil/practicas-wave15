package com.example.edadPersonaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class EdadPersonaController {
    @GetMapping(path = "{dia}/{mes}/{año}")
    public int devolverEdad(@PathVariable int dia,
                               @PathVariable int mes,
                               @PathVariable int año){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        String años = dtf.format(now);
        int devolver = Integer.parseInt(años);


        return devolver - año;

    }
       // Date date = new Date(System.currentTimeMillis());




    }

