package ar.com.mercadolibre.bootcamp.lfedele.starwars.service;

import ar.com.mercadolibre.bootcamp.lfedele.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> findAllByNameContains(String query);
}
