package com.bootcamp.joyeriaLasPerlas.service;

import com.bootcamp.joyeriaLasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    String saveJoya(Joya joya);
    List<Joya> getJoyas();
    Joya findJoya(Long id);
    String deleteJoya(Long id);
    String editJoya(Long id_modificar, Joya joya_modif);
}
