package com.example.joyeria.service;

import com.example.joyeria.model.Joya;

import java.util.List;

public interface IJoyasService {

    Joya saveJoya(Joya j);
    void deleteJoya(long id);
    Joya findJoya(long id);
    List<Joya> getJoyas();
}
