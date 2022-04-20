package com.example.ConvertToMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    public static Map<String, String> morseALetra = new HashMap<String, String>();
    static {
        morseALetra = new HashMap<>();
        morseALetra.put(".-", "A");
        morseALetra.put("-...", "B");
        morseALetra.put("-.-.", "C");
        morseALetra.put("-..", "D");
        morseALetra.put(".", "E");
        morseALetra.put("..-.", "F");
        morseALetra.put("--.", "G");
        morseALetra.put("....", "H");
        morseALetra.put("..", "I");
        morseALetra.put(".---", "J");
        morseALetra.put("-.-", "K");
        morseALetra.put(".-..", "L");
        morseALetra.put("--", "M");
        morseALetra.put("-.", "N");
        morseALetra.put("---", "O");
        morseALetra.put(".--.", "P");
        morseALetra.put("--.-", "Q");
        morseALetra.put(".-.", "R");
        morseALetra.put("...", "S");
        morseALetra.put("-", "T");
        morseALetra.put("..-", "U");
        morseALetra.put("...-", "V");
        morseALetra.put(".--", "W");
        morseALetra.put("-..-", "X");
        morseALetra.put("-.--", "Y");
        morseALetra.put("--..", "Z");
        morseALetra.put(".----", "1");
        morseALetra.put("..---", "2");
        morseALetra.put("...--", "3");
        morseALetra.put("....-", "4");
        morseALetra.put(".....", "5");
        morseALetra.put("-....", "6");
        morseALetra.put("--...", "7");
        morseALetra.put("---..", "8");
        morseALetra.put("----.", "9");
        morseALetra.put("-----", "0");
        morseALetra.put("..--..", "?");
        morseALetra.put("-.-.--", "!");
        morseALetra.put(".-.-.-", ".");
        morseALetra.put("--..--", ",");
    }

    @GetMapping("/{codigoMorse}")
    public String traductorMorse(@PathVariable String codigoMorse){

        var palabras = codigoMorse.split("   ");
        String palabraFormada = "";
        for (int i = 0; i < palabras.length; i++){
            var caracteres = palabras[i].split(" ");
            for(int j = 0; j < caracteres.length; j++){
                palabraFormada = palabraFormada + morseALetra.get(caracteres[j]);
            }
            palabraFormada = palabraFormada + " ";
        }
        return palabraFormada;
    }


}
