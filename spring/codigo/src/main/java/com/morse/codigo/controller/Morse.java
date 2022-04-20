package com.morse.codigo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Morse {

    @GetMapping("/{mensaje}")
    public String traductor(@PathVariable String mensaje){

        String palabras[];
        String caracteres[];
        Map<String, String> traduccion = new HashMap<>();
        String cadenaFinal = "";

        traduccion.put("A", ".-"); traduccion.put("B", "-..."); traduccion.put("C", "-.-."); traduccion.put("D", "-..");
        traduccion.put("E", "."); traduccion.put("F", "..-."); traduccion.put("G", "--."); traduccion.put("H", "....");
        traduccion.put("I", ".."); traduccion.put("J", ".---"); traduccion.put("K", "-.-"); traduccion.put("L", ".-..");
        traduccion.put("M", "--"); traduccion.put("N", "-."); traduccion.put("O", "---"); traduccion.put("P", ".--.");
        traduccion.put("Q", "--.-"); traduccion.put("R", ".-."); traduccion.put("S", "..."); traduccion.put("T", "-");
        traduccion.put("U", "..-"); traduccion.put("V", "...-"); traduccion.put("W", ".--"); traduccion.put("X", "-..-");
        traduccion.put("Y", "-.--"); traduccion.put("Z", "--.."); traduccion.put("1", ".----"); traduccion.put("2", "..---");
        traduccion.put("3", "...--"); traduccion.put("4", "....-"); traduccion.put("5", "....."); traduccion.put("6", "-....");
        traduccion.put("7", "--..."); traduccion.put("8", "---.."); traduccion.put("9", "----."); traduccion.put("0", "-----");
        traduccion.put("?", "..--.."); traduccion.put("!", "-.-.--"); traduccion.put(".", ".-.-.-"); traduccion.put(",", "--..--");


        palabras = mensaje.split("   ");

        for(int i = 0; i<palabras.length;i++){

            caracteres = palabras[i].split(" ");

            for(int j = 0; j<caracteres.length;j++){
                cadenaFinal += traduccion.get(caracteres[j]);
            }
            cadenaFinal += "  ";
        }
        return cadenaFinal;
    }
}
