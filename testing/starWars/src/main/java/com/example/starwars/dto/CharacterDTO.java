package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}
