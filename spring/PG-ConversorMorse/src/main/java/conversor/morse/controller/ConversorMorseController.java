package conversor.morse.controller;

import conversor.morse.utils.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConversorMorseController {


    @GetMapping("/{morseCodePhrase}")
    public String getMorseCode(@PathVariable String morseCodePhrase){

        Morse nuevaPalabraEnMorse = new Morse(morseCodePhrase);

        return nuevaPalabraEnMorse.convertir();
    }
}
