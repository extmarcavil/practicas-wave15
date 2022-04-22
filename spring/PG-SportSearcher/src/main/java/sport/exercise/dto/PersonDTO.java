package sport.exercise.dto;

import lombok.Getter;
import lombok.Setter;
import sport.exercise.model.Person;

@Setter
@Getter
public class PersonDTO {

    private String name;
    private String surname;
    private int age;

    public PersonDTO(Person eachPerson) {
        eachPerson.mapToDTO(this);
    }
}
