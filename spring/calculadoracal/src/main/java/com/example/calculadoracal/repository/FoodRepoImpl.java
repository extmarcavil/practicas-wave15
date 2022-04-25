package com.example.calculadoracal.repository;

import com.example.calculadoracal.model.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepoImpl implements IFoodRepo{

    List<Food> database;

    IIngredientRepo ingredientsRepo;

    public FoodRepoImpl(IIngredientRepo ingredientRepo) {
        this.ingredientsRepo = ingredientRepo;
        database = new ArrayList<>();
        loadDatabase();
    }

    private void loadDatabase(){
        database.add(new Food("Ensalada", List.of(ingredientsRepo.findByName("Lechuga"), ingredientsRepo.findByName("Pepino"), ingredientsRepo.findByName("Cebolla"))));
        database.add(new Food("Martin Fierro", List.of(ingredientsRepo.findByName("Dulce de membrillo"), ingredientsRepo.findByName("Queso mozzarella"))));

    }

    @Override
    public Optional<Food> findByName(String name) {
        return database.stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst();
    }
}
