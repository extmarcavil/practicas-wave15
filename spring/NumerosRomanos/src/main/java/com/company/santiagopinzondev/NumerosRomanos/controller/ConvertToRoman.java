package com.company.santiagopinzondev.NumerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class ConvertToRoman {

    @GetMapping("/convert/{number}")
    public String convertToRoman(@PathVariable int number){
        String numberRoman = toRoman(number);
        return numberRoman;
    }

    private static String toRoman(int number) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int l =  map.floorKey(number);
        if ( number == l ) {
            // floor key me devuelve el elemento igual o mayor y si no lo encuentra me devuelve el menor
            // 2 no existe entoces el menor seria 1 y me retorna 1 que seria i
            return map.get(number);
        }
        // se hace la recursion para saber cada letra de los numeros restantes
        // por ejemplo 15, el menor seria 10 entoces obtiene X y vuelve y llama a roman ya teniendo x + la recursion que ahora es 5 y
        // ya es 5 por que le resto el numero que ya puede sacar y el 5 como si esta y es v
        // entonces se comparan para ya retornar xv
        return map.get(l) + toRoman(number-l);
    }
}
