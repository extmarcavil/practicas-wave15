package com.Spring.StarWars.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeFiltradoDTO {

     private String name;
     private String gender;
     private String homeworld;
     private String species;
     private Integer height;
     private Integer mass;

    public PersonajeFiltradoDTO(String name, String gender, String homeworld, String species, Integer height, Integer mass) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }
}
