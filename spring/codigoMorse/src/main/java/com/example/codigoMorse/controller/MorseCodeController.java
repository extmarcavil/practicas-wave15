package com.example.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseCodeController {
    @GetMapping("/{morseCode}")
    public String getMessage(@PathVariable String morseCode){
        Map<String, String> morseChars = new HashMap<>();
        morseChars.put(".-", "A");
        morseChars.put("-...", "B");
        morseChars.put("-.-.", "C");
        morseChars.put("-..", "D");
        morseChars.put(".", "E");
        morseChars.put("..-.", "F");
        morseChars.put("--.", "G");
        morseChars.put("....", "H");
        morseChars.put("..", "I");
        morseChars.put(".---", "J");
        morseChars.put("-.-", "K");
        morseChars.put(".-..", "L");
        morseChars.put("--", "M");
        morseChars.put("-.", "N");
        morseChars.put("---", "O");
        morseChars.put(".--.", "P");
        morseChars.put("--.-", "Q");
        morseChars.put(".-.", "R");
        morseChars.put("...", "S");
        morseChars.put("-", "T");
        morseChars.put("..-", "U");
        morseChars.put("...-", "V");
        morseChars.put(".--", "W");
        morseChars.put("-..-", "X");
        morseChars.put("-.--", "Y");
        morseChars.put("--..", "Z");
        morseChars.put(".----", "1");
        morseChars.put("..---", "2");
        morseChars.put("...--", "3");
        morseChars.put("....-", "4");
        morseChars.put(".....", "5");
        morseChars.put("-....", "6");
        morseChars.put("--...", "7");
        morseChars.put("---..", "8");
        morseChars.put("----.", "9");
        morseChars.put("-----", "0");
        morseChars.put("..--..", "?");
        morseChars.put("-.-.--", "!");
        morseChars.put(".-.-.-", ".");
        morseChars.put("--..--", ",");

        String message = "";

        for(String word : morseCode.split("   ")){
            for(String letter : word.split(" ")){
                message += morseChars.get(letter);
            }
            message += " ";
        }

        return message;
    }
}
