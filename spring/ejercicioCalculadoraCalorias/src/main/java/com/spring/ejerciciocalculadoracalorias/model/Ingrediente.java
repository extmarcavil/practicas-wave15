package com.spring.ejerciciocalculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {
    private String name;
    private Double calories;


    public boolean hasName(String name) {
        return this.getName().equals(name);
    }
}
