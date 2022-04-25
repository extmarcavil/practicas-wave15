package com.springp2pg.covid19.repository;

import com.springp2pg.covid19.entity.Person;
import com.springp2pg.covid19.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CovidRepositoryImpl implements ICovidRepository{

    private List<Symptom> allSymptoms= new ArrayList<>();
    private List<Person> peopleList = new ArrayList<>();

    public CovidRepositoryImpl() {
        this.allSymptoms = setSymptom();
        this.peopleList = setPeople();
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return allSymptoms;
    }

    @Override
    public Symptom findSymptom(String name) {
        Symptom symptom = allSymptoms.stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .orElse(null);
        return symptom;
    }

    @Override
    public List<Person> findRiskPerson() {
        List<Person> riskP = peopleList.stream()
                .filter( p -> p.getAge() > 60 && p.getSymptoms().size()>0)
                .collect(Collectors.toList());
        return riskP;
    }

    private List<Symptom> setSymptom(){
        List<Symptom> symptomList = new LinkedList<>();
        symptomList.add(new Symptom(1,"Fiebre","Alto"));
        symptomList.add(new Symptom(2,"Tos","Alto"));
        symptomList.add(new Symptom(3,"Cansancio","Medio"));
        symptomList.add(new Symptom(4,"Falta de aire","Alto"));
        symptomList.add(new Symptom(5,"Dolor muscular","Bajo"));

        return symptomList;
    }

    private List<Person> setPeople(){
        Person p1 = new Person(1L,"Maria", "Perez",75, Arrays.asList(allSymptoms.get(0),allSymptoms.get(4)));

        Person p2 = new Person(2L,"Pablo", "Piperno",35, Arrays.asList(allSymptoms.get(2)));

        Person p3 = new Person(3L,"Sabrina", "Cabrera",30, Arrays.asList(allSymptoms.get(3)));

        Person p4 = new Person(4L,"Julio", "Paz",61,new ArrayList<>());

        peopleList.addAll(Arrays.asList(p1, p2, p3, p4));

        return peopleList;
    }


}
