package ar.com.mercadolibre.bootcamp.lfedele.starwars.repository;


import ar.com.mercadolibre.bootcamp.lfedele.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAll();
}
