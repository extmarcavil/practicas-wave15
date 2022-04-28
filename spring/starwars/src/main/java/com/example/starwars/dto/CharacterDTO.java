package com.example.starwars.dto;

<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
>>>>>>> 9ae5e9bcf1fd9d821e8b0d1780ce881ce0f5689c
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
<<<<<<< HEAD
public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
=======
@AllArgsConstructor
public class CharacterDTO {
  private String name;
>>>>>>> 9ae5e9bcf1fd9d821e8b0d1780ce881ce0f5689c
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

}
