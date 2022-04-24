package com.calculadoradecalorias.calculadoradecalorias.controller;

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

    @Autowired
    IIngredientsRepository repository;

    public CalcController(IFoodService service) {
        this.service = service;
    }

    @GetMapping("/calories/{name}/{weight}")
    public ResponseEntity<String> getAllData(@PathVariable String name, @PathVariable double weight ){

        double totalCalories = service.totalCaloriesFood(name,weight);
        List<IngredientDTO> ingredients = service.listIngredients(name);
        IngredientDTO mostCalorieIngredient = service.mostCaolires(name);

        return new ResponseEntity<>("Total calories" + totalCalories
                +" List ingredisntes" + ingredients.toString()
                + " ingrediente con mas calorias" + mostCalorieIngredient
                , HttpStatus.ACCEPTED);
    }

    @GetMapping("/calories")
    public ResponseEntity<List<Ingredient>> getAllIngredientes(){
        return  new ResponseEntity<>(repository.returnDataBase(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/calories/{namee}")
    public ResponseEntity<Ingredient> getoneIngredientes(@PathVariable String namee){
        return  new ResponseEntity<>(repository.findByName(namee).get(),HttpStatus.ACCEPTED);
    }








    }
