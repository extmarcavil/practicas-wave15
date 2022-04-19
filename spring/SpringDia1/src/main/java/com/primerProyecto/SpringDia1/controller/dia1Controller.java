package com.primerProyecto.SpringDia1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dia1Controller {


    @GetMapping("hello/{nombre}")
    public String hello(@PathVariable String nombre){

        return "Hola po "+ nombre;
    }

}
