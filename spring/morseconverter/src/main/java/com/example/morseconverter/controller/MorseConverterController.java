package com.example.morseconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseConverterController {
    String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "   "};

    String[] letterArray = { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z"," " };

    @GetMapping("/translateMorse/{morseCode}")
    public String deCode(@PathVariable String morseCode){
        String[] words = morseCode.split("   ");
        StringBuilder stringBuffer = new StringBuilder();
        for (int i=0; i<words.length; i++){
            String word = words[i];
            String[] characters = word.split(" ");
            for(String character : characters){
                stringBuffer.append(morseToLetter(character));
            }
            stringBuffer.append(" ");
        }

        return stringBuffer.substring(0, stringBuffer.length()-1);
    }

    @GetMapping("/translateLetter/{letter}")
    public String deCodeL(@PathVariable String letter){
        String[] words = letter.split(" ");
        StringBuilder stringBuffer = new StringBuilder();
        for (int i=0; i<words.length; i++){
            String word = words[i];
            String[] characters = word.split("");
            for(String character : characters){
                stringBuffer.append(letterToMorse(character));
            }
            stringBuffer.append(" ");
        }

        return stringBuffer.substring(0, stringBuffer.length()-1);
    }

    private String morseToLetter(String letter){
        int index = 0;
        boolean notFound = true;
        while(index<code.length && notFound){
            if (code[index].equals(letter)) {
                notFound = false;
            }else{
                index++;
            }
        }
        if (index<code.length){
            return String.valueOf(letterArray[index]);
        }else{
            return "?";
        }
    }

    private String letterToMorse(String morse){
        int index = 0;
        boolean notFound = true;
        while(index<letterArray.length && notFound){
            if (letterArray[index].equals(morse)) {
                notFound = false;
            }else{
                index++;
            }
        }
        if (index<letterArray.length){
            return String.valueOf(code[index]);
        }else{
            return "?";
        }
    }
}
