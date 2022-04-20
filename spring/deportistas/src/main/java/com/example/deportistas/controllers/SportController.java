package com.example.deportistas.controllers;

import com.example.deportistas.dto.PersonDTO;
import com.example.deportistas.models.Person;
import com.example.deportistas.models.Repository;
import com.example.deportistas.models.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SportController {
    Repository repository = new Repository();

    @GetMapping("/findSports")
    public List<Sport> findSports(){
        return repository.getSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        Optional<Sport> sport = repository.getSports().stream()
                .filter(s -> s.getName().toLowerCase().equals(name.toLowerCase())).findFirst();
        if (sport.isEmpty()){
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }
        String msg = "Nivel: " + sport.get().getLevel();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<PersonDTO> findSportsPersons(){
        List<PersonDTO> persons = new ArrayList<>();
        for (Person person : repository.getPersons()){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setPersonFullName(person.getName() + " " + person.getLastName());
            personDTO.setSportName(person.getSport().getName());
            persons.add(personDTO);
        }
        return persons;
    }
}
