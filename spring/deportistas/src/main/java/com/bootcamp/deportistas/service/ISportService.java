package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonDTO;
import com.bootcamp.deportistas.dto.SportDTO;

import java.util.List;

public interface ISportService {

    List<SportDTO> getSports();
    SportDTO getSport(String name);
    List<PersonDTO> getPeople();

}
