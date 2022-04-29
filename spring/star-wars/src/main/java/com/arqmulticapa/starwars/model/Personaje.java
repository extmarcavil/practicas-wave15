package com.arqmulticapa.starwars.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

}
