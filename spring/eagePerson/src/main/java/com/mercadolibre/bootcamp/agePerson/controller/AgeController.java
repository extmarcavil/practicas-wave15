package com.mercadolibre.bootcamp.agePerson.controller;

import com.mercadolibre.bootcamp.agePerson.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {

    @Autowired
    private IAgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        int age = ageService.getAge(day, month, year);
        return age;
    }
}
