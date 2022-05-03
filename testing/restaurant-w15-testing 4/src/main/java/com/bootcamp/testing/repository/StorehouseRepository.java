package com.bootcamp.testing.repository;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.repository.interfaces.IStorehouseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

@Repository
public class StorehouseRepository implements IStorehouseRepository {

    List<Ingredient> ingredients;

    public StorehouseRepository () {
        this.loadDataBase();
    }

    @Override
    public Optional<Ingredient> getIngredient ( String name ) {
        return ingredients.stream()
          .filter(ingredient -> ingredient.hasSameName(name))
          .min(comparing(Ingredient::getQuality));
    }

    private void loadDataBase () {
        File         file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };

        try {
            file        = ResourceUtils.getFile("classpath:ingredients.json");
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
