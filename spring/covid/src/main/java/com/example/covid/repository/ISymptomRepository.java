package com.example.covid.repository;

import com.example.covid.dto.SymptomDTO;
import com.example.covid.models.Person;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {

    List<SymptomDTO> getAllSymptoms();

    Optional<SymptomDTO> getSymptomByName(String name);

    List<Person> getRiskPersons();
}
