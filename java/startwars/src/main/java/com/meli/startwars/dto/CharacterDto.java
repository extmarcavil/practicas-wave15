package com.meli.startwars.dto;

import com.meli.startwars.model.CharacterEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CharacterDto {

    private final String name;
    private final int height;
    private final int mass;
    private final String gender;
    private final String homeWorld;
    private final String species;

    public static CharacterDto from(CharacterEntity character) {
        return new CharacterDto(
                character.getName(),
                character.getHeight(),
                character.getMass(),
                character.getGender(),
                character.getHomeWorld(),
                character.getSpecies()
        );
    }
}
