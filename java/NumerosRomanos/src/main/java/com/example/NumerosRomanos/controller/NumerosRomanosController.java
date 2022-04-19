package com.example.NumerosRomanos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NumerosRomanosController {
    @GetMapping(value="/numero-romano/{numero}")
    public String returnNumeroRomano (@PathVariable int numero){
        StringBuilder numeroRomano = new StringBuilder();
        int times = 0;
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = numero / ints[i];
            numero = numero % ints[i];
            while (times > 0) {
                numeroRomano.append(romans[i]);
                times--;
            }
        }
        return numeroRomano.toString();
    }
    
    
}
