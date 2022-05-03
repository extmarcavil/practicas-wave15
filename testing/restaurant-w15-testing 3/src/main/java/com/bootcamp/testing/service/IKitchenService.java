package com.bootcamp.testing.service;

import com.bootcamp.testing.model.Recipe;

import java.util.List;

public interface IKitchenService {

    List<Recipe> getDishes();

    Recipe createDish(String name);
}
