package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.response.CharacterResponseDTO;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import com.example.starwars.repositories.ICharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarPersonajeServiceImpl implements IBuscarPersonajeService{

    private ICharacterRepository characterRepository;
    public BuscarPersonajeServiceImpl(ICharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public ResponseEntity<CharacterResponseDTO> findByName(String name) {
        CharacterDTO characterDTO=characterRepository.findByName(name);
        CharacterResponseDTO characterResponseDTO =
                new CharacterResponseDTO(
                        characterDTO.getName(),
                        characterDTO.getGender(),
                        characterDTO.getHomeworld(),
                        characterDTO.getSpecies(),
                        characterDTO.getHeight(),
                        characterDTO.getMass()
                );

        return new ResponseEntity<>(characterResponseDTO, HttpStatus.OK);
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
