package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> findSymptom();
    Symptom findSymptomByName(String name);
}
