package com.bootcamp.Covid19.repository;

import com.bootcamp.Covid19.model.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepo {

    List<Symptom> get_symptoms();
    Optional<Symptom> get_symptomName(String name);

}
