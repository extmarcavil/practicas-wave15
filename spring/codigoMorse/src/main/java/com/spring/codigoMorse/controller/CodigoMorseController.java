package com.spring.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("codigoMorse/{codigo}")
    public String parsearCodigoMorse(@PathVariable String codigo) {
        return parsear(codigo);
    }

    private String parsear(String codigo) {
        Map<String, String> mapa = inicializarMapa();

        String palabra = "";
        String[] palabraMorse = codigo.split("   ");

        for (int i = 0; i < palabraMorse.length; i++) {
            String palabraActual = palabraMorse[i];
            String[] letraMorse = palabraActual.split(" ");

            for (int j = 0; j < letraMorse.length; j++) {
                String simbolo = letraMorse[j];
                if(mapa.get(simbolo) == null)
                    return "Hay un caracter incorrecto";

                palabra += mapa.get(simbolo);
            }
            palabra += " ";
        }

        return palabra.substring(0, palabra.length() - 1);
    }

    private Map<String, String> inicializarMapa() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put(".-", "A");
        mapa.put("-...", "B");
        mapa.put("-.-.", "C");
        mapa.put("-..", "D");
        mapa.put(".", "E");
        mapa.put("..-.", "F");
        mapa.put("--.", "G");
        mapa.put("....", "H");
        mapa.put("..", "I");
        mapa.put(".---", "J");
        mapa.put("-.-", "K");
        mapa.put(".-..", "L");
        mapa.put("--", "M");
        mapa.put("-.", "N");
        mapa.put("---", "O");
        mapa.put(".--.", "P");
        mapa.put("--.-", "Q");
        mapa.put(".-.", "R");
        mapa.put("...", "S");
        mapa.put("-", "T");
        mapa.put("..-", "U");
        mapa.put("...-", "V");
        mapa.put(".--", "W");
        mapa.put("-..-", "X");
        mapa.put("-.--", "Y");
        mapa.put("--..", "Z");
        mapa.put(".----", "1");
        mapa.put("..---", "2");
        mapa.put("...--", "3");
        mapa.put("....-", "4");
        mapa.put(".....", "5");
        mapa.put("-....", "6");
        mapa.put("--...", "7");
        mapa.put("---..", "8");
        mapa.put("----.", "9");
        mapa.put("-----", "0");
        mapa.put("..--..", "?");
        mapa.put("-.-.--", "!");
        mapa.put(".-.-.-", ".");
        mapa.put("--..--", ",");

        return mapa;
    }
}
