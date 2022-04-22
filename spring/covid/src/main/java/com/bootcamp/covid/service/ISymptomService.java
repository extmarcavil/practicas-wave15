package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PatientDTO;
import com.bootcamp.covid.dto.SymptomDTO;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTO> getSymptoms ();
    SymptomDTO getSymptomDTO ( String name );
    List<PatientDTO> getPatients ();
}
