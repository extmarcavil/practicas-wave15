package com.springp2vivo.morsecode.util;


import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.stream.Stream;

public class Traduccion {

    public static HashMap<String ,String> obtenerMorse(){
        HashMap<String,String> significadoMorse = new HashMap<>();
        significadoMorse.put(".-","A");
        significadoMorse.put("-...","B");
        significadoMorse.put("-.-.","C");
        significadoMorse.put("-..","D");
        significadoMorse.put(".","E");
        significadoMorse.put("..-.","F");
        significadoMorse.put("--.","G");
        significadoMorse.put("....","H");
        significadoMorse.put("..","I");
        significadoMorse.put(".---","J");
        significadoMorse.put("-.-","K");
        significadoMorse.put(".-..","L");
        significadoMorse.put("--","M");
        significadoMorse.put("-.","N");
        significadoMorse.put("---","O");
        significadoMorse.put(".--.","P");
        significadoMorse.put("--.-","Q");
        significadoMorse.put(".-.","R");
        significadoMorse.put("...","S");
        significadoMorse.put("-","T");
        significadoMorse.put("..-","U");
        significadoMorse.put("...-","V");
        significadoMorse.put(".--","W");
        significadoMorse.put("-..-","X");
        significadoMorse.put("-.--","Y");
        significadoMorse.put("--..","Z");
        significadoMorse.put(".----","1");
        significadoMorse.put("..---","2");
        significadoMorse.put("...--","3");
        significadoMorse.put("....-","4");
        significadoMorse.put(".....","5");
        significadoMorse.put("-....","6");
        significadoMorse.put("--...","7");
        significadoMorse.put("---..","8");
        significadoMorse.put("----.","9");
        significadoMorse.put("-----","0");

        significadoMorse.put("..--..","?");
        significadoMorse.put("-.-.--","!");
        significadoMorse.put(".-.-.-",".");
        significadoMorse.put("--..--",",");
        significadoMorse.put(""," ");

        return significadoMorse;
    }


    public static HashMap<String ,String> obtenerASCII(){
        HashMap<String,String> significadoASCII = new HashMap<>();
        significadoASCII.put("A",".-");
        significadoASCII.put("B","-...");
        significadoASCII.put("C","-.-.");
        significadoASCII.put("D","-..");
        significadoASCII.put("E",".");
        significadoASCII.put("F","..-.");
        significadoASCII.put("G","--.");
        significadoASCII.put("H","....");
        significadoASCII.put("I","..");
        significadoASCII.put("J",".---");
        significadoASCII.put("K","-.-");
        significadoASCII.put("L",".-..");
        significadoASCII.put("M","--");
        significadoASCII.put("N","-.");
        significadoASCII.put("O","---");
        significadoASCII.put("P",".--.");
        significadoASCII.put("Q","--.-");
        significadoASCII.put("R",".-.");
        significadoASCII.put("S","...");
        significadoASCII.put("T","-");
        significadoASCII.put("U","..-");
        significadoASCII.put("V","...-");
        significadoASCII.put("W",".--");
        significadoASCII.put("X","-..-");
        significadoASCII.put("Y","-.--");
        significadoASCII.put("Z","--..");
        significadoASCII.put("1",".----");
        significadoASCII.put("2","..---");
        significadoASCII.put("3","...--");
        significadoASCII.put("4","....-");
        significadoASCII.put("5",".....");
        significadoASCII.put("6","-....");
        significadoASCII.put("7","--...");
        significadoASCII.put("8","---..");
        significadoASCII.put("9","----.");
        significadoASCII.put("0","-----");

        significadoASCII.put("?","..--..");
        significadoASCII.put("!","-.-.--");
        significadoASCII.put(".",".-.-.-");
        significadoASCII.put(",","--..--");
        significadoASCII.put(" ","");

        return significadoASCII;
    }

    public static String devolverConversion(String[] codigo, HashMap<String,String> diccionario, String espacio){
        StringBuilder traduccion = new StringBuilder();

        try {
            Stream.of(codigo).forEach(c -> {
                traduccion.append(diccionario.get(c).equals(" ") && traduccion.substring(traduccion.length() - 1, traduccion.length()).equals(" ") ? "" : diccionario.get(c) + espacio);
            });

            return traduccion.toString();
        }catch (Exception e){
            return null;
        }

    }
}
