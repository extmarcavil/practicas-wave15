package com.example.ages.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcAgeController {
    @GetMapping("/calc")
 public String calcAge(@RequestParam int day,@RequestParam int month, @RequestParam int year ){

     return ("Fecha de Nacimiento: " + day + "/"  + month + "/"  + year );
 }
}
