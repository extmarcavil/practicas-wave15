package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
public class RomanController {

    @GetMapping("/convertToRomano/{number}")
    public String number(@PathVariable int number){
        return convertToRomano(number);
    }
    public static String convertToRomano(int number){
        TreeMap<Integer, String> map = new TreeMap<>();
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
        int num = map.floorKey(number);
        if ( number == num ) {
            return (map.get(number));
        }
        return (map.get(num) + convertToRomano(number-num));
    }
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
        @ResponseBody
        public String welcomeAsHTML() {
            return "<html>\n" +
                    "<header>\n" +
                    "<title>Welcome</title>\n" +
                    "</header>\n" +
                    "<body>\n" +
                    "<h2 style=\"display: flex; justify-content: center; background-color:Tomato;\">Conversor de Numeros Romanos\n" +
                    "</h2>\n" +
                    "<div style=\"display: flex; justify-content: center;\">\n" +
                    "<h4>Ingrese el numero que desea convertir</h4>\n" +
                    "</div>\n" +
                    "<div style=\"display: flex; justify-content: center;\">\n" +
                    "<input type=\"number\" id=\"num\" name=\"num\"><br><br>\n" +
                    "</div>\n" +
                    "<div style=\"display: flex; justify-content: center;\">\n" +
                    "<input type=\"submit\" value=\"Convertir\" onclick=\"myFunction()\">\n" +
                    "</div>\n" +
                    "<script>\n" +
                    "function myFunction() {\n" +
                    "var x = document.getElementById(\"num\").value\n" +
                    "location.replace(\"/convertToRomano/\"+x)}\n" +
                    "</script>\n" +
                    "</body>\n" +
                    "</html>\n";
        }
}