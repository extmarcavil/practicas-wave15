package com.codigoMorse.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@RestController
public class codigomorseController {

    //Pasar de codigo morse a espaniol
    @GetMapping("/covertMorse/{morse}")
    public String codigoMorse(@PathVariable String morse) {
            morse += " ";
            String resultado = "";
            String cursor = "";
            for(int i = 0 ; i < morse.length() ; ++i){
                //Agarra el primer caracter
                if(morse.charAt(i)== ' ') {
                    //se fija que no tenga espacio
                    if (cursor.length() == 0)
                        //agarro el caracter
                        cursor = " ";
                        resultado += caracteres.get(cursor);
                        //pasa al siguiente caracter
                        cursor = "";
                } else {
                    cursor += morse.charAt(i);
                }
            }
            return ("La traduccion de  " + morse + "  es  " + resultado);
    }

    //Pasar de espeniol a codigo morce
    @GetMapping(path = "/ascii/{codigo}")
    public String controladorAscii(@PathVariable String codigo) {
        String[] palabras = codigo.split(" ");
        String traduccion = "";

        for (String palabra : palabras) {
            String[] letras = palabra.split("");

            for (String letra : letras)
                traduccion += caracteres.getOrDefault(letra, "") + " ";

            traduccion += "  ";
        }

        return traduccion.substring(0, traduccion.length() - 3);
    }


    public static Map<String, String> caracteres;
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
    }
}
