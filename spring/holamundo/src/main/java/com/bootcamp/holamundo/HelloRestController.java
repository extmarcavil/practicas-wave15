package com.bootcamp.holamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/{name}")
    public String holamundo(@PathVariable String name){
        return "Hola Mundo!, y hola ti: " + name +" <3";
    }
}
