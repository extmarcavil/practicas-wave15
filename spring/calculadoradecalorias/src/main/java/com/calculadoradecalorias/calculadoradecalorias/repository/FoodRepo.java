package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Food;
import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepo implements IFoodRepo {

    IIngredientsRepository repository;
    List<Food> database;

    public FoodRepo(IIngredientsRepository repository) {
        this.repository = repository;
        database = new ArrayList<>();
        loadFood();
    }

    @Override
    public void createFood(String name,double weight,List<Ingredient> listIngredients){
        database.add(new Food(name,weight,listIngredients));
    }

    @Override
    public Optional<Food> findByName(String name){
        return database.stream().filter(f ->f.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<Food> getDatabase(){
        return database;
    }

    private void loadFood() {
        List<Ingredient> ingredientsFood1 = Arrays
                .asList(repository.findByName("Congrio").orElse(null),
                        repository.findByName("Langosta").orElse(null),
                        repository.findByName("Lubina").orElse(null),
                        repository.findByName("Yuca").orElse(null)
                );
        Food food1 = new Food("Plato1",500,ingredientsFood1);
        database.add(food1);

        //--------------------------------------

        List<Ingredient> ingredientsFood2 = Arrays
                .asList(repository.findByName("Endibia").orElse(null),
                        repository.findByName("Espinaca").orElse(null),
                        repository.findByName("Hinojo").orElse(null),
                        repository.findByName("Cebolla").orElse(null)
                );
        Food food2 = new Food("Plato2",1000,ingredientsFood2);
        database.add(food2);
    }


}
