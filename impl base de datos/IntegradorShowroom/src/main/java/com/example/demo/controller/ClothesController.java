package com.example.demo.controller;

import com.example.demo.dto.ClothesDTO;
import com.example.demo.service.IClothesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    IClothesService clothesService;

    public ClothesController(IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveClothes(@RequestBody ClothesDTO clothesDTO)
    {
        return ResponseEntity.ok().body(clothesService.saveClothes(clothesDTO));
    }


}
