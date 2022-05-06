package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.ICharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    /**
     * Injection By Constructor
     */
    private ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Metodos
     */
    @GetMapping()
    public List<CharacterDTO> findAll() {
        return characterService.listar();
    }

    @GetMapping("/query")
    public List<CharacterDTO> findContainAll(@RequestParam("name") String name) {
        return characterService.listarPorNombre(name);
    }
}
