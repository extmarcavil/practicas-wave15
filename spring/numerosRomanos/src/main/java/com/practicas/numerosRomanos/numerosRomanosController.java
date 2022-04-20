package com.practicas.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class numerosRomanosController {
    @GetMapping("roman/{number}")
    public String getRoman(@PathVariable Integer number){
        return toRoman(number);
    }

    public static String toRoman(Integer number){
        TreeMap<Integer, String> numeros = new TreeMap<Integer, String>();
        numeros.put(1000, "M");
        numeros.put(900, "CM");
        numeros.put(500, "D");
        numeros.put(400, "CD");
        numeros.put(100, "C");
        numeros.put(90, "XC");
        numeros.put(50, "L");
        numeros.put(40, "XL");
        numeros.put(10, "X");
        numeros.put(9, "IX");
        numeros.put(5, "V");
        numeros.put(4, "IV");
        numeros.put(1, "I");
        int l =  numeros.floorKey(number);
        if ( number == l ) {
            return numeros.get(number);
        }
        return numeros.get(l) + toRoman(number-l);
    }
}
