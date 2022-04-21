package com.example.covid.repository;

import com.example.covid.model.Person;
import com.example.covid.model.Sintoma;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonRepository {
    private HashMap<Person, ArrayList<String>> persons = new HashMap<>();

    public PersonRepository(){
        Person p1 = new Person("0","Rodrigo","Gomez",28);
        Person p2 = new Person("1","Alan","Brito",68);
        Person p3 = new Person("2","Armando","Paredes",91);

        ArrayList<String> sintomas = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        sintomas.add("0");
        persons.put(p1,sintomas);
        persons.put(p2,sintomas);
        s2.add("1");
        s2.add("2");
        persons.put(p3,s2);
    }

    public HashMap<Person, ArrayList<String>> getPersons() {
        return persons;
    }
}
