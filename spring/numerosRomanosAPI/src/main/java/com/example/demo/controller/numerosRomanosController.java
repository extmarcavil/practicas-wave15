package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class numerosRomanosController {
    
    @GetMapping(value="/numerosRomanos/{numero}")
    public String param(@PathVariable int numero) {

        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letras = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romano = "";

        for(int i = 0;i< letras.length;i++){

            int numeroAux = numero / numeros[i];

            for(int j = 0;j<numeroAux;j++){
                romano += letras[i];
                numero -= numeros[i];
            }

        }

        return romano;

    }


    
}
