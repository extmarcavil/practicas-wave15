package com.example.starwars.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Component
public class Character {

    /**
     * Atributos
     */
    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}
