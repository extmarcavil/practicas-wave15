package com.example.ejerciciocovid.controller;

import com.example.ejerciciocovid.dto.DTOPersonaDeRiesgo;
import com.example.ejerciciocovid.model.Persona;
import com.example.ejerciciocovid.model.Sintoma;
import com.example.ejerciciocovid.service.PersonaService;
import com.example.ejerciciocovid.service.SintomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class EjercicioCovidController {

    public SintomaService sintomaService = new SintomaService();
    public PersonaService personaService = new PersonaService();

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom(){
        return sintomaService.getSintomasList();
    }


    @GetMapping("/findSymptom/{name}")
    ResponseEntity<String> findSymptomByName(@PathVariable String name){
        Sintoma sintoma = sintomaService.getSintomaByName(name);

        if (sintoma != null)
            return ResponseEntity.status(200).body("Nivel de gravedad: " + sintoma.getNivel_de_gravedad());
        else
            return ResponseEntity.badRequest().body("No existe el sintoma.");
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<DTOPersonaDeRiesgo> findRiskPerson(){
        List<DTOPersonaDeRiesgo> personasDeRiesgo = new ArrayList<>();

        personaService.getPersonasList().stream()
                .filter(x -> x.getEdad() > 59).collect(Collectors.toList())
                .forEach(x -> personasDeRiesgo.add(new DTOPersonaDeRiesgo(x.getNombre(), x.getApellido())));

        return personasDeRiesgo;
    }

}
