package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class CharacterFactory {

    public static List<CharacterDTO> getList(){
        CharacterDTO vader = new CharacterDTO();
        vader.setName("darth vader");
        vader.setHeight(202);
        vader.setMass(136);
        vader.setHair_color("none");
        vader.setSkin_color("white");
        vader.setEye_color("yellow");
        vader.setBirth_year("41.9BBY");
        vader.setGender("male");
        vader.setHomeworld("tatooine");
        vader.setSpecies("human");

        CharacterDTO maul = new CharacterDTO();
        maul.setName("darth maul");
        maul.setHeight(175);
        maul.setMass(86);
        maul.setHair_color("none");
        maul.setSkin_color("red");
        maul.setEye_color("yellow");
        maul.setBirth_year("54BBY");
        maul.setGender("male");
        maul.setHomeworld("dathomir");
        maul.setSpecies("zabrak");

        List<CharacterDTO> list = List.of(
                vader,
                maul
        );

        return list;
    }
}
