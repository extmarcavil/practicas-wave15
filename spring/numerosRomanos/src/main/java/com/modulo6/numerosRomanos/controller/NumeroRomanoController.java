package com.modulo6.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    private String ROMANOS_UNIDADES[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private String ROMANOS_DECENAS[]  = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String ROMANOS_CENTENAS[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String ROMANOS_MILES[]    = {"", "M", "MM", "MMM"};


    //ejemplo de ruta, el puerto esta por defecto 8080: http://localhost:8080/numeroRomano/12
    @GetMapping("/numeroRomano/{numero}")
    public String numeroRomano(@PathVariable Integer numero){
        StringBuilder numeroRomano = new StringBuilder();

        if (numero >=  3999 || numero < 1){
            return "El número: " + numero + " no esta comprendido en los números romanosque es de 1 a 3999";
        }

        int m = numero / 1000;
        int c = (numero % 1000) / 100;
        int d = (numero % 100) / 10;
        int u = numero % 10;

        numeroRomano.append(ROMANOS_MILES[m]);
        numeroRomano.append(ROMANOS_CENTENAS[c]);
        numeroRomano.append(ROMANOS_DECENAS[d]);
        numeroRomano.append(ROMANOS_UNIDADES[u]);

        return "El número: " + numero + " en números romanos es: " + numeroRomano.toString();
    }

}
