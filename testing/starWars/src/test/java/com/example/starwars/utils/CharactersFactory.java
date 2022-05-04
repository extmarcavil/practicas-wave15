package com.example.starwars.utils;

import com.example.starwars.model.Character;
import com.example.starwars.dto.CharacterDTO;

import java.util.Arrays;
import java.util.List;

public class CharactersFactory {

    public static Character darthVader() {
        return new Character(
                "Darth Vader",
                "none",
                "white",
                "yellow",
                "41.9BBY",
                "male",
                "Tatooine",
                "Human",
                202,
                136);
    }

    public static Character darthMaul() {
        return new Character(
                "Darth Maul",
                "none",
                "red",
                "yellow",
                "54BBY",
                "male",
                "Dathomir",
                "Zabrak",
                175,
                80);
    }

    public static CharacterDTO darthVaderDTO() {
        return new CharacterDTO(
                "Darth Vader",
                "male",
                "Tatooine",
                "Human",
                202,
                136);
    }

    public static CharacterDTO darthMaulDTO() {
        return new CharacterDTO(
                "Darth Maul",
                "male",
                "Dathomir",
                "Zabrak",
                175,
                80);
    }

    public static List<Character> getListCharacters(){
        return Arrays.asList(darthVader(), darthMaul());
    }

    public static List<CharacterDTO> getListCharactersDTO(){
        return Arrays.asList(darthVaderDTO(), darthMaulDTO());
    }
}
