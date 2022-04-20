package com.bootcamp.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseCodeToSpanish {

    private Map<String, String> symbols = new HashMap<String, String>();
    private Map<String, String> symbols2 = new HashMap<String, String>();

    public MorseCodeToSpanish() {
        symbols.put(".-", "A");
        symbols.put("-...", "B");
        symbols.put("-.-.", "C");
        symbols.put("-..", "D");
        symbols.put(".", "E");
        symbols.put("..-.", "F");
        symbols.put("--.", "G");
        symbols.put("....", "H");
        symbols.put("..", "I");
        symbols.put(".---", "J");
        symbols.put("-.-", "K");
        symbols.put(".-..", "L");
        symbols.put("--", "M");
        symbols.put("-.", "N");
        symbols.put("---", "O");
        symbols.put(".--.", "P");
        symbols.put("--.-", "Q");
        symbols.put(".-.", "R");
        symbols.put("...", "S");
        symbols.put("-", "T");
        symbols.put("..-", "U");
        symbols.put("...-", "V");
        symbols.put(".--", "W");
        symbols.put("-..-", "X");
        symbols.put("-.--", "Y");
        symbols.put("--..", "Z");
        symbols.put(".----", "1");
        symbols.put("..---", "2");
        symbols.put("...--", "3");
        symbols.put("....-", "4");
        symbols.put(".....", "5");
        symbols.put("-....", "6");
        symbols.put("--...", "7");
        symbols.put("---..", "8");
        symbols.put("----.", "9");
        symbols.put("-----", "0");
        symbols.put("..--..", "?");
        symbols.put("-.-.--", "!");
        symbols.put(".-.-.-", ".");
        symbols.put("--..--", ",");

        symbols2.put("A", ".-");
        symbols2.put("B", "-...");
        symbols2.put("C", "-.-.");
        symbols2.put("D", "-..");
        symbols2.put("E", ".");
        symbols2.put("F", "..-.");
        symbols2.put("G", "--.");
        symbols2.put("H", "....");
        symbols2.put("I", "..");
        symbols2.put("J", ".---");
        symbols2.put("K", "-.-");
        symbols2.put("L", ".-..");
        symbols2.put("M", "--");
        symbols2.put("N", "-.");
        symbols2.put("O", "---");
        symbols2.put("P", ".--.");
        symbols2.put("Q", "--.-");
        symbols2.put("R", ".-.");
        symbols2.put("S", "...");
        symbols2.put("T", "-");
        symbols2.put("U", "..-");
        symbols2.put("V", "...-");
        symbols2.put("W", ".--");
        symbols2.put("X", "-..-");
        symbols2.put("Y", "-.--");
        symbols2.put("Z", "--..");
        symbols2.put("1", ".----");
        symbols2.put("2", "..---");
        symbols2.put("3", "...--");
        symbols2.put("4", "....-");
        symbols2.put("5", ".....");
        symbols2.put("6", "-....");
        symbols2.put("7", "--...");
        symbols2.put("8", "---..");
        symbols2.put("9", "----.");
        symbols2.put("0", "-----");
        symbols2.put("?", "..--..");
        symbols2.put("!", "-.-.--");
        symbols2.put(".", ".-.-.-");
        symbols2.put(",", "--..--");
    }

    @GetMapping("/{code}")
    public String convertMorseToSpanish(@PathVariable String code) {

        String[] codes = code.split(" ");
        StringBuilder translation = new StringBuilder();
        boolean space = false;

        for (String s : codes) {
            System.out.println(s);
            if (s.equals("")) {
                if (space) {
                    space = false;
                    translation.append(" ");
                }
                space = true;
                continue;
            }
            translation.append(symbols.get(s));
        }
        return "El codigo " + code + " traducido es: " + translation.toString();
    }

    @GetMapping("toMorse/{phrase}")
    public String convertSpanishToMorse(@PathVariable String phrase) {

        phrase = phrase.toUpperCase();
        String[] codes = phrase.split(" ");
        StringBuilder translation = new StringBuilder();

        for (String p : codes) {
            for (int i = 0; i < p.length(); i++) {
                translation.append(symbols2.get("" + p.charAt(i)) + " ");

            }
            translation.append("  ");
        }
        return "La frase " + phrase + " " + translation.toString();
    }
}
