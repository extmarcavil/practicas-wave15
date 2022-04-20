package com.example.helloword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping ("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola wachin: " + name;
    }
}
