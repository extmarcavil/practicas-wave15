package ar.com.alehenestroza.apicovid19.controllers;

import ar.com.alehenestroza.apicovid19.dto.PersonDTO;
import ar.com.alehenestroza.apicovid19.services.PersonService;
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

    @GetMapping("/findRiskPersons")
    public ResponseEntity<List<PersonDTO>> findRiskPersons() {
        return new ResponseEntity<>(this.personService.findRiskPersons(), HttpStatus.OK);
    }
}
