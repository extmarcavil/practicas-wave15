package com.example.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    // ARMANDO ENDPOINT (SIEMPRE DENTRO DE UN CONTROLADOR)

    @GetMapping("/hello/{name}")// AGREGAMOS EL GETMAPPING
    public String hello(@PathVariable String name){ // UTILIZAMOS PARÁMETROS PARA PERSONALIZAR EL SALUDO
        return "Hola " + name + "!!!!";
    }

}
