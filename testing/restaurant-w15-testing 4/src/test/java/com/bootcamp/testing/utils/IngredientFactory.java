package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Ingredient;

public class IngredientFactory {

    public static Ingredient getTomaco(){
        Ingredient tomato = new Ingredient();
        tomato.setName("tomato");
        tomato.setQuantity(3);
        return tomato;
    }

    public static Ingredient getBread(){
        Ingredient bread = new Ingredient();
        bread.setName("bread");
        bread.setQuantity(1);
        return bread;
    }

    public static Ingredient getTomacoMock(){
        Ingredient tomato = new Ingredient();
        tomato.setName("tomato");
        tomato.setQuantity(3);
        tomato.setQuality(5);
        tomato.setCalories(20);
        return tomato;
    }

    public static Ingredient getBreadMock(){
        Ingredient bread = new Ingredient();
        bread.setName("bread");
        bread.setQuantity(1);
        bread.setQuality(5);
        bread.setCalories(983);
        return bread;
    }
}
