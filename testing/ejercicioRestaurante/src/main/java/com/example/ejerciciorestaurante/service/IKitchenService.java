package com.example.ejerciciorestaurante.service;

import com.example.ejerciciorestaurante.model.Recipe;

import java.util.List;

public interface IKitchenService {

    List<Recipe> getDishes();

    Recipe createDish(String name);
}
