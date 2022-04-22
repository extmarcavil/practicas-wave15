package ar.com.alehenestroza.apideportistas.repositories;

import ar.com.alehenestroza.apideportistas.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private List<Person> persons;

    public PersonRepositoryImpl() {
        this.persons = new ArrayList<>(Arrays.asList(
            new Person("Juan Martin", "Del Potro", "Tenis", 33),
            new Person("Lionel", "Messi", "Football", 34),
            new Person("Sergio", "Martinez", "Boxeo", 47)
        ));
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public List<Person> getPersons() {
        return this.persons;
    }
}
