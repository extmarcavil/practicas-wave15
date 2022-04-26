package com.example.deportistas.controllers;

import com.example.deportistas.dtos.DeporteDTO;
import com.example.deportistas.dtos.NivelDeporteDTO;
import com.example.deportistas.dtos.NombreDeporteDTO;
import com.example.deportistas.dtos.PersonaDeporteDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.services.person.PersonService;
import com.example.deportistas.services.sport.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class DeportistasController {

    @Autowired
    SportService sportService;

    @Autowired
    PersonService personService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findAllSports(){
        List<Deporte> deportes = sportService.findAll();
        List<DeporteDTO> deportesDTO = new ArrayList<>();
        for (Deporte d: deportes) {
            DeporteDTO deporteDTO = new DeporteDTO(d.getNombre(), d.getNivel());
            deportesDTO.add(deporteDTO);
        }
        return ResponseEntity.ok(deportesDTO);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<NivelDeporteDTO> findSport(@PathVariable String name){
        try {
            Deporte d = sportService.findByName(name);
            return ResponseEntity.ok(new NivelDeporteDTO(d.getNivel()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> findAllPersonsWithSports(){
        List<Persona> personas = personService.findAll();
        List<PersonaDeporteDTO> personasDeporteDTO = new ArrayList<>();
        for (Persona p: personas) {
            List<NombreDeporteDTO> nombreDeporteDTOList = new ArrayList<>();
            for(Deporte d: p.getDeporteList()){
                NombreDeporteDTO nombreDeporteDTO = new NombreDeporteDTO(d.getNombre());
                nombreDeporteDTOList.add(nombreDeporteDTO);
            }
            PersonaDeporteDTO pdDTO = new PersonaDeporteDTO(p.getNombre(), p.getApellido(), nombreDeporteDTOList);
            personasDeporteDTO.add(pdDTO);
        }
        return ResponseEntity.ok(personasDeporteDTO);
    }

}
