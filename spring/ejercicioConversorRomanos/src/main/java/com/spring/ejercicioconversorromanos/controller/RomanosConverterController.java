package com.spring.ejercicioconversorromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.TreeMap;

@RestController
public class RomanosConverterController {

    @GetMapping("{number}")
    public String convertRomano(@PathVariable Integer number) {
        TreeMap<Integer, String> dict = new TreeMap<>();
        dict.put(1, "I");
        dict.put(4, "IV");
        dict.put(5, "V");
        dict.put(9, "IX");
        dict.put(10, "X");
        dict.put(14, "XIV");
        dict.put(40, "XL");
        dict.put(50, "L");
        dict.put(90, "XC");
        dict.put(100, "C");
        dict.put(400, "CD");
        dict.put(500, "D");
        dict.put(900, "CM");
        dict.put(1000, "M");


        String resultado = "";

        while (number != 0) {
                resultado += dict.get(dict.floorKey(number));
                number -= dict.floorKey(number);
        }
        return resultado;
    }
}
