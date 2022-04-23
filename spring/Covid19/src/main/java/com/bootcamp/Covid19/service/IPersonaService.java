package com.bootcamp.Covid19.service;

import com.bootcamp.Covid19.dto.PersonDTO;

import java.util.List;

public interface IPersonaService {
    List<PersonDTO> get_riskPeopleDTO();
}
