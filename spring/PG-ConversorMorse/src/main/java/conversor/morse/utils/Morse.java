package conversor.morse.utils;

import java.util.*;

public class Morse {

    private ArrayList<String> palabraEnMorse;
    public static Map<String, String> morseALetra;
    static {
        morseALetra = new HashMap<>();
        morseALetra.put(".-", "A");
        morseALetra.put("-...", "B");
        morseALetra.put("-.-.", "C");
        morseALetra.put("-..", "D");
        morseALetra.put(".", "E");
        morseALetra.put("..-.", "F");
        morseALetra.put("--.", "G");
        morseALetra.put("....", "H");
        morseALetra.put("..", "I");
        morseALetra.put(".---", "J");
        morseALetra.put("-.-", "K");
        morseALetra.put(".-..", "L");
        morseALetra.put("--", "M");
        morseALetra.put("-.", "N");
        morseALetra.put("---", "O");
        morseALetra.put(".--.", "P");
        morseALetra.put("--.-", "Q");
        morseALetra.put(".-.", "R");
        morseALetra.put("...", "S");
        morseALetra.put("-", "T");
        morseALetra.put("..-", "U");
        morseALetra.put("...-", "V");
        morseALetra.put(".--", "W");
        morseALetra.put("-..-", "X");
        morseALetra.put("-.--", "Y");
        morseALetra.put("--..", "Z");
        morseALetra.put(".----", "1");
        morseALetra.put("..---", "2");
        morseALetra.put("...--", "3");
        morseALetra.put("....-", "4");
        morseALetra.put(".....", "5");
        morseALetra.put("-....", "6");
        morseALetra.put("--...", "7");
        morseALetra.put("---..", "8");
        morseALetra.put("----.", "9");
        morseALetra.put("-----", "0");
        morseALetra.put("..--..", "?");
        morseALetra.put("-.-.--", "!");
        morseALetra.put(".-.-.-", ".");
        morseALetra.put("--..--", ",");
    }

    public Morse(String fraseEnMorse) {
        this.palabraEnMorse = new ArrayList<>( Arrays.asList( fraseEnMorse.split("   ") ) );
    }

    public String convertirPalabras(String pabraEnMorse) {
        ArrayList<String> letrasEnMorse =new ArrayList<>( Arrays.asList( pabraEnMorse.split(" ") ) );
        return letrasEnMorse.stream().map(this::convertirLetra).reduce("",String::concat)  ;
    }

    public String convertirLetra(String letraEnMorse) {
        String letra = "";
        if( morseALetra.containsKey(letraEnMorse)){
            letra = morseALetra.get(letraEnMorse);
        }else{
            letra = "*"; //MorseNoReconocido
        }
        return letra;
    }

    public String convertir(){
        String fraseCompleta = this.palabraEnMorse.
                stream()
                .map(this::convertirPalabras)
                .reduce("",(x,y)->x + " " + y);

        fraseCompleta.substring(0, fraseCompleta.length() - 1);
        return fraseCompleta;

    }
}
