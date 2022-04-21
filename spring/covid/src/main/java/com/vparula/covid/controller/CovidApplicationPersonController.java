package com.vparula.covid.controller;

import com.vparula.covid.dto.PersonaDTO;
import com.vparula.covid.dto.SintomasDTO;
import com.vparula.covid.entidades.Persona;
import com.vparula.covid.entidades.Sintoma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("/findRiskPerson")
public class CovidApplicationPersonController {

    @GetMapping("/")
    public List<PersonaDTO> getSintomas(){
        List<SintomasDTO> sintomas = new ArrayList<>();
        List<Persona> personasRiesgo =personas.stream()
                .filter(s->s.getEdad()>=60 && s.getSintomas()!=null)

                .collect(Collectors.toList());
        List<PersonaDTO> devuelvo =personasRiesgo.stream()
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());

        return devuelvo;

    }

    public static List<Persona> personas = new ArrayList<>();
    static {

        List<Sintoma> sintomas1 = new ArrayList<>();
        sintomas1.add(new Sintoma(2,"Resfrio","Moderado"));
        List<Sintoma> sintomas2 = new ArrayList<>();
        sintomas2.add(new Sintoma(3,"Dolor de garganta","No tan grave"));
        sintomas2.add(new Sintoma(4,"Cansancio","Moderado"));

        personas.add(new Persona(1,"Pepe","Grillo",65,null));
        personas.add(new Persona(2,"Juan","Jose",55,sintomas1));
        personas.add(new Persona(3,"Sapo","Pepe",63,sintomas2));
        personas.add(new Persona(4,"Luis","Alberto",45,null));
        personas.add(new Persona(5,"Otro","Mas",60,sintomas1));


    }
}
