package ar.com.mercadolibre.bootcamp.lfedele.deportes.controller;

import ar.com.mercadolibre.bootcamp.lfedele.deportes.dto.PersonaDto;
import ar.com.mercadolibre.bootcamp.lfedele.deportes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSportsPersons() {
        return new ResponseEntity<>(
                this.personaService.findSportsPersons()
                    .stream()
                    .map(PersonaDto::new)
                    .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
