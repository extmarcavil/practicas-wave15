package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Person;
import com.bootcamp.covid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {
    public static List<Person> listPerson = new ArrayList<>();

    static {
        List<Symptom> listSymptom = new ArrayList<>();
        listPerson.add(new Person(0,"Marcelo","Rios",25, new ArrayList<>()));
        listPerson.add(new Person(1,"Esteban","Salgado",40, listSymptom));
        listPerson.add(new Person(2,"Mauricio","Miraflores",61,listSymptom));
    }
}
