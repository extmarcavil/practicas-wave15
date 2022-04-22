package ar.com.alehenestroza.apideportistas.dto;

import ar.com.alehenestroza.apideportistas.models.Person;
import ar.com.alehenestroza.apideportistas.models.Sport;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonDTO implements Serializable {
    private String name;
    private String surname;
    private String sportName;

    public PersonDTO(Person person, Sport sport) {
        this.name       = person.getName();
        this.surname    = person.getSurname();
        this.sportName  = sport.getName();
    }
}
