package com.example.morsecode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class MorseCodeController {
    String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--.."};

    char[] letterArray = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};

    @GetMapping("/morse/{code}")
    public String morseToString(@PathVariable String code){
        StringBuilder result = new StringBuilder();
        String[] words = code.split("   ");
        for (String word : words){
            String[] letters = word.split(" ");
            for (String letter : letters){
                result.append(morseToLetter(letter));
            }
            result.append(" ");
        }
        return result.toString().toUpperCase(Locale.ROOT).trim();
    }

    private String morseToLetter(String letter){
        int index = 0;
        boolean notFound = true;
        while (index < code.length && notFound){
            if (code[index].equals(letter)){
                notFound = false;
            } else {
                index++;
            }
        }
        if (index < code.length){
            return String.valueOf(letterArray[index]);
        } else {
            return "?";
        }
    }

}
