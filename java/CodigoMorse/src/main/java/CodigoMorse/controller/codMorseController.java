package CodigoMorse.controller;
import CodigoMorse.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class codMorseController {

    @GetMapping("hello/{name}") //test en -> localhost:8080/hello/vane
    public String hello(@PathVariable String name){

        return "Hola "+name+"!!!";
    }

    // ... --- .-.. .-   ... --- .-.. .-=   HOLA HOLA
    @GetMapping("convert/{code}")
    public String convert(@PathVariable String code) {
        System.out.println(code);
        StringBuilder result = new StringBuilder();
        String[] codPalabras = code.split("   ");

        for (int i = 0; i < codPalabras.length; i++) {
           String palabra= convertirALetras(codPalabras[i]);
           result.append(palabra+" ");
        }
        result.deleteCharAt(result.length()-1); //borra el último espacio que sobra en la frase
        return result.toString();
    }

    //recibe el codigo morse de una Palabra y lo convierte a string
    private String convertirALetras(String codPalabra){
        String[] letras = codPalabra.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < letras.length; i++) {
            String letra = mapMorse().get(letras[i]);
            result.append(letra);
        }
        return result.toString();

    }

    public Map<String, String> mapMorse() {
        Map<String, String> caracteres = new HashMap<>();
        caracteres.put(".-", "A");caracteres.put("-...", "B");
        caracteres.put("-.-.", "C");caracteres.put("-..", "D");
        caracteres.put(".", "E");caracteres.put("..-.", "F");
        caracteres.put("--.", "G");caracteres.put("....", "H");
        caracteres.put("..", "I");caracteres.put(".---", "J");
        caracteres.put("-.-", "K");caracteres.put(".-..", "L");
        caracteres.put("--", "M");caracteres.put("-.", "N");
        caracteres.put("---", "O");caracteres.put(".--.", "P");
        caracteres.put("--.-", "Q");caracteres.put(".-.", "R");
        caracteres.put("...", "S");caracteres.put("-", "T");
        caracteres.put("..-", "U");caracteres.put("...-", "V");
        caracteres.put(".--", "W");caracteres.put("-..-", "X");
        caracteres.put("-.--", "Y");caracteres.put("--..", "Z");
        caracteres.put(".----", "1");caracteres.put("..---", "2");
        caracteres.put("...--", "3");caracteres.put("....-", "4");
        caracteres.put(".....", "5");caracteres.put("-....", "6");
        caracteres.put("--...", "7");caracteres.put("---..", "8");
        caracteres.put("----.", "9");caracteres.put("-----", "0");
        caracteres.put("..--..", "?");caracteres.put("-.-.--", "!");
        caracteres.put(".-.-.-", ".");caracteres.put("--..--", ",");


        return caracteres;
    }

}

