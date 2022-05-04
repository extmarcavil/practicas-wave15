package com.spring.ejerciciocalculadoracalorias.repository;

import com.spring.ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.spring.ejerciciocalculadoracalorias.model.Food;
import com.spring.ejerciciocalculadoracalorias.model.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    //List<Ingrediente> getAllFoods();
    Optional<Ingrediente> getIngredientByName(String name);
}
