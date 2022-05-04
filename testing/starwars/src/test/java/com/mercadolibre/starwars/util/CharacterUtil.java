package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class CharacterUtil {
    static public List<CharacterDTO> getListDart(){
        List<CharacterDTO> list = new ArrayList<>();
        CharacterDTO dart1 = new CharacterDTO();
        dart1.setName("Darth Maul");
        dart1.setBirth_year("54BBY");
        dart1.setEye_color("yellow");
        dart1.setHeight(175);
        dart1.setMass(80);
        dart1.setSkin_color("red");
        dart1.setHair_color("none");
        dart1.setGender("male");
        dart1.setHomeworld("Dathomir");
        dart1.setSpecies("Zabrak");

        CharacterDTO dart2 = new CharacterDTO();
        dart2.setName("Darth Vader");
        dart2.setBirth_year("41.9BBY");
        dart2.setEye_color("yellow");
        dart2.setHeight(202);
        dart2.setMass(136);
        dart2.setSkin_color("white");
        dart2.setHair_color("none");
        dart2.setGender("male");
        dart2.setHomeworld("Tatooine");
        dart2.setSpecies("Human");

        return List.of(dart1, dart2);
    }
}
