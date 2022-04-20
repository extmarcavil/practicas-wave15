package com.spring.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class NumerosRomanosController {

    @GetMapping("/numeroRomano/{numero}")
    public String convertirANumerosRomanos(@PathVariable Integer numero) {
        return convertir(numero);
    }

    private String convertir(Integer numero) {
        StringBuilder numeroRomano = new StringBuilder();
        int[] numerosAComparar = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numerosAComparar.length; i++)
            for (;numero >= numerosAComparar[i]; numero -= numerosAComparar[i])
                numeroRomano.append(numerosRomanos[i]);

        return numeroRomano.toString();
    }
}
