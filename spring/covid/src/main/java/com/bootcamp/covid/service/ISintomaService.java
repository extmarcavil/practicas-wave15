package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PacienteDto;
import com.bootcamp.covid.dto.SintomaDto;

import java.util.List;

public interface ISintomaService {

    /**
     * Metodos
     * @return
     */
    List<SintomaDto> getSymptoms ();

    SintomaDto getSymptomDTO (String name );

    List<PacienteDto> getPatients ();
}
