package conversor.morse.utils;

import java.util.*;

public class Morse {

    static class MyHashMap<K, V> extends HashMap<K, V>
    {
        Map<V, K> reverseMap = new HashMap<>();

        @Override
        public V put(K key, V value)
        {
            reverseMap.put(value, key);
            return super.put(key, value);
        }

        public K getKey(V value) {
            return reverseMap.get(value);
        }

    }

    public static MyHashMap<String, String> morseToLetterMap;
    static {
        morseToLetterMap = new MyHashMap<>();
        morseToLetterMap.put(".-", "A");
        morseToLetterMap.put("-...", "B");
        morseToLetterMap.put("-.-.", "C");
        morseToLetterMap.put("-..", "D");
        morseToLetterMap.put(".", "E");
        morseToLetterMap.put("..-.", "F");
        morseToLetterMap.put("--.", "G");
        morseToLetterMap.put("....", "H");
        morseToLetterMap.put("..", "I");
        morseToLetterMap.put(".---", "J");
        morseToLetterMap.put("-.-", "K");
        morseToLetterMap.put(".-..", "L");
        morseToLetterMap.put("--", "M");
        morseToLetterMap.put("-.", "N");
        morseToLetterMap.put("---", "O");
        morseToLetterMap.put(".--.", "P");
        morseToLetterMap.put("--.-", "Q");
        morseToLetterMap.put(".-.", "R");
        morseToLetterMap.put("...", "S");
        morseToLetterMap.put("-", "T");
        morseToLetterMap.put("..-", "U");
        morseToLetterMap.put("...-", "V");
        morseToLetterMap.put(".--", "W");
        morseToLetterMap.put("-..-", "X");
        morseToLetterMap.put("-.--", "Y");
        morseToLetterMap.put("--..", "Z");
        morseToLetterMap.put(".----", "1");
        morseToLetterMap.put("..---", "2");
        morseToLetterMap.put("...--", "3");
        morseToLetterMap.put("....-", "4");
        morseToLetterMap.put(".....", "5");
        morseToLetterMap.put("-....", "6");
        morseToLetterMap.put("--...", "7");
        morseToLetterMap.put("---..", "8");
        morseToLetterMap.put("----.", "9");
        morseToLetterMap.put("-----", "0");
        morseToLetterMap.put("..--..", "?");
        morseToLetterMap.put("-.-.--", "!");
        morseToLetterMap.put(".-.-.-", ".");
        morseToLetterMap.put("--..--", ",");
    }

    private Morse(){}

    private static String convertMorseWord(String morseWord) {
        ArrayList<String> listOfLettersInMorse = Morse.toList(morseWord," ");
        return listOfLettersInMorse.stream().map(Morse::convertMorseLetter).reduce("",String::concat)  ;
    }

    private static String convertToMorseWord(String wordToConvert) {
        ArrayList<String> listOfLetters = Morse.toList(wordToConvert,"");
        return listOfLetters.stream().map(Morse::convertToMorseLetter).reduce("",(x,y)->x + " " + y)  ;
    }

    private static String convertMorseLetter(String letterInMorse) {
        return morseToLetterMap.getOrDefault(letterInMorse, "*");
    }

    private static String convertToMorseLetter(String letterToConvert) {
        return morseToLetterMap.getKey(letterToConvert);
    }

    private static ArrayList<String> toList(String sentenceToConvert, String separator){
        return new ArrayList<>( Arrays.asList( sentenceToConvert.split(separator) ) );
    }

    public static String morseToSentence(String fraseEnMorse){
        ArrayList<String> palabraEnMorse = Morse.toList(fraseEnMorse, "   ");
        String fraseCompleta =
                palabraEnMorse
                .stream()
                .map(Morse::convertMorseWord)
                .reduce("",(x,y)->x + " " + y);

        fraseCompleta.substring(0, fraseCompleta.length() - 1);
        return fraseCompleta;

    }

    public static String sentenceToMorse(String sentenceToConvert) {

        ArrayList<String> listOfWordsToConvert = Morse.toList(sentenceToConvert.toUpperCase(Locale.ROOT)," ");

        String sentenceInMorse  =  listOfWordsToConvert
                                .stream()
                                .map(Morse::convertToMorseWord)
                                .reduce("",(x,y)->x + "   " + y);
        return sentenceInMorse;


    }
}
