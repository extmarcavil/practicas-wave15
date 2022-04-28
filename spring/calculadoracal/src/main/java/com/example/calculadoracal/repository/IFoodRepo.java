package com.example.calculadoracal.repository;

import com.example.calculadoracal.model.Food;

import java.util.Optional;

public interface IFoodRepo {
    Optional<Food> findByName(String name);
}
