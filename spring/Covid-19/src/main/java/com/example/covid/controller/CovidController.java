package com.example.covid.controller;

import com.example.covid.dto.PersonaDTO;
import com.example.covid.dto.SintomaDTO;
import com.example.covid.dto.SintomaGravedadDTO;
import com.example.covid.model.Persona;
import com.example.covid.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CovidController {

    List<Sintoma> sintomas = createSintomas();
    List<Persona> personas = createPersonas();


    private List<Sintoma> createSintomas() {
        List<Sintoma> sintomas = new ArrayList<>();
        Sintoma s = new Sintoma(1, "Dolor de cabeza", "BAJO");
        sintomas.add(s);
        s = new Sintoma(2, "Dolor de cuerpo", "BAJO");
        sintomas.add(s);
        s = new Sintoma(3, "Dolor de garganta", "ALTO");
        sintomas.add(s);
        s = new Sintoma(4, "Mareos", "MEDIO");
        sintomas.add(s);
        s = new Sintoma(5, "Fiebre","MEDIO");
        sintomas.add(s);
        s = new Sintoma(6, "Vomito", "ALTO");
        sintomas.add(s);
        return sintomas;
    }

    private List<Persona> createPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona p = new Persona(1, "Tomas", "Ravelli",24);
        p.addSintoma(findSintomaByNombre("Fiebre").get());
        p.addSintoma(findSintomaByNombre("vomito").get());
        personas.add(p);
        p = new Persona(2, "Juan", "Perez",55);
        personas.add(p);
        p = new Persona(3, "Antonio", "Perez",24);
        personas.add(p);
        p = new Persona(4, "Juan", "X",65);
        personas.add(p);
        p = new Persona(5, "Pedro", "Garcias",74);
        p.addSintoma(findSintomaByNombre("Fiebre").get());
        p.addSintoma(findSintomaByNombre("vomito").get());
        personas.add(p);
        p = new Persona(6, "Roberto", "Sanchez",85);
        p.addSintoma(findSintomaByNombre("Fiebre").get());
        p.addSintoma(findSintomaByNombre("vomito").get());
        personas.add(p);
        return personas;
    }

    private Optional<Sintoma> findSintomaByNombre(String nombre) {
        return sintomas.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findAllSintomas(){
        List<SintomaDTO> resultado = new ArrayList<>();
        for(Sintoma s: sintomas){
            SintomaDTO sintomaDTO = new SintomaDTO(s.getCodigo(), s.getNombre(), s.getNivelDeGravedad());
            resultado.add(sintomaDTO);
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaGravedadDTO> findSintomaNombre(@PathVariable String nombre){
        Optional<Sintoma> sintomaOptional = findSintomaByNombre(nombre);
        if(sintomaOptional.isPresent()){
            return ResponseEntity.ok(new SintomaGravedadDTO(sintomaOptional.get().getNivelDeGravedad()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findPersonasRiesgo(){
        ArrayList<Persona> personasList = (ArrayList<Persona>) personas.stream().filter(p -> p.getEdad() > 60 && p.getSintomas().size() > 0).collect(Collectors.toList());
        List<PersonaDTO> resultado = new ArrayList<>();
        for (Persona p: personasList){
            PersonaDTO personaDTO = new PersonaDTO(p.getNombre(), p.getApellido());
            resultado.add(personaDTO);
        }
        return ResponseEntity.ok(resultado);
    }
}
