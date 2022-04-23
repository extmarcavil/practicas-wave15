package ar.com.alehenestroza.apistarwars.services;

import ar.com.alehenestroza.apistarwars.dto.CharacterDTO;
import ar.com.alehenestroza.apistarwars.repositories.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getCharactersThatContainName(String name) {
        return this.characterRepository.getAll().stream()
                .filter(character -> character.getName().contains(name))
                .map(CharacterDTO::new)
                .collect(java.util.stream.Collectors.toList());
    }
}
