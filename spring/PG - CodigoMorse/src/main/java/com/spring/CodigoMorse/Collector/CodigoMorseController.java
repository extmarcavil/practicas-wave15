package com.spring.CodigoMorse.Collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    @GetMapping("/{codigoMorse}")
    public String convertirMorse(@PathVariable String codigoMorse){

        String nuevaCadena = "";
        Map<String, String> mapaMorse = new HashMap<String, String>();

            mapaMorse.put(".-", "A");
            mapaMorse.put("-...", "B");
            mapaMorse.put("-.-.", "C");
            mapaMorse.put("-..", "D");
            mapaMorse.put(".", "E");
            mapaMorse.put("..-.", "F");
            mapaMorse.put("--.", "G");
            mapaMorse.put("....", "H");
            mapaMorse.put("..", "I");
            mapaMorse.put(".---", "J");
            mapaMorse.put("-.-", "K");
            mapaMorse.put(".-..", "L");
            mapaMorse.put("--", "M");
            mapaMorse.put("-.", "N");
            mapaMorse.put("---", "O");
            mapaMorse.put(".--.", "P");
            mapaMorse.put("--.-", "Q");
            mapaMorse.put(".-.", "R");
            mapaMorse.put("...", "S");
            mapaMorse.put("-", "T");
            mapaMorse.put("..-", "U");
            mapaMorse.put("...-", "V");
            mapaMorse.put(".--", "W");
            mapaMorse.put("-..-", "X");
            mapaMorse.put("-.--", "Y");
            mapaMorse.put("--..", "Z");
            mapaMorse.put(".----", "1");
            mapaMorse.put("..---", "2");
            mapaMorse.put("...--", "3");
            mapaMorse.put("....-", "4");
            mapaMorse.put(".....", "5");
            mapaMorse.put("-....", "6");
            mapaMorse.put("--...", "7");
            mapaMorse.put("---..", "8");
            mapaMorse.put("----.", "9");
            mapaMorse.put("-----", "0");
            mapaMorse.put("..--..", "?");
            mapaMorse.put("-.-.--", "!");
            mapaMorse.put(".-.-.-", ".");
            mapaMorse.put("--..--", ",");
            mapaMorse.put(" ", "   ");

        String[] caracteresMorse = codigoMorse.split(" ");
        boolean espacio = false;
        for (int i = 0; i < caracteresMorse.length; i++) {
            if (mapaMorse.get(caracteresMorse[i]) == null && !espacio) {
                nuevaCadena += " ";
                espacio = true;
            } else if (espacio){
                espacio = false;
            } else {
                nuevaCadena += mapaMorse.get(caracteresMorse[i]);
            }
        }

        return nuevaCadena;

    }


}
