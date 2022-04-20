package com.example.roman.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class RomanController {

    private static final int[] decimalValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    @GetMapping("convert/{decimal}")
    public String decimalToRoman(@PathVariable Integer decimal) {

        StringBuilder roman = new StringBuilder();

        for(int i=0; i<decimalValues.length; i++) {
            while(decimal >= decimalValues[i]) {
                decimal -= decimalValues[i];
                roman.append(romanValues[i]);
            }
        }

        return roman.toString();
    }
    
}
