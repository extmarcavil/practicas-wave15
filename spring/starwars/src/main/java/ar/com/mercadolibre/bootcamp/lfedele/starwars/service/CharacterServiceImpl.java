package ar.com.mercadolibre.bootcamp.lfedele.starwars.service;

import ar.com.mercadolibre.bootcamp.lfedele.starwars.dto.CharacterDTO;
import ar.com.mercadolibre.bootcamp.lfedele.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService{
    private CharacterRepository repo;

    public CharacterServiceImpl(CharacterRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        return this.repo
                .findAll()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
