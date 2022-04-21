package com.example.deportistas.services.sport;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.repositories.DeporteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService{
    DeporteRepo deporteRepo = new DeporteRepo();
    @Override
    public List<Deporte> findAll() {
        return deporteRepo.getDeporteList() ;
    }

    @Override
    public Deporte findByName(String name) {
        return deporteRepo.getDeporteList().stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst().orElseThrow();
    }

    @Override
    public void addDeporte(Deporte d) {
        deporteRepo.addDeporte(d);
    }

    @Override
    public void addAllDeportes(List<Deporte> deportes) {
        deporteRepo.addAll(deportes);
    }
}
