package com.example.covid.controllers;

import com.example.covid.dto.PersonDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.models.Person;
import com.example.covid.models.Repository;
import com.example.covid.models.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid")
public class CovidController {
    Repository repository = new Repository();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        List<SymptomDTO> symptoms = new ArrayList<>();
        for (Symptom symptom : repository.getSymtoms()){
            SymptomDTO symptomDTO = new SymptomDTO();
            symptomDTO.setName(symptom.getName());
            symptomDTO.setSeverityLevel(symptom.getSeverityLevel());
            symptoms.add(symptomDTO);
        }
        return new ResponseEntity<>(symptoms, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name){
        Optional<Symptom> symtom = repository.getSymtoms().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
        if (symtom.isEmpty()){
            return new ResponseEntity("No es un síntoma de covid", HttpStatus.NOT_FOUND);
        }
        String msg = "Nivel de gravedad: " + symtom.get().getSeverityLevel();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> findRiskPerson(){
        List<PersonDTO> persons = new ArrayList<>();
        for (Person person : repository.getPersons()){
            if (person.getAge() > 60 && person.getSymptoms().size() >= 1){
                PersonDTO personDTO = new PersonDTO();
                personDTO.setFullName(person.getName() + " " + person.getLastname());
                personDTO.setAge(person.getAge());
                personDTO.setSymptoms(person.getSymptomsString());
                persons.add(personDTO);
            }
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
