package com.example.crudjoyeria.service;

import com.example.crudjoyeria.model.Joya;

import java.util.List;

public interface IJoyeriaService {
    List<Joya> getJoyas();
    Joya saveJoya(Joya joya);
    void deleteJoya(long id);
    Joya findJoya(long id);
    Joya updateJoya(Long id, Joya joya);
}
