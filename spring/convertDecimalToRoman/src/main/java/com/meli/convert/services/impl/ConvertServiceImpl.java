package com.meli.convert.services.impl;

import com.meli.convert.services.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    private static final String[] ROMAN_LITERALS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private static final int[] VALUES = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

    @Override
    public String convertDecimalToRoman(Integer decimal) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while(decimal >= VALUES[i]) {
                decimal -= VALUES[i];
                roman.append((ROMAN_LITERALS[i]));
            }
        }
        return roman.toString();
    }
}
