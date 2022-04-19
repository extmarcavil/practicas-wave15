package com.bootcamp.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorld {

    @GetMapping("/{number}")
    public String convertToRoman(@PathVariable Integer number){

        Map<Integer,String> listaNumeros = new HashMap<>();
        listaNumeros.put(1,"I");
        listaNumeros.put(2,"II");
        listaNumeros.put(3,"III");
        listaNumeros.put(4,"IV");
        listaNumeros.put(5,"V");
        listaNumeros.put(7,"VII");
        listaNumeros.put(10,"X");
        listaNumeros.put(13,"XIII");
        listaNumeros.put(50,"L");
        listaNumeros.put(100,"C");
        listaNumeros.put(500,"D");
        listaNumeros.put(1000,"M");

        if(listaNumeros.containsKey(number))
            return listaNumeros.get(number);

        else{return "No se puede transformar tal número";}
    }
}
