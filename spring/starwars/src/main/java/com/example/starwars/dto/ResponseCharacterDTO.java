package com.example.starwars.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCharacterDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

}