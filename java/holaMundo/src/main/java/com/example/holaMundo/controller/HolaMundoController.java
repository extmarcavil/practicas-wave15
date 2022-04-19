package com.example.holaMundo.controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    //endPoint

    //En el puerto 8080 va a dar una api que va directo a la raiz de nuestra URL y va a responder a este REQUEST
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name + "!!";
    }
}
