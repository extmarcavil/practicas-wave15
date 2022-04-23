package com.bootcamp.Covid19.repository;

import com.bootcamp.Covid19.dto.SymptomDTO;
import com.bootcamp.Covid19.model.Persona;
import com.bootcamp.Covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepo implements ISymptomRepo{

    private final List<Symptom> sintomas;

    public SymptomRepo() {
        sintomas = new ArrayList<>();
        initData();
    }

    @Override
    public List<Symptom> get_symptoms() {
        return sintomas;
    }

    @Override
    public Optional<Symptom> get_symptomName(String name) {
        return sintomas.stream()
                .filter(s -> s.getName()
                        .equals(name))
                .findFirst();
    }


    private void initData () {
        Symptom headache   = new Symptom(1, "headache", "Low");
        Symptom queasiness = new Symptom(2, "queasiness", "Low");
        Symptom dizziness  = new Symptom(3, "dizziness", "Low");
        Symptom fatigue    = new Symptom(4, "fatigue", "Low");
        Symptom musclePain = new Symptom(5, "musclePain", "Low");

        this.sintomas.addAll(Arrays.asList(headache, queasiness, dizziness, fatigue, musclePain));
    }
}
