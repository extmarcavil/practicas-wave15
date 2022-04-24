package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {
    @Autowired
    ICharacterRepository repository;

    @Override
    public List<CharacterDTO> findAllByNameContains ( String query ) {
        return repository.findAllByNameContains(query);
    }


}
