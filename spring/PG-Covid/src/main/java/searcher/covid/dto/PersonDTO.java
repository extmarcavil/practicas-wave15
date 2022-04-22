package searcher.covid.dto;

import lombok.Getter;
import lombok.Setter;
import searcher.covid.model.Person;

@Setter
@Getter
public class PersonDTO {

    private int ID;
    private String name;
    private String surname;
    private int age;

    public PersonDTO(Person eachPerson) {
        eachPerson.mapToDTO(this);
    }
}
