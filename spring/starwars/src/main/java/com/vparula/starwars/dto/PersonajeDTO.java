package com.vparula.starwars.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {
    String name;
    Integer height;
    Integer mass;
    String gender;
    String homeworld;
    String species;

    public PersonajeDTO() {
    }


}
