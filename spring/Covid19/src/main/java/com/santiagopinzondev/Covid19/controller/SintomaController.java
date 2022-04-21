package com.santiagopinzondev.Covid19.controller;

import com.santiagopinzondev.Covid19.PersonaSintomaDTO;
import com.santiagopinzondev.Covid19.PersonasDTO;
import com.santiagopinzondev.Covid19.Sintoma;
import com.santiagopinzondev.Covid19.Sintomas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SintomaController {
    @GetMapping("/findSintoma")
    public List<Sintoma> showSintomas(){
        return Sintomas.getSintomas();
    }

    @GetMapping("/findSintoma/{name}")
    ResponseEntity<String> findSintoma(@PathVariable String name){
        for (Sintoma sinto: Sintomas.getSintomas()) {
            if (sinto.getNombre().equals(name)){
                return new ResponseEntity<>("El nivel de gravedad es: " + sinto.getNivelDeGravedad(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("El sintoma no se encuentra", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaSintomaDTO> findRiskPerson(){
        return PersonasDTO.getPersonas().stream().filter(p -> p.getEdad() > 60).collect(Collectors.toList());
    }
}
