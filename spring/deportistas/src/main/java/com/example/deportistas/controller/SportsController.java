package com.example.deportistas.controller;

import com.example.deportistas.model.Sport;
import com.example.deportistas.repository.SportsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*Ver todos los deportes que tenemos cargados.
        PATH: /findSports
Consultar si existe un deporte ingresando su nombre.
De existir, se deberá mostrar el nivel del mismo.
Utilizar la clase ResponseEntity para devolver la respuesta.
        PATH: /findSport/{name}*/

@RestController
public class SportsController {
    SportsRepository sportsRepository = new SportsRepository();
    @GetMapping("/findSports")
    @ResponseBody
    public ArrayList<Sport> getAll(){

        return sportsRepository.getSports();
    }

    @GetMapping("/sports/{name}")
    public ResponseEntity<Sport> get(@PathVariable String name){
        Sport sport = sportsRepository.findByName(name);
        if(sport == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(sport, HttpStatus.OK);
    }
}
