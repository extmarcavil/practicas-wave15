package com.bootcamp.covid.repository;

import com.bootcamp.covid.dto.PersonDTO;
import com.bootcamp.covid.dto.SymptomDTO;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {
    List<SymptomDTO> getAllSymptoms ();
    Optional<SymptomDTO> getSymptomByName ( String name );
    List<PersonDTO> getPeople ();
}
