package com.example.deportistas.repositories;

import com.example.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteRepo {
    void addDeporte(Deporte d);
    void addAll(List<Deporte> deportes);
    List<Deporte> getDeporteList();
}
