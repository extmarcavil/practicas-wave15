package com.springp2pg.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class NumeroRomanos {

    @GetMapping("/convertir/{decimal}")
    public String sayHello(@PathVariable int decimal){
        return convertirARomano(decimal);
    }

    private String convertirARomano(int numero){
       int[] decimales ={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,5,4,1};
       String[] romanos = {"M", "CM", "D", "CD" , "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String romano = "";
        if(numero>0) {
            for (int i = 0; i < decimales.length; i++) {
                while (numero >=decimales[i]) {
                    numero -= decimales[i];
                    romano += romanos[i];

                }
            }
        }else romano = "Número no descubierto por los romanos";

        return  romano;
    }


}
