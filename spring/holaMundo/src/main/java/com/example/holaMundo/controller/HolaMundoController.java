package com.example.holaMundo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name + "!";
    }

    @GetMapping("/hello")
    ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hola Mundo desde una respuesta HTTP!", HttpStatus.OK);
    }
}
