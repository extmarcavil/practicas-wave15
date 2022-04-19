package ar.com.alehenestroza.apinumerosromanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {
    private static String convertirANumeroRomano(int numero) {
        return "I".repeat(numero)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    @GetMapping("/api/numeros/{numero}")
    public String getNumeroRomano(@PathVariable int numero) {
        if (numero <= 0) {
            return "Bad request";
        }
        return convertirANumeroRomano(numero);
    }
}
