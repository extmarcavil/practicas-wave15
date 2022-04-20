package morse.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigomorseController {

    public static Map<String, String> caracteres;
    static {
        caracteres = new HashMap<>();
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

    }

    @GetMapping("/api/convertir/{codigoMorse}")
    public String convertirCodigoMorse(@PathVariable String codigoMorse) {

        String[] palabras = codigoMorse.split("   ");
        if (palabras.length == 0) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        String palabra;
        String[] letras;

        for (int i = 0; i < palabras.length; i++) {
            palabra = palabras[i];
            if (palabra.equals(""))
                continue;
            letras = palabra.split(" ");
            for (String letra : letras) {
                stringBuffer.append(caracteres.get(letra));
            }
            stringBuffer.append(" ");
        }
        String traduccion = stringBuffer.toString();
        traduccion.substring(0, traduccion.length() - 1);

        return traduccion;
    }

}
