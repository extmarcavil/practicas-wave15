package com.codigomorse.morse.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Decodificador {

    @GetMapping("/{codigoMorse}")
    private String decodificar(@PathVariable String codigoMorse) {

        Map<String,String> dic = new HashMap<>();
        dic.put(".-","A");
        dic.put("-...","B");
        dic.put("-.-.","C");
        dic.put("-..","D");
        dic.put(".","E");
        dic.put("..-.","F");
        dic.put("--.","G");
        dic.put("....","H");
        dic.put("..","I");
        dic.put(".---","J");
        dic.put("-.-","K");
        dic.put(".-..","L");
        dic.put("--","M");
        dic.put("-.","N");
        dic.put("---","O");
        dic.put(".--.","P");
        dic.put("--.-","Q");
        dic.put(".-.","R");
        dic.put("...","S");
        dic.put("-","T");
        dic.put("..-","U");
        dic.put("...-","V");
        dic.put(".--","W");
        dic.put("-..-","X");
        dic.put("-.--","Y");
        dic.put("--..","Z");
        dic.put(".----","1");
        dic.put("..---","2");
        dic.put("...--","3");
        dic.put("....-","4");
        dic.put(".....","5");
        dic.put("_....","6");
        dic.put("__...","7");
        dic.put("___..","8");
        dic.put("____.","9");
        dic.put("_____","0");
        dic.put("..--..","?");
        dic.put(".-.-.-",".");
        dic.put("-.-.--","!");
        dic.put("--..--",",");


        String mensaje = "";
        String[] caracteresMorse = codigoMorse.split(" ");
        //Codigo con compañeros
//        boolean espacio = false;
//        for (int i = 0; i < caracteresMorse.length; i++) {
//            if (dic.get(caracteresMorse[i]) == null && !espacio) {
//                mensaje += " ";
//                espacio = true;
//            } else if (espacio){
//                espacio = false;
//            } else {
//                mensaje += dic.get(caracteresMorse[i]);
//            }
//        }
        //Codigo personal final
        boolean espacio = false;
        for (String p:caracteresMorse) {
            String [] letras = p.split(" ");
            for (String p2: letras) {
                if(dic.get(p2)==null && !espacio){
                    mensaje+=" ";
                    espacio = true;
                }else if(espacio){
                    espacio = false;
                } else mensaje+= dic.get(p2);
            }
        }
        return mensaje;
    }
}

