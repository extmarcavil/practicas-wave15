package ar.com.alehenestroza.apideportistas.controllers;

import ar.com.alehenestroza.apideportistas.dto.PersonDTO;
import ar.com.alehenestroza.apideportistas.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonsController {
    private final PersonService personService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons() {
        return new ResponseEntity<>(this.personService.findSportsPersons(), HttpStatus.OK) ;
    }
}
