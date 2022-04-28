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
        database.add(new Food("Burguer", List.of(ingredientsRepo.findByName("Lechuga"), ingredientsRepo.findByName("Pepino"), ingredientsRepo.findByName("Cebolla"))));
        database.add(new Food("Pizza", List.of(ingredientsRepo.findByName("Salsa de tomate en conserva"), ingredientsRepo.findByName("Jamón"), ingredientsRepo.findByName("Queso mozzarella"), ingredientsRepo.findByName("Cebolla"))));
        database.add(new Food("Sardinas", List.of(ingredientsRepo.findByName("Sardinas"))));
    }

    @Override
    public Optional<Food> findByName(String name) {
        return database.stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst();
    }
}
