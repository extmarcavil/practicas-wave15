package com.mercadolibre.bootcamp_api_deportistas.repository;

import com.mercadolibre.bootcamp_api_deportistas.entity.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getPersons();
}
