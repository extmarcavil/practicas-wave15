package com.example.restaurante.controller;

import com.example.restaurante.dto.FoodDTO;
import com.example.restaurante.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @Autowired
    private FoodsService foodsService;

    @GetMapping("/food/{name}/{peso}")
    public ResponseEntity<FoodDTO> getFood(@PathVariable String name, @PathVariable double peso){
        FoodDTO foodDTO = foodsService.getFood(name,peso);

        return new ResponseEntity<>(foodDTO, HttpStatus.OK);
    }
}
