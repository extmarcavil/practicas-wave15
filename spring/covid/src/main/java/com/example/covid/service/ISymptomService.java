package com.example.covid.service;

import com.example.covid.dto.PersonDTO;
import com.example.covid.dto.SymptomDTO;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTO> getSymptons();
    SymptomDTO getSymptomSeverityLevelDTO(String name);
    List<PersonDTO> getRiskPersonsDTO();
}
