package com.calculadoradecalorias.calculadoradecalorias.controller;

import com.calculadoradecalorias.calculadoradecalorias.dto.FoodDTO;
import com.calculadoradecalorias.calculadoradecalorias.dto.IngredientDTO;
import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import com.calculadoradecalorias.calculadoradecalorias.repository.IIngredientsRepository;
import com.calculadoradecalorias.calculadoradecalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalcController {

    IFoodService service ;

    public CalcController(IFoodService service) {
        this.service = service;
    }

    @GetMapping("/calories/{name}/{weight}")
    public ResponseEntity<FoodDTO> getAllData(@PathVariable String name, @PathVariable double weight ){
        return new ResponseEntity<>(new FoodDTO(service.totalCaloriesFood(name,weight),service.listIngredients(name),service.mostCaolires(name))
                , HttpStatus.ACCEPTED);
    }

    }
