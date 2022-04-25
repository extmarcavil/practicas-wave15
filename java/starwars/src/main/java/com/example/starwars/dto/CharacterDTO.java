package com.example.starwars.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CharacterDTO implements Serializable {
  private String name;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

}
