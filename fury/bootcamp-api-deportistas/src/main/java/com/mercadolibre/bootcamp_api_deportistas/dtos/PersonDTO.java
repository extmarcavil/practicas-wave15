package com.mercadolibre.bootcamp_api_deportistas.dtos;

import com.mercadolibre.bootcamp_api_deportistas.entity.Person;
import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {
    private String name;
    private String surname;
    private String sportName;

    public PersonDTO(Person person, Sport sport) {
        this.name       = person.getName();
        this.surname    = person.getSurname();
        this.sportName  = sport.getName();
    }
}
