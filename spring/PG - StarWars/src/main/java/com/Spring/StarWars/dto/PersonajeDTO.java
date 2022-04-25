package com.Spring.StarWars.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter

public class PersonajeDTO {

     private String name;
     private String hair_color;
     private String skin_color;
     private String eye_color;
     private String birth_year;
     private String gender;
     private String homeworld;
     private String species;
     private Integer height;
     private Integer mass;


}
