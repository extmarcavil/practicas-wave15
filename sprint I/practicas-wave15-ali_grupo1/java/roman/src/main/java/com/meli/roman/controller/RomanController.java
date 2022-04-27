package com.meli.roman.controller;

import com.meli.roman.service.RomanNumeralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RomanController {

    private final RomanNumeralsService romanNumeralsService;

    @Autowired
    public RomanController(RomanNumeralsService romanNumeralsService) {
        this.romanNumeralsService = romanNumeralsService;
    }

    @GetMapping("convert/{number}")
    public String convert(@PathVariable Integer number) {
        return romanNumeralsService.toRoman(number);
    }

}
