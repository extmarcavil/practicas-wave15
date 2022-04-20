package introduccionspring.ejerciciopractico.numerosromanos.utils;

import java.util.TreeMap;

public class Convert {

    private static final TreeMap<Integer, String> numberToRomanMap;
    static {
        numberToRomanMap=new TreeMap<>();
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
    }

    public static String convertToRoman(Integer number){
        String romanNumber = "";
        while( number != 0 ){
            int floorKeyNumber = numberToRomanMap.floorKey(number);
            romanNumber += numberToRomanMap.get(floorKeyNumber);
            number -= floorKeyNumber;
        }
        return romanNumber;
    }
}
