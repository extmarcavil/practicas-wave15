package com.meli.covid.controller;

import com.meli.covid.model.Person;
import com.meli.covid.model.Symptom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class findRiskPerson {
    @GetMapping ("/findRiskPerson")
    public List<Person> listPersonsSymptom () {
        List<Person> listPerson = riskPerson();
        List<Person> listFiltered = listPerson.stream()
                .filter (person -> person.getPersonalSymptoms().size() > 0)
                .filter (person -> person.getAge().doubleValue() > 65)
                .collect(Collectors.toList());
        if (listFiltered.size() == 0) return null;
        return listFiltered;
    }




    public List<Person> riskPerson () {
        Symptom sympton1 = new Symptom(01, "Fiebre", "Leve");
        Symptom sympton2 = new Symptom(02, "Respiracion dificultosa", "Medio");
        Symptom sympton3 = new Symptom(03, "Fiebre alta persistente", "Grave");
        List<Symptom> listSymptom1 = Arrays.asList(sympton1);
        List<Symptom> listSymptom2 = new ArrayList<Symptom>();
        List<Symptom> listSymptom3 = Arrays.asList(sympton2, sympton3);
        List<Person> listPerson = new ArrayList<Person>();
        Person person1 = new Person(1, "Lucio", "Gonzales", 45, listSymptom1);
        Person person2 = new Person(2, "Maria", "Montevilla", 69, listSymptom3);
        Person person3 = new Person(3, "Gladis", "Filis", 98, listSymptom2);
        Person person4 = new Person(4, "Mario", "Caceres", 70, listSymptom1);
        Person person5 = new Person(5, "Lucia", "Castellano", 33, listSymptom2);
        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);
        listPerson.add(person5);
        return listPerson;
    }
}
