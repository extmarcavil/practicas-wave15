package com.example.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Translate {

    public static Map<String, String> caracteres;
    public static Map<String, String> symbols;

    static {
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

        symbols = new HashMap<>();
        symbols.put("A", ".-");
        symbols.put("B", "-...");
        symbols.put("C", "-.-.");
        symbols.put("D", "-..");
        symbols.put("E", ".");
        symbols.put("F", "..-.");
        symbols.put("G", "--.");
        symbols.put("H", "....");
        symbols.put("I", "..");
        symbols.put("J", ".---");
        symbols.put("K", "-.-");
        symbols.put("L", ".-..");
        symbols.put("M", "--");
        symbols.put("N", "-.");
        symbols.put("O", "---");
        symbols.put("P", ".--.");
        symbols.put("Q", "--.-");
        symbols.put("R", ".-.");
        symbols.put("S", "...");
        symbols.put("T", "-");
        symbols.put("U", "..-");
        symbols.put("V", "...-");
        symbols.put("W", ".--");
        symbols.put("X", "-..-");
        symbols.put("Y", "-.--");
        symbols.put("Z", "--..");
        symbols.put("1", ".----");
        symbols.put("2", "..---");
        symbols.put("3", "...--");
        symbols.put("4", "....-");
        symbols.put("5", ".....");
        symbols.put("6", "-....");
        symbols.put("7", "--...");
        symbols.put("8", "---..");
        symbols.put("9", "----.");
        symbols.put("0", "-----");
        symbols.put("?", "..--..");
        symbols.put("!", "-.-.--");
        symbols.put(".", ".-.-.-");
        symbols.put(",", "--..--");

    }

    @GetMapping(path = "/morse/{codigo}")
    public String traductorMorse(@PathVariable String codigo) {
        String[] palabras = codigo.split("   ");
        String traduccion = new String();

        for(String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for(String letra : letras)
                traduccion += caracteres.get(letra);
            traduccion += " ";
        }
        return traduccion;
    }

    @GetMapping(path = "/letras/{codigo}")
    public String traductorTexto(@PathVariable String codigo) {
        String traduccion = new String();
        String[] palabras = codigo.split(" ");
        for(String palabra : palabras) {
            String[] letras = palabra.split("");
            for(String letra : letras)
                traduccion += symbols.getOrDefault(letra, "") + " ";
            traduccion += "  ";
        }
        return traduccion.substring(0, traduccion.length() - 3);
    }

}
