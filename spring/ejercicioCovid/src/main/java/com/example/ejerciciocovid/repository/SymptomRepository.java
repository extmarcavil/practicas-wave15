package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository implements ISymptomRepository {

    private static List<Symptom> symptoms;
    static {
        symptoms = new ArrayList<Symptom>();
        symptoms.add(new Symptom(1, "Golpe en el pie", "Bajo"));
        symptoms.add(new Symptom(2, "Dolor de muela", "Medio"));
        symptoms.add(new Symptom(3, "Covid", "Alto"));
    }

    public SymptomRepository() {
    }

    @Override
    public List<Symptom> getSymptomsList() {
        return symptoms;
    }

    public Optional<Symptom> getSymptomByName(String name) {
        Optional<Symptom> symptom = symptoms.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();

        return symptom;
    }
}
