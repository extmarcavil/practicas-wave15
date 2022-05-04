package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharacterDTO {
  private String name;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

}
