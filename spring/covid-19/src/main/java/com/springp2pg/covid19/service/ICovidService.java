package com.springp2pg.covid19.service;

import com.springp2pg.covid19.dto.RiskPersonDTO;
import com.springp2pg.covid19.dto.SymptomDTO;
import com.springp2pg.covid19.entity.Symptom;

import java.util.List;

public interface ICovidService {

    List<Symptom> getAllSymptom();
    SymptomDTO findSymptom( String name);
    List<RiskPersonDTO> findRiskPeople();
}
