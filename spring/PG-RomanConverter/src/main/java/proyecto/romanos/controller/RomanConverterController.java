package proyecto.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.TreeMap;

@RestController
public class RomanConverterController {

    @GetMapping("/convert/{number}")
    public String getRoman(@PathVariable Integer number){
        String romanNumber = toRoman(number);

        return "El numero ingresado es "+ number + " y la conversion a Romano es: " + romanNumber ;
    }

    private static String toRoman(int numberToConvert) {
        TreeMap<Integer, String> numberToRomanMap = new TreeMap<Integer, String>();
        numberToRomanMap.put(1000, "M");
        numberToRomanMap.put(900, "CM");
        numberToRomanMap.put(500, "D");
        numberToRomanMap.put(400, "CD");
        numberToRomanMap.put(100, "C");
        numberToRomanMap.put(90, "XC");
        numberToRomanMap.put(50, "L");
        numberToRomanMap.put(40, "XL");
        numberToRomanMap.put(10, "X");
        numberToRomanMap.put(9, "IX");
        numberToRomanMap.put(5, "V");
        numberToRomanMap.put(4, "IV");
        numberToRomanMap.put(1, "I");

        String romanNumber = "";

        while( numberToConvert != 0 ){
            int floorKeyNumber = numberToRomanMap.floorKey(numberToConvert);
            romanNumber += numberToRomanMap.get(floorKeyNumber);
            numberToConvert -= floorKeyNumber;
        }
        return romanNumber;
    }

}
