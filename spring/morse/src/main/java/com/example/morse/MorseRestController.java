package com.example.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class MorseRestController {
    @GetMapping("/test{data}")
    public String toMorse(@PathVariable String data) {
        StringBuilder morseCode = new StringBuilder();
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
        String wordSeparation = "   ";

        for(int i =0;data.length() > i ; i++){
            int position = Arrays.binarySearch(letterArray, data.charAt(i));
            morseCode.append(code[position]);
        }

        return morseCode.toString();
    }
}