package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.SymptomDTO;

import java.util.List;

public interface ISymptomService {

    List<SymptomDTO> getSymptomsList();
    SymptomDTO getSymptomDTO(String name);
}
