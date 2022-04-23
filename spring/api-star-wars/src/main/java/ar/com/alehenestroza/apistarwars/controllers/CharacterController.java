package ar.com.alehenestroza.apistarwars.controllers;

import ar.com.alehenestroza.apistarwars.dto.CharacterDTO;
import ar.com.alehenestroza.apistarwars.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/{name}")
    public List<CharacterDTO> getCharactersThatContainName(@PathVariable String name) {
        return characterService.getCharactersThatContainName(name);
    }
}
