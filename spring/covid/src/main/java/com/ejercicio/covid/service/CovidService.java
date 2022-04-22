package com.ejercicio.covid.service;

import com.ejercicio.covid.dtos.PersonaDTO;
import com.ejercicio.covid.dtos.SintomaDTO;
import com.ejercicio.covid.models.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CovidService {

    List<SintomaDTO> findSymptom();

    String findSymptomByName(String nombre);

    List<PersonaDTO> findRiskPerson();
}
