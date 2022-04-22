package com.meli.convert.repository.impl;

import com.meli.convert.model.Ingredient;
import com.meli.convert.repository.IngredientRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private List<Ingredient> ingredients;

    public IngredientRepositoryImpl() {
        this.ingredients = new ArrayList<>();

        try {
            Reader reader = new InputStreamReader(new FileInputStream("food.json"));
            JSONParser parser = new JSONParser(reader);
            // ArrayList<Object> list = parser.parseArray();
            // System.out.println(list.toString());

            parser.parseArray().stream().forEach(ing -> this.ingredients.add((Ingredient) ing));

        } catch (Exception e) {

        }
    }

    @Override
    public Ingredient getIngredient(String name) {
        return null;
    }
}
