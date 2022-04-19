package com.spring.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping
    public String hello() {
        return "Hola mundo";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hola " + name + "!!!";
    }
}
