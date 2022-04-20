package com.kopitz.inttoroman.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class intToRoman {

    @GetMapping("/convert/{number}")
    public String Convert(@PathVariable Integer number) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(number >= values[i]) {
                number -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

}
