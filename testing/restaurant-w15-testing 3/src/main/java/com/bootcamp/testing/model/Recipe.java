package com.bootcamp.testing.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private Double quality;
    private Double calories;

    public boolean hasSameName( String name){
        return this.name.equalsIgnoreCase(name);
    }
}