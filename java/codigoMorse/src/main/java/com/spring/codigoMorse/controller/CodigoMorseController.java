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
        Map<String, String> codeMorse = new HashMap<>();

        codeMorse.put(".-", "A");
        codeMorse.put("-...", "B");
        codeMorse.put("-.-.", "C");
        codeMorse.put("-..", "D");
        codeMorse.put(".", "E");
        codeMorse.put("..-.", "F");
        codeMorse.put("--.", "G");
        codeMorse.put("....", "H");
        codeMorse.put("..", "I");
        codeMorse.put(".---", "J");
        codeMorse.put("-.-", "K");
        codeMorse.put(".-..", "L");
        codeMorse.put("--", "M");
        codeMorse.put("-.", "N");
        codeMorse.put("---", "O");
        codeMorse.put(".--.", "P");
        codeMorse.put("--.-", "Q");
        codeMorse.put(".-.", "R");
        codeMorse.put("...", "S");
        codeMorse.put("-", "T");
        codeMorse.put("..-", "U");
        codeMorse.put("...-", "V");
        codeMorse.put(".--", "W");
        codeMorse.put("-..-", "X");
        codeMorse.put("-.--", "Y");
        codeMorse.put("--..", "Z");
        codeMorse.put(".----", "1");
        codeMorse.put("..---", "2");
        codeMorse.put("...--", "3");
        codeMorse.put("....-", "4");
        codeMorse.put(".....", "5");
        codeMorse.put("-....", "6");
        codeMorse.put("--...", "7");
        codeMorse.put("---..", "8");
        codeMorse.put("----.", "9");
        codeMorse.put("-----", "0");
        codeMorse.put("..--..", "?");
        codeMorse.put("-.-.--", "!");
        codeMorse.put(".-.-.-", ".");
        codeMorse.put("--..--", ",");

        String saveConvert = "";

        String[] param = codigo.split("   ");

        for (int i = 0; i < param.length; i++) {

            String wordActually = param[i];
            String[] param2 = wordActually.split(" ");

            for (int j = 0; j < param2.length; j++) {

                String letterActually = param2[j];

                if(codeMorse.get(letterActually) == null) {
                    return "Hay un caracter incorrecto";
                }
                saveConvert += codeMorse.get(letterActually);

            }

            saveConvert += " ";

        }
        return saveConvert;
    }
}
