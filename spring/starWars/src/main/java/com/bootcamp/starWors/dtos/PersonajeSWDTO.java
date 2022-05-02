package com.bootcamp.starWors.dtos;

import com.bootcamp.starWors.models.PersonajeSW;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeSWDTO {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeSWDTO() {
    }

    public PersonajeSWDTO(PersonajeSW characterSW) {
        this.name = characterSW.getName();
        this.height = characterSW.getHeight();
        this.mass = characterSW.getMass();
        this.gender = characterSW.getGender();
        this.homeworld = characterSW.getHomeworld();
        this.species = characterSW.getSpecies();
    }

}
