package com.spring.deportistas.controller;

import com.spring.deportistas.dto.DeporteDTO;
import com.spring.deportistas.dto.PersonaDeportistaDTO;
import com.spring.deportistas.model.Deporte;
import com.spring.deportistas.repository.DeportistasImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DeportistasController {

    private DeportistasImpl deportistas = new DeportistasImpl();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findAllSports() {
        List<DeporteDTO> deportes = deportistas.getDeportes().stream().map(
                deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Integer> findSport(@PathVariable String name) {
        Optional<Deporte> deporteEncontrado = deportistas.getDeportes().stream().filter(
                deporte -> deporte.getNombre().equals(name)).findFirst();

        if(deporteEncontrado.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(deporteEncontrado.get().getNivel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        List<PersonaDeportistaDTO> personasDeportistas = deportistas.getPersonas().stream().map(
                persona -> new PersonaDeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }


}
