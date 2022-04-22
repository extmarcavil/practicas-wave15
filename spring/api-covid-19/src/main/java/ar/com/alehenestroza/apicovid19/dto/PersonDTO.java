package ar.com.alehenestroza.apicovid19.dto;

import ar.com.alehenestroza.apicovid19.models.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private String name;
    private String surname;

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
    }
}
