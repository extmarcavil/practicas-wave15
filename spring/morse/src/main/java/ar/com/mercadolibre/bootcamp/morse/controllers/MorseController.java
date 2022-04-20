package ar.com.mercadolibre.bootcamp.morse.controllers;

import ar.com.mercadolibre.bootcamp.morse.services.MorseConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    @Autowired
    private MorseConverterService morseConverterService;

    @GetMapping("/morse2text/{morse}")
    public String morse2text(@PathVariable String morse) {
        return "Tu morse en texto es: " + this.morseConverterService.morse2text(morse);
    }
}
