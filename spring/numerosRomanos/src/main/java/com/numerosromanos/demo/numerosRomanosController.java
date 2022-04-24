package com.numerosromanos.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class numerosRomanosController {
    @GetMapping("/convert/{number}")
    public String obtenerRomano(@PathVariable Integer number){
        String n = conversionRomano(number);
        return n;
    }

    private static String conversionRomano(int numeroConvertir) {
        TreeMap<Integer, String> listadoNumerosRomanos = new TreeMap<Integer, String>();
        listadoNumerosRomanos.put(1000, "M");
        listadoNumerosRomanos.put(900, "CM");
        listadoNumerosRomanos.put(500, "D");
        listadoNumerosRomanos.put(400, "CD");
        listadoNumerosRomanos.put(100, "C");
        listadoNumerosRomanos.put(90, "XC");
        listadoNumerosRomanos.put(50, "L");
        listadoNumerosRomanos.put(40, "XL");
        listadoNumerosRomanos.put(10, "X");
        listadoNumerosRomanos.put(9, "IX");
        listadoNumerosRomanos.put(5, "V");
        listadoNumerosRomanos.put(4, "IV");
        listadoNumerosRomanos.put(1, "I");

        String numeroRomano = "";

        while( numeroConvertir != 0 ){
            int numeroAnterior = listadoNumerosRomanos.floorKey(numeroConvertir);
            numeroRomano += listadoNumerosRomanos.get(numeroAnterior);
            numeroConvertir -= numeroAnterior;
        }
        return numeroRomano;
    }
}
