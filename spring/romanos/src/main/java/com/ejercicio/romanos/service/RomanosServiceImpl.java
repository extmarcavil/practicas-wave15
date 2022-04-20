package com.ejercicio.romanos.service;

import org.springframework.stereotype.Service;

@Service
public class RomanosServiceImpl implements  RomanosService{


    @Override
    public String calcularRomanos(int number) {

        String result = "";

        if(number == 1) {result =  result + "I";}
        if(number == 2) {result =  result + "II";}
        if(number == 3) {result =  result + "III";}
        if(number == 4) {result =  result + "IV";}
        if(number == 5) {result =  result + "V";}
        if(number == 7) {result =  result + "VII";}
        if(number == 10) {result =  result + "X";}
        if(number == 13) {result =  result + "XIII";}
        if(number == 50) {result =  result + "L";}
        if(number == 100) {result =  result + "C";}
        if(number == 500) {result =  result + "D";}
        if(number == 1000) {result =  result + "M";}


        return result;
    }
}
