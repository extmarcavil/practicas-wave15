package com.postman.codigomorse.controller;

import com.postman.codigomorse.logic.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/convert")
public class Conversor {

    @GetMapping("/{morseCodePhrase}")
    public String getMorseCode(@PathVariable String palabraEncriptada){

        CodigoMorse codigoMorse = new CodigoMorse(palabraEncriptada);

        return codigoMorse.convertir();
    }

}
