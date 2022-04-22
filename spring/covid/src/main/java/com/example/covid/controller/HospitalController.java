package com.example.covid.controller;

import com.example.covid.dto.PersonDTO;
import com.example.covid.dto.SintomaDTO;
import com.example.covid.model.Person;
import com.example.covid.model.Sintoma;
import com.example.covid.repository.PersonRepository;
import com.example.covid.repository.SintomaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@RestController
public class HospitalController {
    SintomaRepository sintomaRepository = new SintomaRepository();
    PersonRepository personRepository = new PersonRepository();

    @GetMapping("/findSymptom")
    public ArrayList<Sintoma> getSintomas(){
        return sintomaRepository.getSintomaArrayList();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getByName(@PathVariable String name){
        Sintoma sintoma = sintomaRepository.findByName(name);
        return new ResponseEntity<>(new SintomaDTO(sintoma.getName() ,sintoma.getSeverityLvl()), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<ArrayList<PersonDTO>> getRiskPersons(){
        //Obtener la lista de personas
        HashMap<Person,ArrayList<String>> personsMap = personRepository.getPersons();
        ArrayList<PersonDTO> toRet = new ArrayList<>();

        Set<Person> personSet = personsMap.keySet();
        //recorrer cada persona
        for(Person person: personSet){
            //filtrar mayores de 60
            if(person.getAge()<60) continue;

            ArrayList<String> sintomasIDList =  personsMap.get(person);
            ArrayList<SintomaDTO> sintomas = new ArrayList<>();
            //recorrer su lista de sintomas (en este punto solo tengo los ID)
            for(String id: sintomasIDList){
                Sintoma sintoma = sintomaRepository.findById(id);
                if(sintoma == null) continue;

                sintomas.add(new SintomaDTO(sintoma.getName(),sintoma.getSeverityLvl()));
            }

            //CREAR EL DTO CON LOS DATOS CONSEGUIDOS y agregarlo a la lista
            PersonDTO personDTO = new PersonDTO(person.getName() + " " + person.getSurname(), sintomas);
            toRet.add(personDTO);
        }

        return new ResponseEntity<>(toRet,HttpStatus.OK);
    }
}
