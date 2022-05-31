package com.mercadolibre.bootcamp_api_deportistas.repository;

import com.mercadolibre.bootcamp_api_deportistas.entity.Person;
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

    @Override
    public List<Person> getPersons() {
        return this.persons;
    }
}
