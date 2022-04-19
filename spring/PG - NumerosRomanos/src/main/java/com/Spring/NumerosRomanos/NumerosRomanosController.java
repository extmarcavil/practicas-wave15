package com.Spring.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable Integer numero){
        String numeroEnRomano = "";
        TreeMap<Integer, String> mapaNumerosRomanos = new TreeMap<>();

        mapaNumerosRomanos.put(1000, "M");
        mapaNumerosRomanos.put(900, "CM");
        mapaNumerosRomanos.put(500, "D");
        mapaNumerosRomanos.put(400, "CD");
        mapaNumerosRomanos.put(100, "C");
        mapaNumerosRomanos.put(90, "XC");
        mapaNumerosRomanos.put(50, "L");
        mapaNumerosRomanos.put(40, "XL");
        mapaNumerosRomanos.put(10, "X");
        mapaNumerosRomanos.put(9, "IX");
        mapaNumerosRomanos.put(5, "V");
        mapaNumerosRomanos.put(4, "IV");
        mapaNumerosRomanos.put(1, "I");

        while(numero != 0){
            int aux = mapaNumerosRomanos.floorKey(numero);
            numeroEnRomano += mapaNumerosRomanos.get(aux);
            numero -= aux;
        }

        return numeroEnRomano;

    }


}
