package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    //Inyeccion de dependencias
    CharacterRepository repository;

    PersonajeService(CharacterRepository repository){
        this.repository=repository;
    }

    //No se que debe devolver esta function...
    public CharacterDTO getPersonajeData(String name){
        return repository.getCharacterInfo(name);
    }
}
