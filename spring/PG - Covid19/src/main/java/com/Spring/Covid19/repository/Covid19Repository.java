package com.Spring.Covid19.repository;

import com.Spring.Covid19.dto.PersonaDTO;
import com.Spring.Covid19.dto.SintomaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class Covid19Repository implements ICovid19Repository {

    private List<SintomaDTO> sintomas;
    private List<PersonaDTO> personas;

    public Covid19Repository(){
     sintomas = new ArrayList<>();
     personas = new ArrayList<>();
     cargarDatos();
    }

    @Override
    public List<SintomaDTO> listarSintomas() {
        return sintomas;
    }

    @Override
    public Optional<SintomaDTO> listarSintomaPorNombre(String nombre) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public List<PersonaDTO> listarSintomaticos() {
        List<PersonaDTO> sintomaticos = personas.stream()
                .filter(p -> p.tieneSintomas() && p.esMayor())
                .collect(Collectors.toList());
        return sintomaticos;
    }

    public void cargarDatos(){
        SintomaDTO sintoma1 = new SintomaDTO(1, "Fiebre", "Bajo");
        SintomaDTO sintoma2 = new SintomaDTO(2, "Tos", "Bajo");
        SintomaDTO sintoma3 = new SintomaDTO(3, "Dolor de cabeza", "Bajo");
        SintomaDTO sintoma4 = new SintomaDTO(4, "Dificultad respiratoria", "Alto");
        SintomaDTO sintoma5 = new SintomaDTO(5, "Cansancio muscular", "Medio");

        PersonaDTO persona1 = new PersonaDTO(1,"Gonzalo", "Murias", 28, new ArrayList<>());
        PersonaDTO persona2 = new PersonaDTO(2,"Diego Armando", "Maradona", 60, Arrays.asList(sintoma1, sintoma2, sintoma3));
        PersonaDTO persona3 = new PersonaDTO(3,"Marcelo", "Gallardo", 47, Arrays.asList(sintoma3, sintoma5));
        PersonaDTO persona4 = new PersonaDTO(4,"Angel", "Labruna", 68, Arrays.asList(sintoma1, sintoma2));
        PersonaDTO persona5 = new PersonaDTO(5,"Martina", "Perez", 49, Arrays.asList(sintoma5));

        this.sintomas.addAll(Arrays.asList(sintoma1, sintoma2, sintoma3, sintoma4, sintoma5));
        this.personas.addAll(Arrays.asList(persona1, persona2, persona3, persona4, persona5));

    }
}
