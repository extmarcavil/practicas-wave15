package com.bootcamp.testing.exception.notfound;

import lombok.Getter;

@Getter
public class IngredientNotFoundException extends NotFoundException{

    public IngredientNotFoundException(String name) {
        super(name + " could not be found", "Ingredient Not Found Exception");
    }
}
