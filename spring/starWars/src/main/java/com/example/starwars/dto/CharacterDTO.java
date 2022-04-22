package com.example.starwars.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

    public CharacterDTO(String name, String gender, String homeworld, String species, Integer height, Integer mass) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }
}
