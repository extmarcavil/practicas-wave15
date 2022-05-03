package com.bootcamp.testing.controller;

import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.service.IKitchenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    IKitchenService kitchenService;

    public MenuController ( IKitchenService kitchenService ) {
        this.kitchenService = kitchenService;
    }

    @GetMapping
    public List<Recipe> listDish(){
        return kitchenService.getDishes();
    }

    @PostMapping("/dish")
    public Recipe createDish(@RequestParam String name){
        return kitchenService.createDish(name);
    }

}