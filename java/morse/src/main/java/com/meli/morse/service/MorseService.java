package com.meli.morse.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MorseService {

    public static final String CODE_NOT_VALID = "CODE RECEIVED FOR DECODING IS INVALID";

    public String decode(String code) {
        StringBuilder result = new StringBuilder();
        String[] wordsSplitter = code.split(" ");

        for (int i = 0; i < wordsSplitter.length; i++) {
            String keyMorse = wordsSplitter[i];

            if (!keyMorse.isBlank()) {
                result.append(codeMorse().get(keyMorse));
            } else if (wordsSplitter[i+1].isBlank()) {
                result.append(" ");
            }
        }
        return result.length() == 0 ? CODE_NOT_VALID : result.toString();
    }

    private Map<String, String> codeMorse() {
        return Map.ofEntries(
                Map.entry(".-", "A"), Map.entry("-...", "B"),
                Map.entry("-.-.", "C"), Map.entry("-..", "D"),
                Map.entry(".", "E"), Map.entry("..-.", "F"),
                Map.entry("--.", "G"), Map.entry("....", "H"),
                Map.entry("..", "I"), Map.entry(".---", "J"),
                Map.entry("-.-", "K"), Map.entry(".-..", "L"),
                Map.entry("--", "M"), Map.entry("-.", "N"),
                Map.entry("---", "O"), Map.entry(".--.", "P"),
                Map.entry("--.-", "Q"), Map.entry(".-.", "R"),
                Map.entry("...", "S"), Map.entry("-", "T"),
                Map.entry("..-", "U"), Map.entry("...-", "V"),
                Map.entry("-.--", "Y"), Map.entry("-..-", "X"),
                Map.entry(".----", "1"), Map.entry("..---", "2"),
                Map.entry("...--", "3"), Map.entry("....-", "4"),
                Map.entry(".....", "5"), Map.entry("-....", "6"),
                Map.entry("--...", "7"), Map.entry("---..", "8"),
                Map.entry("----.", "9"), Map.entry("-----", "0"),
                Map.entry("..--..", "?"), Map.entry("-.-.--", "!"),
                Map.entry(".-.-.-", "."), Map.entry("--..--", ",")
        );
    }
}
