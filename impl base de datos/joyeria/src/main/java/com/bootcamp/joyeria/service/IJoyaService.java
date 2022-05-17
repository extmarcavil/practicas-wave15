package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    String saveJoya(Joya joya);
    List<Joya> getJoyas();
    Joya findJoya(Long id);
    String deleteJoya(Long id);
    String editJoya(Long id, Joya joya);
}
