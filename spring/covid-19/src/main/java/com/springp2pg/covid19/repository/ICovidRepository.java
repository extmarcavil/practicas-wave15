package com.springp2pg.covid19.repository;

import com.springp2pg.covid19.entity.Person;
import com.springp2pg.covid19.entity.Symptom;

import java.util.List;

public interface ICovidRepository {

    List<Symptom> getAllSymptoms();

    Symptom findSymptom(String name);

    List<Person> findRiskPerson();
}
