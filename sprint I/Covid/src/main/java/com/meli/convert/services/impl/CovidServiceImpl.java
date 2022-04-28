package com.meli.convert.services.impl;

import com.meli.convert.model.Persona;
import com.meli.convert.model.Sintoma;
import com.meli.convert.services.CovidService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CovidServiceImpl implements CovidService {

    private List<Sintoma> sintomaList;

    @Override
    public List<Sintoma> getAllSymptoms() {
        return null;
    }

    @Override
    public Sintoma getSymptom(String name) {
        return null;
    }

    @Override
    public List<Persona> getRiskPersons() {
        return null;
    }
}
