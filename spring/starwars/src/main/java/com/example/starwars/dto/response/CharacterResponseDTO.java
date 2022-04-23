package com.example.starwars.dto.response;

import com.example.starwars.dto.CharacterDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterResponseDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

    public CharacterResponseDTO(String name, String gender, String homeworld, String species, Integer height, Integer mass) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public CharacterResponseDTO() {
    }
}
