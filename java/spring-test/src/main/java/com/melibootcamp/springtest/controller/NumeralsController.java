package com.melibootcamp.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.Function;

import static java.lang.Math.abs;

@RestController
public class NumeralsController {
    @GetMapping("/numerals/roman/from_decimal/{number}")
    public String getRoman(@PathVariable Integer number) {
        String n = toRoman(number);
        return n;
    }

    private static String toRoman(int number) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);

    /*
    No genera bien números como 900 (CM):
    @GetMapping("/numerals/roman/from_decimal/v1/{num}")
    public String romansFromDecimalv2(@PathVariable int num) {
        Map<Integer, String> numberMap = new TreeMap<>(); // TreeMap is used to preserve the keys' order on retrieval
        numberMap.put(1, "I");
        numberMap.put(5, "V");
        numberMap.put(10, "X");
        numberMap.put(50, "L");
        numberMap.put(100, "C");
        numberMap.put(500, "D");
        numberMap.put(1000, "M");

        Function<Integer, Integer> findPrevKey = (Integer n) -> {
            Integer lastItem = null;

            for (Integer k : numberMap.keySet()) {
                if (k > n)
                    break;

                lastItem = k;
            }

            return lastItem;
        };

        StringBuilder result = new StringBuilder();

        if (numberMap.containsKey(num)) {
            return numberMap.get(num);
        }

        int nearestFive = (int) (num >= 4 ? Math.round(num / 5.0) * 5 : 1);

        if (!numberMap.containsKey(nearestFive)) {
            Integer prevRomanNumeralKey = findPrevKey.apply(nearestFive);
            System.out.println(prevRomanNumeralKey);
            String prevRomanNumeral = numberMap.get(prevRomanNumeralKey);

            int timesContained = (int) Math.floor(num / prevRomanNumeralKey);
            result.append(prevRomanNumeral.repeat(timesContained));

            int leftover = num - prevRomanNumeralKey * timesContained;

            if (leftover != 0)
                result.append(romansFromDecimalv2(leftover));
        } else {
            String romanNumeral = numberMap.get(nearestFive);
            int difference = num - nearestFive;

            if(difference < 0) {
                result.append(numberMap.get(Math.abs(difference)));
                result.append(romanNumeral);
            } else {
                result.append(romanNumeral);
                result.append(romansFromDecimalv2(difference));
            }
        }

        return result.toString();
    }
    */
    }
}