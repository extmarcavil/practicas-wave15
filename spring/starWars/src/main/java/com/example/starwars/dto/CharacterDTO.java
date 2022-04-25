package com.example.starwars.dto;

import com.example.starwars.model.Character;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CharacterDTO {
  private String name;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;
  
  public CharacterDTO(Character character){
    this.name = character.getName();
    this.gender = character.getGender();
    this.homeworld = character.getHomeworld();
    this.species = character.getSpecies();
    this.height = character.getHeight();
    this.mass = character.getMass();
  }

}
