package com.example.ejerciciorestaurante.controller;

import com.example.ejerciciorestaurante.model.Recipe;
import com.example.ejerciciorestaurante.service.IKitchenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final IKitchenService kitchenService;


    public MenuController(IKitchenService service) {
        this.kitchenService = service;
    }

    @GetMapping
    public List<Recipe> listDish() {
        return kitchenService.getDishes();
    }

    @PostMapping("/dish")
    public Recipe createDish(@RequestParam String name) {
        return kitchenService.createDish(name);
    }
}
