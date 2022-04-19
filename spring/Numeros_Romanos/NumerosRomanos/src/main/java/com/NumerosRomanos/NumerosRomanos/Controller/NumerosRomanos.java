package com.NumerosRomanos.NumerosRomanos.Controller;

import com.sun.source.tree.Tree;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.TreeMap;

@RestController
public class NumerosRomanos {

    @GetMapping("/{numero}")
    public String Conversion(@PathVariable Integer numero){

        TreeMap<Integer, String> dicionario = new TreeMap<>();

        //se agregan las variables
        dicionario.put(1,"I");
        dicionario.put(4,"IV");
        dicionario.put(5,"V");
        dicionario.put(9,"IX");
        dicionario.put(10,"X");
        dicionario.put(40,"XL");
        dicionario.put(50,"L");
        dicionario.put(90,"XC");
        dicionario.put(100,"C");
        dicionario.put(400,"CD");
        dicionario.put(500,"D");
        dicionario.put(900,"CM");
        dicionario.put(1000,"M");

        return ConversionARomano(numero, dicionario);
    }

    private String ConversionARomano(int numero, TreeMap<Integer,String> dic){
        int i = dic.floorKey(numero);
        if (numero == i) {
            return dic.get(numero);
        }
        int dif = numero - i;
        return dic.get(i) + ConversionARomano(dif,dic);
    }
}
