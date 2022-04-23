package com.bootcamp.Covid19.service;


import com.bootcamp.Covid19.dto.PersonDTO;
import com.bootcamp.Covid19.model.Persona;
import com.bootcamp.Covid19.repository.PersonaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    private PersonaRepo repo;
    private ModelMapper mapper = new ModelMapper();

    public PersonaService(){repo = new PersonaRepo();}

    public List<PersonDTO> get_riskPeopleDTO(){

        return repo.getRiskPeople().stream()
                .map(p -> mapper.map(p, PersonDTO.class))
                .collect(Collectors.toList());
    }

}
