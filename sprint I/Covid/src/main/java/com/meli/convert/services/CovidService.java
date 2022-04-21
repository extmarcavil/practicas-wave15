package com.meli.convert.services;

import com.meli.convert.model.Persona;
import com.meli.convert.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CovidService {

    List<Sintoma> getAllSymptoms();

    Sintoma getSymptom(String name);

    List<Persona> getRiskPersons();
}
