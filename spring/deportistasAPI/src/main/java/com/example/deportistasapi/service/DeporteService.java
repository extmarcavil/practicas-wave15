package com.example.deportistasapi.service;

import com.example.deportistasapi.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService implements IDeporteService {
    List<Deporte> deportes = new ArrayList<>();

    public DeporteService() {
        Deporte futbol = new Deporte();
        futbol.setNombre("Futbol");
        futbol.setNivel(9);

        Deporte basquet = new Deporte();
        basquet.setNombre("Básquet");
        basquet.setNivel(6);

        Deporte voley = new Deporte();
        voley.setNombre("Voley");
        voley.setNivel(7);

        Deporte tenis = new Deporte();
        tenis.setNombre("Tenis");
        tenis.setNivel(4);

        this.deportes.add(futbol);
        this.deportes.add(basquet);
        this.deportes.add(voley);
        this.deportes.add(tenis);
    }

    public List<Deporte> findAllSports() {
        return this.deportes;
    }

    public Optional<Deporte> findSportByName(String name) {
        return this.deportes
                .stream()
                .filter(d -> d.getNombre().equals(name))
                .findFirst();
    }
}
