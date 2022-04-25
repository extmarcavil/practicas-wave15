package com.bootcamp.deportes.repository;

import com.bootcamp.deportes.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public static List<Person> listPerson = new ArrayList<>();

    static {
        List<Person> listSport = new ArrayList<>();
        listPerson.add(new Person("Martin","Torres",18));
        listPerson.add(new Person("Marcelo","Rios",20));
        listPerson.add(new Person("Enrrique","Salinas",27));


    }

}
