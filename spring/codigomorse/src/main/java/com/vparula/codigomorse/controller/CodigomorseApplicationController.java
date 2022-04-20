package com.vparula.codigomorse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class CodigomorseApplicationController {


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody String body) {
        return body;
    }

    @GetMapping("/convert/{code}")
    public String convertMorse(@PathVariable String code){
        String[] palabras = code.split("   ");

        StringBuilder str = new StringBuilder();
        for (int i = 0; i<palabras.length;i++){
            String[] car = palabras[i].split(" ");
            for (int j=0; j<car.length;j++){
                str.append(caracteres.get(car[j]));
            }
            if(!(i==palabras.length -1))
                str.append(" ");
            }

        return str.toString();
    }


    public static Map<String, String> caracteres;
    static {
        caracteres = new HashMap<>();
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

    }
}
