package com.example.demo.controller;

import com.example.demo.dto.NivelDTO;
import com.example.demo.dto.PersonaDeporteDTO;
import com.example.demo.model.Deporte;
import com.example.demo.service.IDeportistasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    IDeportistasService service;

    public DeportistasController(IDeportistasService service)
    {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(service.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> findSportsPersons(){
        return new ResponseEntity<>(service.getSportsPersons(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<NivelDTO> findSport (@PathVariable String name){
        NivelDTO n = service.getLevelBySport(name);

        if(n == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(n,HttpStatus.OK);
        }
    }

}
