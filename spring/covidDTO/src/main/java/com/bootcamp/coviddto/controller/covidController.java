package com.bootcamp.coviddto.controller;

import com.bootcamp.coviddto.Persona;
import com.bootcamp.coviddto.Sintoma;
import com.bootcamp.coviddto.dtos.SintomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class covidController {
    //Esto deberia ser reemplazado por un repositorio singleton, pero considero que no es parte del alcance del ejercicio
    static List<Sintoma> sintomas = new ArrayList<>();
    static List<Persona> personas = new ArrayList<>();

    static {
        sintomas.add(new Sintoma(0, "Fiebre", 8));
        sintomas.add(new Sintoma(1, "Dolor de Cabeza", 5));
        sintomas.add(new Sintoma(2,"Bajo nivel de saturacion",10));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> verSintomas() {
        List<SintomaDTO> lista = new ArrayList<>();

        sintomas.forEach(s -> lista.add(new SintomaDTO(s.getNombre(), s.getNivelGravedad())));

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String name) {
        Optional<Sintoma> sintoma = sintomas.stream().filter(s -> s.getNombre().equals(name)).findFirst();

        if(sintoma.isEmpty())
            return ResponseEntity.badRequest().body("Ese sintoma no se encuentra disponible");

        return ResponseEntity.ok(String.valueOf(sintoma.get().getNivelGravedad()));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Persona>> buscarPersonasRiesgo() {
        //habria q cargarles sitomas a las personas, y hacer un filter de personas que tengann sintomas de covid que sean mayores de 60
        //luego devolver un dto con solo nombre y apellido , se le podrian agregar los sintomas
        return ResponseEntity.ok(personas);
    }
}
