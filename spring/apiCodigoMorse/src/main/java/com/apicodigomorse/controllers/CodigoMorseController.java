package com.apicodigomorse.controllers;

import com.apicodigomorse.services.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    private  CodigoMorseService _codigoMorseService;

    public CodigoMorseController() {
        this._codigoMorseService = new CodigoMorseService();
    }

    //region end points
    @GetMapping("/codigomorse/asciimorse/{original}")
    public  String asciiMorse(@PathVariable String original){
        return  "El codigo morse es: " + _codigoMorseService.codificarMorse(original);
    }
    @GetMapping("/codigomorse/morseascii/{codificado}")
    public  String morseAscii(@PathVariable String codificado){
        return  "El codigo ascii es: " + _codigoMorseService.decodificarMorse(codificado);
    }

    //endregion
}
