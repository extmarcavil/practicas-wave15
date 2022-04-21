package com.ejerciciointegrador.covid19.repository;

import com.ejerciciointegrador.covid19.model.Person;
import com.ejerciciointegrador.covid19.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Symptom> symptoms;
    private List<Person> people;

    public Repository() {
        symptoms = new ArrayList<>();
        Symptom  headache = new Symptom(0, "headache", "light");
        Symptom fever = new Symptom(1, "fever", "light");
        Symptom bp = new Symptom(2, "body pain", "half");
        Symptom hp = new Symptom(3, "high pressure", "serious");
        symptoms.add(headache);
        symptoms.add(bp);
        symptoms.add(hp);
        symptoms.add(fever);


        people = new ArrayList<>();
        Person p1 = new Person(0L, "Raul", "Velez", 23);
        p1.addSymptom(fever);
        people.add(p1);
        Person p2 = new Person(1L, "Milena", "Muller", 63);
        p2.addSymptom(hp);
        people.add(p2);
        Person p3 = new Person(2L, "Miguel", "Puff", 64);
        p3.addSymptom(fever);
        p3.addSymptom(bp);
        people.add(p3);
        Person p4 = new Person(3L, "Helena", "Corona", 23);
        people.add(p4);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
