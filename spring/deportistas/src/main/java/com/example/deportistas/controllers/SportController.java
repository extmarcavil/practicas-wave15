package com.example.deportistas.controllers;

import com.example.deportistas.dto.PersonDTO;
import com.example.deportistas.models.Person;
import com.example.deportistas.models.Repository;
import com.example.deportistas.models.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportController {
    Repository repository = new Repository();

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports(){
        return new ResponseEntity<>(repository.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        Optional<Sport> sport = repository.getSports().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
        if (sport.isEmpty()){
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Nivel: " + sport.get().getLevel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons(){
        List<PersonDTO> persons = new ArrayList<>();
        for (Person person : repository.getPersons()){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setPersonFullName(person.getName() + " " + person.getLastName());
            personDTO.setSportName(person.getSport().getName());
            persons.add(personDTO);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
