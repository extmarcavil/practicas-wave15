package sport.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sport.exercise.dto.PersonDTO;
import sport.exercise.service.PersonServiceInterface;

import java.util.ArrayList;

@RestController
@RequestMapping("/findSportsPersons")
public class PersonController {

    private final PersonServiceInterface personService;

    public PersonController(PersonServiceInterface personService) {
        this.personService = personService;
    }

    @GetMapping
    ResponseEntity<ArrayList<PersonDTO>> showAllPersonWhoDoSports(){
        return new ResponseEntity<>(personService.getAllPersonsWhoDoSports(), HttpStatus.OK);
    }


}
