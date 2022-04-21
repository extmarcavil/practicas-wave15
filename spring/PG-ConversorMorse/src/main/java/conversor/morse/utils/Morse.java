package conversor.morse.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Morse {

    private ArrayList<String> palabraEnMorse;
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
        caracteres.put("   ", " ");
    }

    public Morse(String fraseEnMorse) {
        this.palabraEnMorse = new ArrayList<>( Arrays.asList( fraseEnMorse.split("   ") ) );
    }

    public String convertirPalabras(String pabraEnMorse) {
        ArrayList<String> letrasEnMorse =new ArrayList<>( Arrays.asList( pabraEnMorse.split(" ") ) );
        return letrasEnMorse.stream().map(this::convertirLetra).reduce("",String::concat)  ;
    }

    public String convertirLetra(String morseWord) {
        String palabra = caracteres.get(morseWord);
        return palabra;
    }

    public String translate(){
        String fraseCompleta = this.palabraEnMorse
                .stream()
                .map(this::convertirPalabras)
                .reduce("",(x,y)->x + " " + y);
        fraseCompleta.substring(0, fraseCompleta.length() - 1);
        return fraseCompleta;
    }
}
