package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {

    List<Symptom> getSymptomsList();
    Optional<Symptom> getSymptomByName(String name);
}
