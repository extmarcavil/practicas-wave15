package com.example.covid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Repository {
    List<Symptom> symtoms = new ArrayList<>();
    List<Person> persons = new ArrayList<>();

    public Repository() {
        Symptom s1 = new Symptom(1, "Tos", 4);
        Symptom s2 = new Symptom(2, "Fiebre", 5);
        Symptom s3 = new Symptom(3, "Cansancio", 3);
        Symptom s4 = new Symptom(4, "Dolores musculares", 4);
        this.symtoms.add(s1);
        this.symtoms.add(s2);
        this.symtoms.add(s3);
        this.symtoms.add(s4);

        Person p1 = new Person(1, "Wendy", "Sclerandi", 27, Arrays.asList(s1, s2));
        Person p2 = new Person(2, "Alejandro", "Barsotti", 65, Arrays.asList(s2, s4));
        Person p3 = new Person(3, "Rafael", "Perez", 70);
        this.persons.add(p1);
        this.persons.add(p2);
        this.persons.add(p3);
    }
}
