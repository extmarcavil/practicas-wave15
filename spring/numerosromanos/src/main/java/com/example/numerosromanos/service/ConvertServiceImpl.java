package com.example.numerosromanos.service;


import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class ConvertServiceImpl implements IConvertService {


    /**
     * Logica de negocio.
     *
     * @param number
     * @return
     */
    @Override
    public String toRomanNumeral(int number) {


        TreeMap<Integer, String> romanMap = new TreeMap<>();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        String numberRoman = "";

        while (number != 0) {
            int floorKey = romanMap.floorKey(number);
            numberRoman += romanMap.get(floorKey);
            number -= floorKey;
        }
        return numberRoman;
    }
}
