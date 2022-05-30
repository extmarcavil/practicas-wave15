package com.example.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //Anotacion - Componente de SpringBoot
public class HelloWorld {

    @GetMapping("/hello/{name}") //Endpoint
    public String hello(@PathVariable String name){
        return "Hello " + name + "!";
    }
}

//La URL quedaria: localhost:8080/name/<nombre>
