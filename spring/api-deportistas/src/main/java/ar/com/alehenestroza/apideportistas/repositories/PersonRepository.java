package ar.com.alehenestroza.apideportistas.repositories;

import ar.com.alehenestroza.apideportistas.models.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getPersons();
}
