package com.bootcamp.testing.exception.notfound;

import lombok.Getter;

@Getter
public class RecipeNotFoundException extends NotFoundException {

    public RecipeNotFoundException(String name) {
        super(name + " recipe could not be found", "Recipe Not Found Exception");
    }
}
