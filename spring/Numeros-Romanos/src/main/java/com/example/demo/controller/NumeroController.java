package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NumeroController {

    @GetMapping("/decimal-a-romano/{numeroDecimal}")
    public String getNumeroRomano(@PathVariable Integer numeroDecimal){
        Map<Integer, String> decimalARomano = new HashMap<>();
        decimalARomano.put(1, "I");
        decimalARomano.put(2, "II");
        decimalARomano.put(3,"III");
        decimalARomano.put(4, "IV");
        decimalARomano.put(5, "V");
        decimalARomano.put(7,"VII");
        decimalARomano.put(10, "X");
        decimalARomano.put(13, "XIII");
        decimalARomano.put(50,"L");
        decimalARomano.put(100, "C");
        decimalARomano.put(500, "D");
        decimalARomano.put(1000,"M");
        return decimalARomano.getOrDefault(numeroDecimal, "Parámetro " + numeroDecimal + " inválido");
    }
}