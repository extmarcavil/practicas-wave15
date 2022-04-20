package com.example.deportistas.models;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Person> persons = new ArrayList();
    private List<Sport> sports = new ArrayList();

    public Repository() {
        // Inicialización de personas y deportes.
        Sport s1 = new Sport("Natación", "Alto");
        Sport s2 = new Sport("Natación", "Bajo");
        Sport s3 = new Sport("Futbol", "Medio");
        Sport s4 = new Sport("Básquet", "Bajo");
        sports.add(s1);
        sports.add(s2);
        sports.add(s3);
        sports.add(s4);

        Person p1 = new Person("Wendy", "Sclerandi", 27, s1);
        Person p2 = new Person("Alejandro", "Barsotti", 27, s3);
        persons.add(p1);
        persons.add(p2);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Sport> getSports() {
        return sports;
    }
}
