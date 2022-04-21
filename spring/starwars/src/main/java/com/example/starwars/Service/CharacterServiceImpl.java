package com.example.starwars.Service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Override
    public List<CharacterDTO> findByname(String name) {
        return characterRepository.findAllByNameContains(name);
    }
}
