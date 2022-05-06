package com.bootcamp.covid.repository;

import com.bootcamp.covid.dto.PersonaDto;
import com.bootcamp.covid.dto.SintomaDto;

import java.util.List;
import java.util.Optional;

public interface ISintomaRepository {

    /**
     * Metodos
     * @return
     */
    List<SintomaDto> getAllSymptoms ();

    Optional<SintomaDto> getSymptomByName (String name );

    List<PersonaDto> getRiskpeople();
}
