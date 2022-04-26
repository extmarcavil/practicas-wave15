package com.example.starwars.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Character {

    @Getter
    @Setter
    private String name, hairColor, skinColor, eyeColor, homeworld, species, gender, birthYear;
    private Integer height, mass;

    public Character(String name, String hairColor, String skinColor, String eyeColor, String homeworld, String species, String gender, Integer height, Integer mass, String birthYear) {
        this.name = name;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.homeworld = homeworld;
        this.species = species;
        this.gender = gender;
        this.height = height;
        this.birthYear = birthYear;
        this.mass = mass;
    }

    public Character(){

    }
}
