package com.ejercicio.romanos.controller;

import com.ejercicio.romanos.service.RomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @Autowired
    private RomanosService romanosService;

    @GetMapping("/romanos/{number}")
    public String calcularRomano(@PathVariable int number){
        return romanosService.calcularRomanos(number);
    }
}
