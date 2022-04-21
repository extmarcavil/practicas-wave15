package com.example.deportistas.controller;

import com.example.deportistas.model.DeportistasDTO;
import com.example.deportistas.model.Person;
import com.example.deportistas.model.Sport;
import com.example.deportistas.repository.DeportistasRepository;
import com.example.deportistas.repository.PersonRepository;
import com.example.deportistas.repository.SportsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@RestController
public class PersonController {
    private SportsRepository sportsRepository = new SportsRepository();
    private PersonRepository personRepository = new PersonRepository();
    private DeportistasRepository deportistasRepository = new DeportistasRepository();

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ArrayList<DeportistasDTO>> getDeportistas(){
        ArrayList<DeportistasDTO> toRet = new ArrayList<>();

        HashMap<String,ArrayList<String>> deportistas = deportistasRepository.getDeportistas();

        Set<String> keys = deportistas.keySet();
        //TODO debbugear esto
        for(String personId:keys){
            Person person = personRepository.getById(personId);
            ArrayList<String> values = deportistas.get(personId);
            ArrayList<String> sportsNames = new ArrayList<>();

            for (String sportId: values){
                Sport sport = sportsRepository.findById(sportId);
                sportsNames.add(sport.getName());
            }

            DeportistasDTO deportistaDTO = new DeportistasDTO(person.getName(),person.getSurname(),sportsNames);
            toRet.add(deportistaDTO);
        }

        System.out.println(toRet);

        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }
}
