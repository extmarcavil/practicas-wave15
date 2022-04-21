package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Person;
import com.bootcamp.covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    static List<Person> listPerson;
    static {
        List<Symptom> listSymptom = new ArrayList<>();
        listSymptom.add(new Symptom("0101","Bradicardia",3));
        listPerson = new ArrayList<>();
        listPerson.add(new Person("1","Silvia","Torres",22,new ArrayList<>()));
        listPerson.add(new Person("2","Sofia","Cruz",65,new ArrayList<>()));
        listPerson.add(new Person("3","David","Linares",62,listSymptom));

    }

    public List<Person> findRiskPerson(){
        return listPerson.stream()
                .filter(person -> person.getAge()>60 && person.getListSymptom().size()>0)
                .collect(Collectors.toList());
    }

}
