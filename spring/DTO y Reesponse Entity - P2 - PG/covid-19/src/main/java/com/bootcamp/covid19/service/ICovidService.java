package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dtos.PatientDTO;
import com.bootcamp.covid19.dtos.SymptomDTO;

import java.util.List;

public interface ICovidService {
    List<SymptomDTO> findSymptom();
    SymptomDTO findSymptomByName(String name);
    List<PatientDTO> findRiskPerson();
}
