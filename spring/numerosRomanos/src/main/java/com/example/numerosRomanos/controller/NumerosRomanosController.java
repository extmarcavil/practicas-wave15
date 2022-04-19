package com.example.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String intToRoman(@PathVariable int numero){
        String romano = "";
        int[] limites = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < limites.length; i++) {
            while (numero >= limites[i]) {
                numero -= limites[i];
                romano += numerosRomanos[i];
            }
        }

        return romano;
    }
}
