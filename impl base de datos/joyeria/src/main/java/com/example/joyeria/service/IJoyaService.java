package com.example.joyeria.service;

import com.example.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    List<Joya> getJoyas();
    Long saveJoya(Joya joya);
    void deleteJoya(Long id);
    Joya findJoya(Long id);
    Joya updateJoya(Long id, Joya joya);
}
