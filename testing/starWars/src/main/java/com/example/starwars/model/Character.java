package com.example.starwars.model;

import com.example.starwars.exception.BadQueryException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {
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

    public boolean containsQuery(String query){
        // Ver si contiene la query en el nombre,
        if (query == null) {
            throw new BadQueryException("La query no puede ser nula");
        }
        return this.name.toLowerCase().contains(query.toLowerCase());
    }
}
