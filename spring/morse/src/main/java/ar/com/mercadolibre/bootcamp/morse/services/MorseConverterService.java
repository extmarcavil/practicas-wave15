package ar.com.mercadolibre.bootcamp.morse.services;

import org.springframework.stereotype.Service;

@Service
public class MorseConverterService {
    // Morse code by indexing
    private String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    public String morse2text(String morseCode) {
        String[] array = morseCode.split(" ");
        String ret = "";

        // Morse code to English
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    ret = ret + (char)(j + 'a');
                    break;
                }
            }
        }

        return ret;
    }
}
