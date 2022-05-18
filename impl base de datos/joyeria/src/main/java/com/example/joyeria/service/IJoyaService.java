package com.example.joyeria.service;

import com.example.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    /**
     * Metodos
     *
     * @return
     */
    List<Joya> getJoyas();

    String saveJoya(Joya joya);

    String deleteJoya(Long id);

    Joya findById(Long id);

    Joya update(Joya joya);
}
