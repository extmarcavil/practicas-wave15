package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.repository.IStarWarsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {
    IStarWarsRepository rep;

    public StarWarsService(IStarWarsRepository rep) {
        this.rep = rep;
    }

    @Override
    public List<PersonajeDTO> getCharacterByName(String name){
        return rep.getCharacterByName(name);
    }
}
