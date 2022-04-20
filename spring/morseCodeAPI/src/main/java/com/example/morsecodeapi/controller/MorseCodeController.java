package com.example.morsecodeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class MorseCodeController {

    @GetMapping("/morse/{code}")
    public static String morse(@PathVariable String code) {
        String message = "";

        //Separo el código morse por palabras
        String[] words = code.split("   ");

        //Busco el código morse recorriendo cada clave del diccionario
        for (String word : words) {
            String[] splitted = word.split("\\s+");
            for (String codeSplitted : splitted) {
                message += morseCharacters.get(codeSplitted);
            }
            message += " ";
        }

        return message.substring(0, message.length() - 1);
    }

    @GetMapping("/ascii/{code}")
    public static String ascii(@PathVariable String code) {
        String message = "";

        //Separo el código ascii por palabras
        String[] words = code.split("\\s+");

        //Busco el código ascii recorriendo cada clave del diccionario
        for (String word : words) {
            String[] splitted = word.split("");
            for (String codeSplitted : splitted) {
                message += asciiCharacters.get(codeSplitted);
            }
            message += " ";
        }

        return message.substring(0, message.length() - 1);
    }

    public static Map<String, String> morseCharacters;
    static {
        morseCharacters = new HashMap<>();
        morseCharacters.put(".-", "A");morseCharacters.put("-...", "B");
        morseCharacters.put("-.-.", "C");morseCharacters.put("-..", "D");
        morseCharacters.put(".", "E");morseCharacters.put("..-.", "F");
        morseCharacters.put("--.", "G");morseCharacters.put("....", "H");
        morseCharacters.put("..", "I");morseCharacters.put(".---", "J");
        morseCharacters.put("-.-", "K");morseCharacters.put(".-..", "L");
        morseCharacters.put("--", "M");morseCharacters.put("-.", "N");
        morseCharacters.put("---", "O");morseCharacters.put(".--.", "P");
        morseCharacters.put("--.-", "Q");morseCharacters.put(".-.", "R");
        morseCharacters.put("...", "S");morseCharacters.put("-", "T");
        morseCharacters.put("..-", "U");morseCharacters.put("...-", "V");
        morseCharacters.put(".--", "W");morseCharacters.put("-..-", "X");
        morseCharacters.put("-.--", "Y");morseCharacters.put("--..", "Z");
        morseCharacters.put(".----", "1");morseCharacters.put("..---", "2");
        morseCharacters.put("...--", "3");morseCharacters.put("....-", "4");
        morseCharacters.put(".....", "5");morseCharacters.put("-....", "6");
        morseCharacters.put("--...", "7");morseCharacters.put("---..", "8");
        morseCharacters.put("----.", "9");morseCharacters.put("-----", "0");
        morseCharacters.put("..--..", "?");morseCharacters.put("-.-.--", "!");
        morseCharacters.put(".-.-.-", ".");morseCharacters.put("--..--", ",");
    }

    public static Map<String, String> asciiCharacters;
    static {
        asciiCharacters = new HashMap<>();
        asciiCharacters.put("A", ".-");asciiCharacters.put("B", "-...");
        asciiCharacters.put("C", "-.-.");asciiCharacters.put("D", "-..");
        asciiCharacters.put("E", ".");asciiCharacters.put("F", "..-.");
        asciiCharacters.put("G", "--.");asciiCharacters.put("H", "....");
        asciiCharacters.put("I", "..");asciiCharacters.put("J", ".---");
        asciiCharacters.put("K", "-.-");asciiCharacters.put("L", ".-..");
        asciiCharacters.put("M", "--");asciiCharacters.put("N", "-.");
        asciiCharacters.put("O", "---");asciiCharacters.put("P", ".--.");
        asciiCharacters.put("Q", "--.-");asciiCharacters.put("R", ".-.");
        asciiCharacters.put("S", "...");asciiCharacters.put("T", "-");
        asciiCharacters.put("U", "..-");asciiCharacters.put("V", "...-");
        asciiCharacters.put("W", ".--");asciiCharacters.put("X", "-..-");
        asciiCharacters.put("Y", "-.--");asciiCharacters.put("Z", "--..");
        asciiCharacters.put("1", ".----");asciiCharacters.put("2", "..---");
        asciiCharacters.put("3", "...--");asciiCharacters.put("4", "....-");
        asciiCharacters.put("5", ".....");asciiCharacters.put("6", "-....");
        asciiCharacters.put("7", "--...");asciiCharacters.put("8", "---..");
        asciiCharacters.put("9", "----.");asciiCharacters.put("0", "-----");
        asciiCharacters.put("?", "..--..");asciiCharacters.put("!", "-.-.--");
        asciiCharacters.put(".", ".-.-.-");asciiCharacters.put(",", "--..--");
    }

}
