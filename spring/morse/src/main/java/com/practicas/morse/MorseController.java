package com.practicas.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    public static HashMap<String, String> caracteres;
    public static HashMap<String, String> caracteresInversos;
    static {
        caracteres = new HashMap<>();
        caracteresInversos = new HashMap<>();
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

        for(Map.Entry<String, String> entry : caracteres.entrySet()){
            caracteresInversos.put(entry.getValue(), entry.getKey());
        }
    }

    @GetMapping("morse/{cadena}")
    public String getString(@PathVariable String cadena){
        String resultado = "";
        for (String parte: cadena.split("   ")) {
            for (String caracter: parte.split(" ")) {
                String temp = caracteres.get(caracter);
                resultado = (temp == null) ? resultado + "" : resultado + temp;
            }
            resultado = resultado + " ";
        }
        return resultado.substring(0, resultado.length()-1);
    }

    @GetMapping("string/{cadena}")
    public String getMorse(@PathVariable String cadena){
        String resultado = "";
        for (String parte: cadena.toUpperCase().split(" ")) {
            for (Character caracter: parte.toCharArray()) {
                String temp = caracteresInversos.get(caracter.toString());
                resultado = (temp == null) ? resultado + "" : resultado + " " + temp;
            }
            resultado = resultado + "   ";
        }
        return resultado.substring(1,resultado.length()-3);
    }

}
