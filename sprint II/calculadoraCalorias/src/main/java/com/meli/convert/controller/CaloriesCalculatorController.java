package com.meli.convert.controller;

import com.meli.convert.dto.MeatInfoRsDTO;
import com.meli.convert.services.CaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calories-calculator")
public class CaloriesCalculatorController {

    @Autowired
    private CaloriesCalculatorService caloriesCalculatorService;

    @GetMapping("/meat-info/{name}/{numberGrams}")
    public ResponseEntity<MeatInfoRsDTO> getMeatInfo(@PathVariable String name, @PathVariable Double numberGrams) {
        return new ResponseEntity<>(this.caloriesCalculatorService.getMeatInfo(name, numberGrams), HttpStatus.OK);
    }
}
