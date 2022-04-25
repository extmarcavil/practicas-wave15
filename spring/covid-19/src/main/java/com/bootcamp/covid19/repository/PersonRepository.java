package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Person;
import com.bootcamp.covid19.dto.SickDTO;
import com.bootcamp.covid19.model.Symptom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository {
    static List<Person> listPerson = new ArrayList<>();
    static {
        List<Symptom> listSymptom = new ArrayList<>();
        listSymptom.add(new Symptom("0101","Bradicardia",3));
        listPerson = new ArrayList<>();
        listPerson.add(new Person("1","Silvia","Torres",22,new ArrayList<>()));
        listPerson.add(new Person("2","Sofia","Cruz",65,new ArrayList<>()));
        listPerson.add(new Person("3","David","Linares",62,listSymptom));

    }

    public List<SickDTO> findRiskPerson(){
        List<SickDTO> listSickDTO = new ArrayList<>();

        List<Person> listPersons = listPerson.stream()
                .filter(person -> person.getAge()>60 && person.getListSymptom().size()>0)
                .collect(Collectors.toList());
        for (Person person : listPersons) {
            List<String> symptoms = new ArrayList<>();
            for(Symptom symptom : person.getListSymptom()){
                symptoms.add(symptom.getName());
            }
            listSickDTO.add(new SickDTO("1", person.getName() +" "+ person.getLastName(), person.getAge(), symptoms));
        }

        return listSickDTO;
    }

}
