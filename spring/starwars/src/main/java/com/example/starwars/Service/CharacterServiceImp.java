package com.example.starwars.Service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.ResponseCharacterDTO;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImp implements ICharacterService{

    CharacterRepositoryImpl characters;

    public CharacterServiceImp(CharacterRepositoryImpl characters) {
        this.characters = characters;
    }

    @Override
    public List<CharacterDTO> findchar(String name) {
        List<CharacterDTO> founds = characters.findAllByNameContains(name);
//        Aca deberia pasar los charactersDTOs a ResponseCharacterDTO pero lo voy a hacer cuando sepa usar mapper
        return founds;
    }
}
