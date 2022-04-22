package searcher.covid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searcher.covid.service.PersonServiceInterface;
import searcher.covid.dto.PersonDTO;

import java.util.ArrayList;

@RestController
@RequestMapping("/findRiskPerson")
public class PersonController {

    private final PersonServiceInterface personService;

    public PersonController(PersonServiceInterface personService) {
        this.personService = personService;
    }

    @GetMapping
    ResponseEntity<ArrayList<PersonDTO>> showAllPersonInRiskGroup(){
        return new ResponseEntity<>(personService.getAllPersonsInRiskGroup(), HttpStatus.OK);
    }


}
