package com.vparula.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;
@RestController
public class NumerosromanosApplicationController {

    @GetMapping("/{number}")
    public String getRoman(@PathVariable Integer number){
        String n = toRomanMap(number);
        return n;
    }


    @GetMapping("/fromRoman/{romano}")
    public Integer fromRoman(@PathVariable String romano){
        Integer n = fromRomano(romano);
        return n;
    }


    private static String toRomanMap(Integer number) {
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
        String romanNumber = "";

        while( number != 0 ){
            int floorKeyNumber = map.floorKey(number);
            romanNumber += map.get(floorKeyNumber);
            number -= floorKeyNumber;
        }
        return romanNumber;
    }





    private static Integer fromRomano(String romano) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        int ant = 0;
        int suma = 0;
        char letra = ' ';

        boolean termine = false;
        int tamano = 1;
        String itero = romano;
        while (!termine){
            if ((itero.length()==1) || (itero.length()==2 && map.containsKey(itero))) {
                termine = true;
                suma+= map.get(itero);
            }else {
                if (itero.length() > 2 && map.containsKey(itero.substring(itero.length() - 2, itero.length() ))) {

                    suma += map.get(itero.substring(itero.length() - 2, itero.length() ));
                    itero = itero.substring(0, itero.length() - 2);

                } else {

                    System.out.println(itero.substring(itero.length() - 1, itero.length()));
                    suma += map.get(itero.substring(itero.length() - 1));
                    itero = itero.substring(0, itero.length() - 1);

                }
            }

        }

   return suma;
}
}
