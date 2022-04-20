package com.example.ejerciciocovid.controller;

import com.example.ejerciciocovid.dto.DTOPersonaDeRiesgo;
import com.example.ejerciciocovid.entities.Persona;
import com.example.ejerciciocovid.entities.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EjercicioCovidController {

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom(){
        List<Sintoma> sintomas = new ArrayList<Sintoma>();
        sintomas.add(new Sintoma(1, "Dolor de espalda", "Bajo"));
        sintomas.add(new Sintoma(2, "Dolor de muela", "Medio"));
        sintomas.add(new Sintoma(3, "Covid", "Alto"));
        return sintomas;
    }


    @GetMapping("/findSymptom/{name}")
    ResponseEntity<String> findSymptomByName(@PathVariable String name){
        Sintoma sintoma = sintomas.stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst().orElse(null);

        if (sintoma != null)
            return ResponseEntity.status(200).body("Nivel de gravedad: " + sintoma.getNivel_de_gravedad());
        else
            return ResponseEntity.badRequest().body("No existe el sintoma.");
    }


    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<DTOPersonaDeRiesgo> findRiskPerson(){
        List<DTOPersonaDeRiesgo> personasDeRiesgo = new ArrayList<>();

        personas.stream()
                .filter(x -> x.getEdad() > 59).collect(Collectors.toList())
                .forEach(x -> personasDeRiesgo.add(new DTOPersonaDeRiesgo(x.getNombre(), x.getApellido())));

        return personasDeRiesgo;
    }

    public static List<Sintoma> sintomas;
    static {
        sintomas = new ArrayList<Sintoma>();
        sintomas.add(new Sintoma(1, "Golpe en el pie", "Bajo"));
        sintomas.add(new Sintoma(2, "Dolor de muela", "Medio"));
        sintomas.add(new Sintoma(3, "Covid", "Alto"));
    }

    public static List<Persona> personas;
    static {
        personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Julio", "Ferreira", 65));
        personas.add(new Persona(2, "Milagros", "Carranza", 23));
        personas.add(new Persona(3, "Sandra", "Sanchez", 70));
    }
}
