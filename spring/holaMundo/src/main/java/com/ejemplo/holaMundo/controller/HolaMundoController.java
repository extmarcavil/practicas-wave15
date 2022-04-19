package com.ejemplo.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name + " !!!";
    }
    @GetMapping("/")
    public String inicio(){
        return "Pagina de inicio";
    }
}