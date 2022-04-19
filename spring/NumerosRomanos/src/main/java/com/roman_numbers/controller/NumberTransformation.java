package com.roman_numbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NumberTransformation {

    private String THOUSANDTHS[] = {"", "M", "MM", "MMM"};
    private String HUNDREDS[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String TENS[]  = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String UNITS[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private StringBuilder romanNumber;
    private int amounts;

    public NumberTransformation() {
        System.out.printf("Llama al constructor");
    }

    @GetMapping("/num/{decNumber}")
    public String number(@PathVariable int decNumber) {
        romanNumber = new StringBuilder();

        // Getting num of thousandths
        amounts = decNumber / 1000;
        romanNumber.append(THOUSANDTHS[amounts]);

        // Getting num of hundreds
        amounts = decNumber % 1000 / 100;
        romanNumber.append(HUNDREDS[amounts]);

        // Getting num of tens
        amounts = decNumber % 100 / 10;
        romanNumber.append(TENS[amounts]);

        // Getting num of units
        amounts = decNumber % 10;
        romanNumber.append(UNITS[amounts]);

        return "El número " + decNumber + " en romano es: " + romanNumber.toString();
    }
}
