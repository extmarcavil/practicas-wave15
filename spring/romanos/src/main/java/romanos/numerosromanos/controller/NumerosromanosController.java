package romanos.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.TreeMap;

@RestController
public class NumerosromanosController {

    @GetMapping("/convertir/{numero}")
    public String hello(@PathVariable Integer numero){
        String ret = toRoman(numero);
        /*
        String numeroRomano;
        if(numero < 4){
            numeroRomano = map.get(1) + map.get(1).repeat(numero-1);
            return numeroRomano;
        }else if(numero < 9){
            numeroRomano = map.get(5) + map.get(1).repeat(numero-1);
            return numeroRomano;
        }else if(numero < 14){
            numeroRomano = map.get(10) + map.get(1).repeat(numero-1);
            return numeroRomano;
        }else if(numero < 19){
            numeroRomano = map.get(15) + map.get(1).repeat(numero-1);
            return numeroRomano;
        }
        */

        return ret;
    }

    public static String toRoman(Integer numero){

        TreeMap<Integer,String> map = new TreeMap<>();
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

        int l =  map.floorKey(numero);
        if ( numero == l ) {
            return map.get(numero);
        }
        return map.get(l) + toRoman(numero-l);

    }

}
