package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {

    private static List<Person> persons;
    static {
        persons = new ArrayList<Person>();
        persons.add(new Person(1, "Julio", "Ferreira", 65));
        persons.add(new Person(2, "Milagros", "Carranza", 23));
        persons.add(new Person(3, "Sandra", "Sanchez", 70));
    }

    public PersonRepository() {
    }

    public List<Person> getPersonsList() {
        return persons;
    }
}
