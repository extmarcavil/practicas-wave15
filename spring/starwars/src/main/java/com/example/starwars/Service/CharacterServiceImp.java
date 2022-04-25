package com.example.starwars.Service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.ResponseCharacterDTO;
import com.example.starwars.repositories.CharacterRepository;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImp implements ICharacterService{
    final
    CharacterRepository characters;

    public CharacterServiceImp(CharacterRepository characters) {
        this.characters = characters;
    }


    @Override
    public List<CharacterDTO> findchar(String name) {
        List<CharacterDTO> founds = characters.findAllByNameContains(name);
//        Aca deberia pasar los charactersDTOs a ResponseCharacterDTO pero lo voy a hacer cuando sepa usar mapper
        return founds;
    }
}
