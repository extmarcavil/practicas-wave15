package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterFactory {
    public CharacterDTO getLuke(){
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHeight(172);
        luke.setMass(77);
        luke.setHair_color("blond");
        luke.setSkin_color("fair");
        luke.setEye_color("blue");
        luke.setBirth_year("19BBY");
        luke.setGender("male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");
        return luke;
    }

    public CharacterDTO getDarthVader(){
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
        return darthVader;
    }

    public CharacterDTO getDarthMaul(){
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Maul");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
        return darthVader;
    }
}
