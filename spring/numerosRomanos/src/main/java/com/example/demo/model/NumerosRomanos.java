package com.example.demo.model;

import java.util.Map;
import java.util.TreeMap;

public class NumerosRomanos {

    private Integer numberToConvert;
    public TreeMap<Integer, String> decimalToRoman = new TreeMap<>();

    public NumerosRomanos(Integer numberToConvert) {
        this.numberToConvert = numberToConvert;
        decimalToRoman.put(1, "I");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(5, "V");
        decimalToRoman.put(9, "IX");
        decimalToRoman.put(10, "X");
        decimalToRoman.put(40, "XL");
        decimalToRoman.put(50, "L");
        decimalToRoman.put(90, "XC");
        decimalToRoman.put(100, "C");
        decimalToRoman.put(400, "CD");
        decimalToRoman.put(500, "D");
        decimalToRoman.put(900, "DM");
        decimalToRoman.put(1000, "M");
    }

    public Integer getNumberToConvert() {
        return numberToConvert;
    }

    public void setNumberToConvert(Integer numberToConvert) {
        this.numberToConvert = numberToConvert;
    }

    public TreeMap<Integer, String> getDecimalToRoman() {
        return decimalToRoman;
    }

    public void setDecimalToRoman(TreeMap<Integer, String> decimalToRoman) {
        this.decimalToRoman = decimalToRoman;
    }

    public String convert(){
        String roman = "";
        while(this.numberToConvert > 0) {
            int closestKey = decimalToRoman.floorKey(this.numberToConvert);
            roman += decimalToRoman.get(closestKey);
            this.numberToConvert -= closestKey;
        }
        return roman;
    }
}
