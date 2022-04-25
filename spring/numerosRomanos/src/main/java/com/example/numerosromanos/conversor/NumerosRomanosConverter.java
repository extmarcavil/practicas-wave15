package com.example.numerosromanos.conversor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosConverter {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping("/convert/{value}")
    public String change(@PathVariable int value){
        int numero = value;
        StringBuilder result = new StringBuilder();
        for (int i=0; i<values.length; i++){
            while(numero >= values[i]){
                numero -= values[i];
                result.append(romans[i]);
            }
        }
        return result.toString();
    }
}
