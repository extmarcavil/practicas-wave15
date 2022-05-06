package com.example.starwars.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CharacterDTO {

    /**
     * Atributos Dto
     */
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

}
