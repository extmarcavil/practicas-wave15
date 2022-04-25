package com.example.calculadoracal.service;

import com.example.calculadoracal.dto.DishCaloriesDTO;
import com.example.calculadoracal.dto.DishDTO;
import com.example.calculadoracal.dto.IngredientDTO;
import com.example.calculadoracal.model.Food;
import com.example.calculadoracal.repository.IFoodRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements IFoodService {

    private IFoodRepo foodRepo;
    ModelMapper mapper;

    public FoodServiceImpl(IFoodRepo foodRepo) {
        this.foodRepo = foodRepo;
        this.mapper = new ModelMapper();
    }

    @Override
    public DishCaloriesDTO findDishCalories(DishDTO dishDTO) {
        Optional<Food> food = foodRepo.findByName(dishDTO.getName());
        System.out.println("Food");
        System.out.println(food.toString());

        DishCaloriesDTO dishCaloriesDTO = mapper.map(food, DishCaloriesDTO.class);

        // Se asume que las calorias indicadas en food.json son por cada 100g
        // y que cuando recibo el peso de un plato, el peso se divide proporcionalmente entre la cantidad de ingredientes de ese plato
        Double weight = dishDTO.getWeight()/ dishCaloriesDTO.getIngredients().size();

        // Cantidad de calorias segun el peso indicado del plato
        dishCaloriesDTO.getIngredients()
               .forEach(i -> i.setCalories( weight * i.getCalories() /100D));

        // Suma de calorias
       dishCaloriesDTO.setCalories(dishCaloriesDTO.getIngredients().stream()
               .mapToDouble(IngredientDTO::getCalories)
               .sum());

       // Ingrediente con mas calorias
       dishCaloriesDTO.setMostCaloriesIngredient(dishCaloriesDTO.getIngredients().stream()
               .max(Comparator.comparing(IngredientDTO::getCalories))
               .orElse(null));

        return dishCaloriesDTO;
    }

    @Override
    public List<DishCaloriesDTO> findCaloriesByDish(List<DishDTO> dishDTOS) {
        List<DishCaloriesDTO> dishCaloriesDTOS = new ArrayList<>();
         for( DishDTO dish: dishDTOS) {
             dishCaloriesDTOS.add(this.findDishCalories(dish));
         }

       return dishCaloriesDTOS;
    }
}
