package com.spring.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    //Ejemplo de ejecucion http://localhost:8080/codigoMorse/-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .   -- . .-. -.-. .- -.. ---   .-.. .. -... .-. .
    @GetMapping("/codigoMorse/{mensajeMorse}")
    public String codigoMorse(@PathVariable String mensajeMorse) {

        String mensaje = "";
        Map<String,String> caracteres = new HashMap<String,String>();

            caracteres = new HashMap<>();
            caracteres.put(".-", "A");
            caracteres.put("-...", "B");
            caracteres.put("-.-.", "C");
            caracteres.put("-..", "D");
            caracteres.put(".", "E");
            caracteres.put("..-.", "F");
            caracteres.put("--.", "G");
            caracteres.put("....", "H");
            caracteres.put("..", "I");
            caracteres.put(".---", "J");
            caracteres.put("-.-", "K");
            caracteres.put(".-..", "L");
            caracteres.put("--", "M");
            caracteres.put("-.", "N");
            caracteres.put("---", "O");
            caracteres.put(".--.", "P");
            caracteres.put("--.-", "Q");
            caracteres.put(".-.", "R");
            caracteres.put("...", "S");
            caracteres.put("-", "T");
            caracteres.put("..-", "U");
            caracteres.put("...-", "V");
            caracteres.put(".--", "W");
            caracteres.put("-..-", "X");
            caracteres.put("-.--", "Y");
            caracteres.put("--..", "Z");
            caracteres.put(".----", "1");
            caracteres.put("..---", "2");
            caracteres.put("...--", "3");
            caracteres.put("....-", "4");
            caracteres.put(".....", "5");
            caracteres.put("-....", "6");
            caracteres.put("--...", "7");
            caracteres.put("---..", "8");
            caracteres.put("----.", "9");
            caracteres.put("-----", "0");
            caracteres.put("..--..", "?");
            caracteres.put("-.-.--", "!");
            caracteres.put(".-.-.-", ".");
            caracteres.put("--..--", ",");




        String[] caracteresMorse = mensajeMorse.split(" ");
        boolean espacio = false;
        for (int i = 0; i < caracteresMorse.length; i++) {
            if (caracteres.get(caracteresMorse[i]) == null && !espacio) {
                mensaje += " ";
                espacio = true;
            } else if (espacio) {
                espacio = false;
            } else {
                mensaje += caracteres.get(caracteresMorse[i]);
            }
        }
        return mensaje;
    }
}
