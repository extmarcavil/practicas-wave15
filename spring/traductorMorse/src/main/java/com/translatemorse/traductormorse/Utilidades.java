package com.translatemorse.traductormorse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utilidades {
    HashMap<Character, String> abc = new HashMap<>();
    HashMap<String, Character> abcInverso = new HashMap<>();
    String traduccion = "";
    String[] palabras = new String[100];


    public String traducir(String texto) {
        abc.put('a', ".-");
        abc.put('b', "-...");
        abc.put('c', "-.-.");
        abc.put('d', "-..");
        abc.put('e', ".");
        abc.put('f', "..-.");
        abc.put('g', "--.");
        abc.put('h', "....");
        abc.put('i', "..");
        abc.put('j', ".---");
        abc.put('k', "-.-");
        abc.put('l', ".-..");
        abc.put('m', "--");
        abc.put('n', "-.");
        abc.put('o', "---");
        abc.put('p', ".--.");
        abc.put('q', "--.-");
        abc.put('r', ".-.");
        abc.put('s', "...");
        abc.put('t', "-");
        abc.put('u', "..-");
        abc.put('v', "...-");
        abc.put('w', ".--");
        abc.put('x', "-..-");
        abc.put('y', "-.--");
        abc.put('z', "--..");
        abc.put('?', "..--..");
        abc.put('!', "-.-.--");
        abc.put('.', ".-.-.-");
        abc.put(',', "--..--");
        abc.put('1', ".----");
        abc.put('2', "..---");
        abc.put('3', "...--");
        abc.put('4', "....-");
        abc.put('5', ".....");
        abc.put('6', "-....");
        abc.put('7', "--...");
        abc.put('8', "---..");
        abc.put('9', "----.");
        abc.put('0', "-----");

        abcInverso.put(".-", 'a');
        abcInverso.put("-...", 'b');
        abcInverso.put("-.-.", 'c');
        abcInverso.put("-..", 'd');
        abcInverso.put(".", 'e');
        abcInverso.put("..-.", 'f');
        abcInverso.put("--.", 'g');
        abcInverso.put("....", 'h');
        abcInverso.put("..", 'i');
        abcInverso.put(".---", 'j');
        abcInverso.put("-.-", 'k');
        abcInverso.put(".-..", 'l');
        abcInverso.put("--", 'm');
        abcInverso.put("-.", 'n');
        abcInverso.put("---", 'o');
        abcInverso.put(".--.", 'p');
        abcInverso.put("--.-", 'q');
        abcInverso.put(".-.", 'r');
        abcInverso.put("...", 's');
        abcInverso.put("-", 't');
        abcInverso.put("..-", 'u');
        abcInverso.put("...-", 'v');
        abcInverso.put(".--", 'w');
        abcInverso.put("-..-", 'x');
        abcInverso.put("-.--", 'y');
        abcInverso.put("--..", 'z');
        abcInverso.put("..--..", '?');
        abcInverso.put("-.-.--", '!');
        abcInverso.put(".-.-.-", '.');
        abcInverso.put("--..--", ',');
        abcInverso.put(".----", '1');
        abcInverso.put("..---", '2');
        abcInverso.put("...--", '3');
        abcInverso.put("....-", '4');
        abcInverso.put(".....", '5');
        abcInverso.put("-....", '6');
        abcInverso.put("--...", '7');
        abcInverso.put("---..", '8');
        abcInverso.put("----.", '9');
        abcInverso.put("-----", '0');
        abcInverso.put(" ", ' ');

        palabras = texto.split("   ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            String letras = palabras[i];
            if (letras.isEmpty()) {
                continue;
            }
            String[] letrasSeparadas = letras.split(" ");
            for (String letra : letrasSeparadas) {
                sb.append(abcInverso.get(letra));
            }
            if (i != palabras.length - 1) sb.append(" ");

        }

        return sb.toString();
    }
}

//    StringBuilder stringBuffer = new StringBuilder();
//    for (int i = 0; i < words.length; i++) {
//        String word = words[i];
//        if (word.isEmpty())
//        continue;
//        String[] characters = word.split(" ");
//        for (String character : characters) {
//        stringBuffer.append(decodeLetter(character));
//        }
//        if (i != words.length - 1)
//        stringBuffer.append(" ");
//        }
//        return stringBuffer.toString();
//        }