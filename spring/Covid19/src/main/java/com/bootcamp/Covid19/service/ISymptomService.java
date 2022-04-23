package com.bootcamp.Covid19.service;

import com.bootcamp.Covid19.dto.SymptomDTO;

import java.util.List;

public interface ISymptomService {

    List<SymptomDTO> get_symptomsDTO();
    SymptomDTO get_symptomByNameDTO(String name);
}
