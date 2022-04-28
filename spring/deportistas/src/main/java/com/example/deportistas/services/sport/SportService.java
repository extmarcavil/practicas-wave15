package com.example.deportistas.services.sport;

import com.example.deportistas.model.Deporte;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface SportService {
    List<Deporte> findAll();
    Deporte findByName(String name);
    void addDeporte(Deporte d);
    void addAllDeportes(List<Deporte> deportes);
}
