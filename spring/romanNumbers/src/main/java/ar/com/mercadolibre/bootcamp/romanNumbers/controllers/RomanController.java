package ar.com.mercadolibre.bootcamp.romanNumbers.controllers;

import ar.com.mercadolibre.bootcamp.romanNumbers.services.DecimalToRomanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class RomanController {
    @Autowired
    private DecimalToRomanService decimalToRomanService;

    @GetMapping("/{number}")
    public String convertDecimalToRoman(@PathVariable Integer number) {
        return "Tu numero en romano es: " + this.decimalToRomanService.toRoman(number);
    }
}
