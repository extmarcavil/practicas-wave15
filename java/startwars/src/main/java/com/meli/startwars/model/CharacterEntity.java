package com.meli.startwars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CharacterEntity {

    private final String name;
    private final int height;
    private final int mass;
    private final String hairColor;
    private final String skinColor;
    private final String eyeColor;
    private final String birthYear;
    private final String gender;
    private final String homeWorld;
    private final String species;

}
