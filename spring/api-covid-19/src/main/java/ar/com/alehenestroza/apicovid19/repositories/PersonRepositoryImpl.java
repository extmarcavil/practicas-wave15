package ar.com.alehenestroza.apicovid19.repositories;

import ar.com.alehenestroza.apicovid19.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private List<Person> persons;

    public PersonRepositoryImpl() {
        this.persons = new ArrayList<>(Arrays.asList(
                new Person(1, "Homero", "Simpson", 45),
                new Person(2, "Abraham", "Simpson", 75),
                new Person(3, "Montgomery", "Burns", 111)
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
