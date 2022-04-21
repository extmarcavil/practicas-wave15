package ar.com.mercadolibre.bootcamp.lfedele.starwars.controller;

import ar.com.mercadolibre.bootcamp.lfedele.starwars.dto.CharacterDTO;
import ar.com.mercadolibre.bootcamp.lfedele.starwars.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> findAllByNameContains(@PathVariable String name) {
        return new ResponseEntity<>(this.service.findAllByNameContains(name), HttpStatus.OK);
    }
}
