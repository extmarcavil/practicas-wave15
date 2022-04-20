package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    public static Map<String, String> caracteresMorse;
    public static Map<String, String> caracteresAscii;

    static {
        caracteresMorse = new HashMap<>();
        caracteresMorse.put(".-", "A");
        caracteresMorse.put("-...", "B");
        caracteresMorse.put("-.-.", "C");
        caracteresMorse.put("-..", "D");
        caracteresMorse.put(".", "E");
        caracteresMorse.put("..-.", "F");
        caracteresMorse.put("--.", "G");
        caracteresMorse.put("....", "H");
        caracteresMorse.put("..", "I");
        caracteresMorse.put(".---", "J");
        caracteresMorse.put("-.-", "K");
        caracteresMorse.put(".-..", "L");
        caracteresMorse.put("--", "M");
        caracteresMorse.put("-.", "N");
        caracteresMorse.put("---", "O");
        caracteresMorse.put(".--.", "P");
        caracteresMorse.put("--.-", "Q");
        caracteresMorse.put(".-.", "R");
        caracteresMorse.put("...", "S");
        caracteresMorse.put("-", "T");
        caracteresMorse.put("..-", "U");
        caracteresMorse.put("...-", "V");
        caracteresMorse.put(".--", "W");
        caracteresMorse.put("-..-", "X");
        caracteresMorse.put("-.--", "Y");
        caracteresMorse.put("--..", "Z");
        caracteresMorse.put(".----", "1");
        caracteresMorse.put("..---", "2");
        caracteresMorse.put("...--", "3");
        caracteresMorse.put("....-", "4");
        caracteresMorse.put(".....", "5");
        caracteresMorse.put("-....", "6");
        caracteresMorse.put("--...", "7");
        caracteresMorse.put("---..", "8");
        caracteresMorse.put("----.", "9");
        caracteresMorse.put("-----", "0");
        caracteresMorse.put("..--..", "?");
        caracteresMorse.put("-.-.--", "!");
        caracteresMorse.put(".-.-.-", ".");
        caracteresMorse.put("--..--", ",");

        caracteresAscii = new HashMap<>();
        caracteresAscii.put("A", ".-");
        caracteresAscii.put("B", "-...");
        caracteresAscii.put("C", "-.-.");
        caracteresAscii.put("D", "-..");
        caracteresAscii.put("E", ".");
        caracteresAscii.put("F", "..-.");
        caracteresAscii.put("G", "--.");
        caracteresAscii.put("H", "....");
        caracteresAscii.put("I", "..");
        caracteresAscii.put("J", ".---");
        caracteresAscii.put("K", "-.-");
        caracteresAscii.put("L", ".-..");
        caracteresAscii.put("M", "--");
        caracteresAscii.put("N", "-.");
        caracteresAscii.put("O", "---");
        caracteresAscii.put("P", ".--.");
        caracteresAscii.put("Q", "--.-");
        caracteresAscii.put("R", ".-.");
        caracteresAscii.put("S", "...");
        caracteresAscii.put("T", "-");
        caracteresAscii.put("U", "..-");
        caracteresAscii.put("V", "...-");
        caracteresAscii.put("W", ".--");
        caracteresAscii.put("X", "-..-");
        caracteresAscii.put("Y", "-.--");
        caracteresAscii.put("Z", "--..");
        caracteresAscii.put("1", ".----");
        caracteresAscii.put("2", "..---");
        caracteresAscii.put("3", "...--");
        caracteresAscii.put("4", "....-");
        caracteresAscii.put("5", ".....");
        caracteresAscii.put("6", "-....");
        caracteresAscii.put("7", "--...");
        caracteresAscii.put("8", "---..");
        caracteresAscii.put("9", "----.");
        caracteresAscii.put("0", "-----");
        caracteresAscii.put("?", "..--..");
        caracteresAscii.put("!", "-.-.--");
        caracteresAscii.put(".", ".-.-.-");
        caracteresAscii.put(",", "--..--");

    }

    @GetMapping(path = "/morse/{codigo}")
    public String controladorMorse(@PathVariable String codigo) {
        String[] palabras = codigo.split("   ");
        String traduccion = "";

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");

            for (String letra : letras)
                traduccion += caracteresMorse.get(letra);

            traduccion += " ";
        }
        return traduccion.substring(0, traduccion.length() - 1);
    }

    @GetMapping(path = "/ascii/{codigo}")
    public String controladorAscii(@PathVariable String codigo) {
        String[] palabras = codigo.split(" ");
        String traduccion = "";

        for (String palabra : palabras) {
            String[] letras = palabra.split("");

            for (String letra : letras)
                traduccion += caracteresAscii.getOrDefault(letra, "") + " ";

            traduccion += "  ";
        }

        return traduccion.substring(0, traduccion.length() - 3);
    }
}
