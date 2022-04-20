package com.meli.morse.controller;

import com.meli.morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MorseController {

    private final MorseService morseService;

    @Autowired
    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping("decode/{code}")
    public String decodeMorse(@PathVariable String code) {
        return morseService.decode(code);
    }

}
