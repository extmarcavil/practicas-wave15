package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Person;
import com.bootcamp.deportistas.model.Sport;

import java.util.List;
import java.util.Optional;

public interface ISportRepository {

    List<Sport> getAllSports();
    Optional<Sport> getSportByName(String name);
    List<Person> getPeople();

}
