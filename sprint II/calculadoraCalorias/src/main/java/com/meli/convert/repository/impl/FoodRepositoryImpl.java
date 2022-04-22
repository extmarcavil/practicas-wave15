package com.meli.convert.repository.impl;

import com.meli.convert.model.Food;
import com.meli.convert.repository.FoodRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

    List<Food> foods;

    public FoodRepositoryImpl() {

    }

    @Override
    public Food getFodd(String name) {
        return this.foods.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst().get();
    }
}
