package com.mercadolibre.bootcamp_api_deportistas.service;

import com.mercadolibre.bootcamp_api_deportistas.dtos.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findSportsPersons();
}
