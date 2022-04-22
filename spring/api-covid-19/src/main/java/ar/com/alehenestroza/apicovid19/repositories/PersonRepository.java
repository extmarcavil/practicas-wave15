package ar.com.alehenestroza.apicovid19.repositories;

import ar.com.alehenestroza.apicovid19.models.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getPersons();
}
