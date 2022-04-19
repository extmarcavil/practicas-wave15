package com.numerosromanos.numerosRomanos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.HashMap;
import java.util.TreeMap;


@RestController
public class numerosRomanosController {

    String retornar = "";

    @GetMapping("/convertir/{numero}")
    public  String conversionNumerosRomanos(@PathVariable Integer numero) {

        // -------------------------------> FORMA 1 <------------------------------------------
        String n = pasarARomano(numero);
        //La funcion pasarARomano esta mas abajo
        return "Al convertir a numeros romanos el numero " + numero +" obtengo " + n;

        // -------------------------------> FORMA 2 <------------------------------------------
        //defino numeros romanos
     /*   String unidad[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String decena[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String centena[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String miles = "";
        int m;
        int resto = numero;
        m = resto / 1000;
        resto = resto % 1000;

        int c = resto / 100;
        resto = resto % 100;

        int d = resto / 10;
        resto = resto % 10;

        int u = resto;
        for (int i = 1; i <= m; i++) {
            miles += "M";
        }
        if (resto >= 0) {
           return ("Al convertir a numeros romanos el numero: " + numero + " obtenemos " + miles + centena[c] + decena[d] + unidad[u]);
        } else if (resto >= 100) {
            return ("Al convertir a numeros romanos el numero: " + numero + " obtenemos " + centena[c] + decena[d] + unidad[u]);
        } else {
            if (resto >= 10) {
                return ("Al convertir a numeros romanos el numero: " + numero + " obtenemos " + decena[d] + unidad[u]);
            } else {
                return ("Al convertir a numeros romanos el numero " + numero + " obtenemos " + unidad[resto]);
            }

        }*/
        // -------------------------------> FORMA 3 <------------------------------------------
       /* StringBuilder nroRomano = new StringBuilder();
        String[] letras = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        int[] nros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        int aux = numero;

        for (int i = 0; i < nros.length; i++) {
        //el for se inicializa en el valor actual de numero
            for (; numero >= nros[i]; numero -= nros[i]) {
                nroRomano.append(letras[i]);
            }
        }
        //return nroRomano.toString();
       return "Al convertir a numeros romanos el numero: " + aux +" obtengo: " + nroRomano.toString();*/
}
// -------------------------------> FORMA 1 <------------------------------------------
    private static String pasarARomano(int numero) {
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

        //se usa el fllorKey para devolver la mayor clave menor o igual a la clave dada del parámetro.
       /* int clave =  map.floorKey(numero);
        if ( numero == clave ) {
            return map.get(numero);
        }
        return map.get(clave) + pasarARomano(numero-clave);*/
        String romanNumber = "";

        while( numero != 0 ){
            int floorKeyNumber = map.floorKey(numero);
            romanNumber += map.get(floorKeyNumber);
            numero -= floorKeyNumber;
        }
        return romanNumber;
    }
    
}
