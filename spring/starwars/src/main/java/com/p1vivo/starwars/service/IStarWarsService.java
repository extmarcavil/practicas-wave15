package com.p1vivo.starwars.service;

import com.p1vivo.starwars.dto.CharacterDTO;
import com.p1vivo.starwars.entity.Character;

import java.util.List;

public interface IStarWarsService {

    List<CharacterDTO> findAllByNameContains(String query);
}
