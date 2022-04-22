package sport.exercise.model;

import sport.exercise.dto.MappeableToDTO;
import sport.exercise.dto.PersonDTO;

public class Person implements MappeableToDTO<PersonDTO> {

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public void mapToDTO(PersonDTO aDTO) {
        aDTO.setName(name);
        aDTO.setSurname(surname);
        aDTO.setAge(age);
    }
}
