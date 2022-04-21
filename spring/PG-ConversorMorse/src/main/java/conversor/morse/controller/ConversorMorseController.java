package conversor.morse.controller;

import conversor.morse.utils.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/convert")
public class ConversorMorseController {


    @GetMapping("/{morseCodePhrase}")
    public String getMorseCode(@PathVariable String morseCodePhrase){

        Morse nuevaPalabraEnMorse = new Morse(morseCodePhrase);

        return nuevaPalabraEnMorse.translate();
    }
}
