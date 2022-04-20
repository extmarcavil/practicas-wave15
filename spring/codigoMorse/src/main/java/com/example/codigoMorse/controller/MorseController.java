package com.example.codigoMorse.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/codigo-morse")
public class MorseController {

    @GetMapping("/convert/{code}")
    public StringBuilder convert (@PathVariable String code){
        StringBuilder result = new StringBuilder();
        // creo un array donde cada item es una palabra (en codigo)
        String[] codeArrayWithSpaces = code.split("   ");
        // recorro ese array de palabras
        for(String array : codeArrayWithSpaces){
            // a cada palabra la transformo en un nuevo array, donde cada item es una letra (en codigo)
            String[] codeArrayPalabra = array.split(" ");
            for(int i=0; i<codeArrayPalabra.length; i++){
                // busco cada código dentro del mapMorse
                String letra = mapMorse().get(codeArrayPalabra[i]);
                result.append(letra);
            }
            // luego de cada ciclo for, agrego un espacio
            result.append(" ");
        }
        return result;
    }
    public static Map<String, String> mapMorse() {
        Map<String, String> caracteres = new HashMap<>();
        caracteres.put(".-", "A");caracteres.put("-...", "B");
        caracteres.put("-.-.", "C");caracteres.put("-..", "D");
        caracteres.put(".", "E");caracteres.put("..-.", "F");
        caracteres.put("--.", "G");caracteres.put("....", "H");
        caracteres.put("..", "I");caracteres.put(".---", "J");
        caracteres.put("-.-", "K");caracteres.put(".-..", "L");
        caracteres.put("--", "M");caracteres.put("-.", "N");
        caracteres.put("---", "O");caracteres.put(".--.", "P");
        caracteres.put("--.-", "Q");caracteres.put(".-.", "R");
        caracteres.put("...", "S");caracteres.put("-", "T");
        caracteres.put("..-", "U");caracteres.put("...-", "V");
        caracteres.put(".--", "W");caracteres.put("-..-", "X");
        caracteres.put("-.--", "Y");caracteres.put("--..", "Z");
        caracteres.put(".----", "1");caracteres.put("..---", "2");
        caracteres.put("...--", "3");caracteres.put("....-", "4");
        caracteres.put(".....", "5");caracteres.put("-....", "6");
        caracteres.put("--...", "7");caracteres.put("---..", "8");
        caracteres.put("----.", "9");caracteres.put("-----", "0");
        caracteres.put("..--..", "?");caracteres.put("-.-.--", "!");
        caracteres.put(".-.-.-", ".");caracteres.put("--..--", ",");
        return caracteres;
    }
    
}
