package ar.com.alehenestroza.apistarwars.dto;

import ar.com.alehenestroza.apistarwars.models.Character;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private String  name;
    private String  birthYear;
    private String  gender;
    private String  homeWorld;
    private String  species;
    private int     height;
    private int     mass;

    public CharacterDTO(Character character) {
        this.name       = character.getName();
        this.birthYear  = character.getBirth_year();
        this.gender     = character.getGender();
        this.homeWorld  = character.getHomeworld();
        this.species    = character.getSpecies();
        this.height     = character.getHeight();
        this.mass       = character.getMass();
    }
}
