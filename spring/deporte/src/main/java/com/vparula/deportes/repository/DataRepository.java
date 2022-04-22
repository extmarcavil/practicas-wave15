package com.vparula.deportes.repository;

import com.vparula.deportes.model.Deporte;
import com.vparula.deportes.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class DataRepository implements IDataRepository {
    List<Persona> personas;
    List<Deporte>  deportes;

    public DataRepository() {
        personas = new ArrayList<>();
        deportes   = new ArrayList<>();
        initData();
    }
    @Override
    public List<Deporte> getAllDeportes() {
        return deportes;
    }

    @Override
    public Optional<Deporte> getDeportePorNombre(String nombre) {
        return deportes.stream()
                .filter(s -> s.getNombre()
                        .equals(nombre))
                .findFirst();


    }

    @Override
    public List<Persona> getDeportistas() {
        List<Persona> deportistas = personas.stream()
                .filter(p -> p.haceDeportes())
                .collect(Collectors.toList());
        return deportistas;
    }


    private void initData () {
        Deporte d1 = new Deporte("Futbol", "Basico");
        Deporte d2 = new Deporte("Futbol", "Avanzado");
        Deporte d3 = new Deporte("Basket", "Avanzado");
        Deporte d4 = new Deporte("Voley", "Avanzado");
        Deporte d5 = new Deporte("Basket", "Medio");
        Deporte d6 = new Deporte("Voley", "Basico");
        Deporte d7 = new Deporte("Futbol", "Medio");
        Deporte d8 = new Deporte("Windsurf", "Medio");
        Deporte d9 = new Deporte("Tenis", "Pro");
        List<Deporte> lista1 = new ArrayList<>();
        List<Deporte> lista2 = new ArrayList<>();
        List<Deporte> lista3 = new ArrayList<>();
        lista1.add(d7);
        lista2.addAll(Arrays.asList(d1,d2,d3,d4,d5,d7,d8,d9));
        lista3.addAll(Arrays.asList(d2,d4,d8));

        Persona p1   = new Persona("PEPE", "GRILLO", 7,null);
        Persona p2   = new Persona("JUAN", "GRILLO", 7,lista1);
        Persona p3   = new Persona("MIGUEL", "GRILLO", 7,lista2);
        Persona p4   = new Persona("JOSE", "GRILLO", 7,lista3);


        this.personas.addAll(Arrays.asList(p1,p2,p3,p4));
        this.deportes.addAll(Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9));
    }
}
