package com.example.demo.controller;


import com.example.demo.model.NumerosRomanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NumerosRomanosController {

    @GetMapping("/convert/{decimal}")
    public String getDecimalNumber(@PathVariable Integer decimal){
        String romanNumber = convertToRoman(decimal);
        return romanNumber;
    }

    public static String convertToRoman(Integer decimal){
        NumerosRomanos roman = new NumerosRomanos(decimal);
        return roman.convert();
    }
}
