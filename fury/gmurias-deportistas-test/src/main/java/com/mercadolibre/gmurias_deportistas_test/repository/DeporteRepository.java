package com.mercadolibre.gmurias_deportistas_test.repository;

import com.mercadolibre.gmurias_deportistas_test.dtos.DeporteDTO;
import com.mercadolibre.gmurias_deportistas_test.dtos.PersonaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DeporteRepository implements IDeporteRepository {

    List<DeporteDTO> deportes;
    List<PersonaDTO> personas;

    public DeporteRepository(){
        deportes = new ArrayList<>();
        personas = new ArrayList<>();
        cargarListas();
    }

    @Override
    public List<DeporteDTO> listarDeportes() {
        return deportes;
    }

    @Override
    public Optional<DeporteDTO> listarDeportePorNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public List<PersonaDTO> listarDeportistas() {
        List<PersonaDTO> personaDeportista = personas.stream()
                .filter(p -> p.practicaDeporte())
                .collect(Collectors.toList());
        return personaDeportista;
    }

    private void cargarListas(){
        DeporteDTO futbol = new DeporteDTO("Futbol", "Medio");
        DeporteDTO basket = new DeporteDTO("Basket", "Inicial");
        DeporteDTO rugby = new DeporteDTO("Rugby", "Inicial");
        DeporteDTO tenis = new DeporteDTO("Tenis", "Medio");
        DeporteDTO hockey = new DeporteDTO("Hockey", "Avanzado");

        PersonaDTO persona1 = new PersonaDTO("Gonzalo", "Murias", 35, Arrays.asList(futbol, basket));
        PersonaDTO persona2 = new PersonaDTO("Sandra", "Perez", 55, new ArrayList<>());
        PersonaDTO persona3 = new PersonaDTO("Juan Diego", "Martinez", 25, Arrays.asList(tenis, rugby));
        PersonaDTO persona4 = new PersonaDTO("Jorge", "Gonzalez", 45, Arrays.asList(hockey, tenis));
        PersonaDTO persona5 = new PersonaDTO("Romina", "Mendez", 15, Arrays.asList(hockey));

        this.personas.addAll(Arrays.asList(persona1, persona2, persona3, persona4, persona5));
        this.deportes.addAll(Arrays.asList(futbol, basket, rugby, tenis, hockey));


    }
}
