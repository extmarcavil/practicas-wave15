package com.example.romannumberapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberController {

    @GetMapping("/convertToRoman /{number}")
    public static String convertToRoman(@PathVariable double number) {
        double i, miles, centenas, decenas, unidades;
        String romanNumber = "";

        //Obtener cifras del nro
        miles = number / 1000;
        centenas = number / 100 % 10;
        decenas = number / 10 % 10;
        unidades = number % 10;

        //Validar millar
        for (i = 1; i <= miles; i++) {
            romanNumber = romanNumber + "M";
        }

        //Validar centenas
        if (centenas == 9) {
            romanNumber = romanNumber + "CM";
        } else if (centenas >= 5) {
            romanNumber = romanNumber + "D";
            for (i = 6; i <= centenas; i++) {
                romanNumber = romanNumber + "C";
            }
        } else if (centenas == 4) {
            romanNumber = romanNumber + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romanNumber = romanNumber + "C";
            }
        }

        //Validar decenas
        if (decenas == 9) {
            romanNumber = romanNumber + "XC";
        } else if (decenas >= 5) {
            romanNumber = romanNumber + "L";
            for (i = 6; i <= decenas; i++) {
                romanNumber = romanNumber + "X";
            }
        } else if (decenas == 4) {
            romanNumber = romanNumber + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romanNumber = romanNumber + "X";
            }
        }

        //Validar unidades
        if (unidades == 9) {
            romanNumber = romanNumber + "IX";
        } else if (unidades >= 5) {
            romanNumber = romanNumber + "V";
            for (i = 6; i <= unidades; i++) {
                romanNumber = romanNumber + "I";
            }
        } else if (unidades == 4) {
            romanNumber = romanNumber + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romanNumber = romanNumber + "I";
            }
        }

        return romanNumber;
    }


    //Solución playground
    @GetMapping("/toRoman/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }
}
