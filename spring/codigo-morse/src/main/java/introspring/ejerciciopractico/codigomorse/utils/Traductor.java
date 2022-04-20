package introspring.ejerciciopractico.codigomorse.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traductor {
    private static final Map<String, String> caracteres;
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

    public static String traducir(String palabraMorse){
        StringBuilder resp= new StringBuilder();
        String[] palabras=palabraMorse.split("   ");
        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for(String letra : letras){
                resp.append(caracteres.get(letra));
            }
            resp.append(" ");
        }
        return resp.substring(0,resp.length()-1);
    }
}
