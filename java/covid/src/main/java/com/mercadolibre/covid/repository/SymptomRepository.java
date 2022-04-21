package com.mercadolibre.covid.repository;

import com.mercadolibre.covid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SymptomRepository {

    public List<Symptom> findAll() {
        return List.of(
                new Symptom("012A", "Cough", 0),
                new Symptom("015B", "Temperature", 3),
                new Symptom("123A", "Eye Pain", 2),
                new Symptom("0B32", "Tiredness", 4),
                new Symptom("B122", "Headache", 5)
        );
    }

    public List<Symptom> findWithLimit(int limit) {
        return findAll().stream().limit(limit).collect(Collectors.toList());
    }

}
